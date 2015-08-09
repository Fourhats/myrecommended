package com.myrecommended.services.utils;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.rmi.server.UID;
import java.util.Iterator;
import java.util.List;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import org.apache.commons.io.FilenameUtils;
import org.imgscalr.Scalr;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.myrecommended.models.UploadedFile;

public class FileHelper {
	
	public static byte[] bufferedImageToByte(BufferedImage bufferedImage, String formatName) throws Exception{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try{
			ImageIO.write(bufferedImage, formatName, baos);
			baos.flush();
			byte[] imageBytes = baos.toByteArray();
			return imageBytes;
		}catch(Exception e){
			throw e;
		}finally{
			baos.close();
		}
	}
	
	public static BufferedImage multipartFileToBufferedImage(MultipartFile file) throws Exception{
		InputStream in = null;
		BufferedImage bufferedImage = null;
		try{
			in = new ByteArrayInputStream(file.getBytes());
			bufferedImage = ImageIO.read(in);
			return bufferedImage;
		}catch(Exception e){
			throw e;
		}finally{
			in.close();
			if(bufferedImage != null){
				bufferedImage.flush();
			}
		}
	}
	
	public static void generateImages2(byte[] compressedImageBytes, String tempPath, String generatedFileName, List<ImageInfo> imagesInfo) throws Exception {
		InputStream in = null;
		BufferedImage compressedBufferedImage = null;
		try{
			in = new ByteArrayInputStream(compressedImageBytes);
			compressedBufferedImage = ImageIO.read(in);
			for(ImageInfo imageInfo : imagesInfo){
				
				//Resize image
				BufferedImage resizedImage = Scalr.resize(compressedBufferedImage, Scalr.Method.QUALITY, Scalr.Mode.AUTOMATIC, imageInfo.getWidth(), imageInfo.getHeight(), Scalr.OP_ANTIALIAS, Scalr.OP_BRIGHTER);
				byte[] imageBytes = bufferedImageToByte(resizedImage, "jpeg");
						
				String productImgPath = FileHelper.getFullPath(tempPath, imageInfo.getFolder(), generatedFileName);
				FileCopyUtils.copy(imageBytes, new FileOutputStream(productImgPath));
			}
		}catch(Exception e){
			throw e;
		}finally{
			if(in != null){
				in.close();
			}
			if(compressedBufferedImage != null){
				compressedBufferedImage.flush();
			}
		}
		
	}
	
	@SuppressWarnings("resource")
	public static void copyFile(String src, String dst) throws IOException{
//		File file =new File(source);
//		file.renameTo(new File(destination));
		File sourceFile = new File(src);
		File destFile = new File(dst);
		
		FileChannel source = null;
        FileChannel destination = null;
        try {
            source = new FileInputStream(sourceFile).getChannel();
            destination = new FileOutputStream(destFile).getChannel();

            // previous code: destination.transferFrom(source, 0, source.size());
            // to avoid infinite loops, should be:
            long count = 0;
            long size = source.size();
            while ((count += destination.transferFrom(source, count, size - count)) < size);
        } finally {
            if (source != null) {
                source.close();
            }
            if (destination != null) {
                destination.close();
            }
        }
	}
	
	public static UploadedFile getUploadedFile(MultipartHttpServletRequest request, String tempPath) throws IOException {
		MultipartFile mpf = request.getFile("imageToCrop");
		
		String x1 = request.getParameter("x1");
		String y2 = request.getParameter("y1");
		String w1 = request.getParameter("w");
		String h1 = request.getParameter("h");
		
		int x = Math.round(Float.parseFloat(x1));
        int y = Math.round(Float.parseFloat(y2));
        int w = Math.round(Float.parseFloat(w1));
        int h = Math.round(Float.parseFloat(h1));
        
		String generatedFileName = cutImage(mpf, x, y, w, h, tempPath);

        UploadedFile uploadedFile = new UploadedFile();
        uploadedFile.setName(generatedFileName);
       return uploadedFile;
	}
	
	
	//hecho para poder modificar en un solo lugar el UID() y asi poder trabajar en windows
	public static String getUniqueImageName(String imageName) {
		String extension = FilenameUtils.getExtension(imageName);
		String uniqueName = new UID().toString();
		return imageName;
//		return String.format("%s.%s", uniqueName, extension);
	}
	
	
	public static byte[] compress(String sourcePath, float quality) throws Exception{
		File imageFile = new File(sourcePath);
		
		InputStream is = new FileInputStream(imageFile);
		BufferedImage image = null;
		ImageOutputStream ios = null;
		ImageWriter writer = null;
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream(32768);
		try{
			//create a bufferedimage as the result of decoding the supplied InputStream.
			image = ImageIO.read(is);
			
			// get all image writers for JPG format.
			Iterator<ImageWriter> writers = ImageIO.getImageWritersBySuffix("jpeg");
			if(!writers.hasNext()){
				throw new IllegalStateException("No writers found");
			}
			
			writer = (ImageWriter)writers.next();
			ios = ImageIO.createImageOutputStream(bos);
			writer.setOutput(ios);
			
			ImageWriteParam param = writer.getDefaultWriteParam();
			
			// compress to a given quality.
			param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
			param.setCompressionQuality(quality);
			
			// appends a complete image stream containing a single image and associated stream and image metadata and thumbnails to the output.
			writer.write(null, new IIOImage(image, null, null), param);
			return bos.toByteArray();
		}catch(Exception e){
			throw e;
		}finally{
			is.close();
			bos.close();
			if(ios != null){
				ios.close();
			}
			if(image != null){
				image.flush();
			}
			if(writer != null){
				writer.dispose();
			}
		}
	}
	
	
	public static String getFullPath(String parent, String child, String fileName){
		File directory = new File(parent,child);
		if(!directory.exists()){
			//TODO: si no se pudo crear el directorio lanzar excepcion.
			directory.mkdir();
		}
		
		return new File(directory.getAbsolutePath(), fileName).getAbsolutePath();
	}
	
	public static void convertToJPG(String srcImgPath, String targetImgPath){
		BufferedImage bufferedImage = null;
		BufferedImage newBufferedImage = null;
		try{
			bufferedImage = ImageIO.read(new File(srcImgPath));
			newBufferedImage = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
			newBufferedImage.getGraphics().drawImage(bufferedImage, 0, 0, Color.WHITE, null);
			ImageIO.write(newBufferedImage, "jpg", new File(targetImgPath));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(bufferedImage != null){
				bufferedImage.flush();
			}
			if(newBufferedImage != null){
				newBufferedImage.flush();
			}
		}
	}
	
	
	private static String cutImage(MultipartFile mpf, int x1, int y1, int w, int h, String tempPath) throws IOException {
		InputStream in = new ByteArrayInputStream(mpf.getBytes());
		BufferedImage bImageFromConvert = ImageIO.read(in);
		
		BufferedImage out = bImageFromConvert.getSubimage(x1, y1, w, h);
        String type = mpf.getContentType().replace("image/", "");
        String generatedFileName = getUniqueImageName(mpf.getOriginalFilename());
		ImageIO.write(out, type, new File(tempPath, generatedFileName));
		return generatedFileName;
	}
	
}
