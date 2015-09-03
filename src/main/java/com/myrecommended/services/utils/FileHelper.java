package com.myrecommended.services.utils;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FilenameUtils;
import org.imgscalr.Scalr;
import org.springframework.util.FileCopyUtils;

public class FileHelper {
	private final static String SMALL_IMAGE_FOLDER = "small";
	private final static String MEDIUM_IMAGE_FOLDER = "medium";
	private final static String LARGE_IMAGE_FOLDER = "large";
	private final static String ORIGINAL_IMAGE_FOLDER = "originals";
	
	public static String getUniqueImageName(String imageName, boolean isLocal) {
		if (isLocal) {
			return imageName;	
		} else {
			String extension = FilenameUtils.getExtension(imageName);
			String uniqueName = new UID().toString();
			return String.format("%s.%s", uniqueName, extension);
		}
	}
	
	public static void convertToJPG(String srcImgPath, String targetImgPath) {
		BufferedImage bufferedImage = null;
		BufferedImage newBufferedImage = null;
		try {
			bufferedImage = ImageIO.read(new File(srcImgPath));
			newBufferedImage = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
			newBufferedImage.getGraphics().drawImage(bufferedImage, 0, 0, Color.WHITE, null);
			ImageIO.write(newBufferedImage, "jpg", new File(targetImgPath));
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(bufferedImage != null) {
				bufferedImage.flush();
			}
			if(newBufferedImage != null) {
				newBufferedImage.flush();
			}
		}
	}
	
	public static String getFullPath(String parent, String child, String fileName) {
		File directory = new File(parent, child);
		if (!directory.exists()) {
			//TODO: si no se pudo crear el directorio lanzar excepcion.
			directory.mkdir();
		}
		
		return new File(directory.getAbsolutePath(), fileName).getAbsolutePath();
	}
	
	public static byte[] bufferedImageToByte(BufferedImage bufferedImage, String formatName) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(bufferedImage, formatName, baos);
			baos.flush();
			byte[] imageBytes = baos.toByteArray();
			return imageBytes;
		} catch(Exception e) {
			throw e;
		} finally {
			baos.close();
		}
	}
	
	@SuppressWarnings("resource")
	public static void copyFile(String src, String dst) throws IOException {
		File sourceFile = new File(src);
		File destFile = new File(dst);
		
		FileChannel source = null;
        FileChannel destination = null;
        try {
            source = new FileInputStream(sourceFile).getChannel();
            destination = new FileOutputStream(destFile).getChannel();

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
	
	public static void generateImagesWithDifferentSizes(List<String> imageNames, String tempPath, String tempFolder, String targetPath) throws IOException, Exception,FileNotFoundException {
		for(String imageName : imageNames) {
			generateImagesWithDifferentSizes(imageName, tempPath, tempFolder, targetPath);
		}
	}

	public static void generateImagesWithDifferentSizes(String imageName, String tempPath, String tempFolder, String targetPath) throws IOException, Exception,FileNotFoundException {
		if(imageName == null) {
			return;
		}
		
		List<ImageInfo> imagesInfo = new ArrayList<ImageInfo>();
			
		BufferedImage tempImageSrc = null;
		try {
			File tempDirectory = new File(tempPath, tempFolder);
			File tempFile = new File(tempDirectory.getAbsolutePath(), imageName);
			tempImageSrc = ImageIO.read(tempFile);
			
			int smallWidth = tempImageSrc.getWidth() < 125 ? tempImageSrc.getWidth() : 125;
			int smallHeight = tempImageSrc.getHeight() < 100 ? tempImageSrc.getHeight() : 100;
			
			int mediumWidth = tempImageSrc.getWidth() < 410 ? tempImageSrc.getWidth() : 410;
			int mediumHeight = tempImageSrc.getHeight() < 270 ? tempImageSrc.getHeight() : 270;
			
			imagesInfo.add(new ImageInfo(SMALL_IMAGE_FOLDER, smallWidth, smallHeight));
			imagesInfo.add(new ImageInfo(MEDIUM_IMAGE_FOLDER, mediumWidth, mediumHeight));
			
			byte [] imageBytes = FileHelper.bufferedImageToByte(tempImageSrc, FilenameUtils.getExtension(imageName));
			imagesInfo.add(new ImageInfo(LARGE_IMAGE_FOLDER, tempImageSrc.getWidth(), tempImageSrc.getHeight()));
			FileHelper.generateImagesWithDifferentSizes(imageBytes, targetPath, imageName, imagesInfo);
			
			String src = FileHelper.getFullPath(tempPath, tempFolder, imageName);
			String dst = FileHelper.getFullPath(targetPath, ORIGINAL_IMAGE_FOLDER, imageName);
			FileHelper.copyFile(src, dst);
		} catch(Exception e) {
			throw e;
		} finally {
			if(tempImageSrc != null) {
				tempImageSrc.flush();
			}
		}
	}
	
	private static void generateImagesWithDifferentSizes(byte[] compressedImageBytes, String tempPath, String generatedFileName, List<ImageInfo> imagesInfo) throws Exception {
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
		} catch(Exception e) {
			throw e;
		} finally {
			if(in != null){
				in.close();
			}
			
			if(compressedBufferedImage != null) {
				compressedBufferedImage.flush();
			}
		}
	}
	
	/*
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
	
	private static String cutImage(MultipartFile mpf, int x1, int y1, int w, int h, String tempPath) throws IOException {
		InputStream in = new ByteArrayInputStream(mpf.getBytes());
		BufferedImage bImageFromConvert = ImageIO.read(in);
		
		BufferedImage out = bImageFromConvert.getSubimage(x1, y1, w, h);
        String type = mpf.getContentType().replace("image/", "");
        String generatedFileName = getUniqueImageName(mpf.getOriginalFilename());
		ImageIO.write(out, type, new File(tempPath, generatedFileName));
		return generatedFileName;
	}*/
}