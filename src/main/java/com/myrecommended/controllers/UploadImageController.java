package com.myrecommended.controllers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.myrecommended.models.UploadedFile;
import com.myrecommended.services.utils.FileHelper;
import com.myrecommended.services.utils.ImageInfo;

@Controller
@RequestMapping("/image")
public class UploadImageController {

	@Value("#{configProps}")
	private Properties properties;
	
	private final String SMALL_IMAGE_FOLDER = "small";
	private final String MEDIUM_IMAGE_FOLDER = "medium";
	private final String LARGE_IMAGE_FOLDER = "large";
	private final String ORIGINAL_IMAGE_FOLDER = "originals";
	
	@RequestMapping(value="/uploadAvatar", method=RequestMethod.POST)
	public @ResponseBody UploadedFile uploadAvatar(@RequestParam("file") MultipartFile file) throws Exception{
		String avatarPath = properties.getProperty("folder.avatar");
		
		BufferedImage imageSrc = null;
		List<ImageInfo> imagesInfo = new ArrayList<ImageInfo>();
		try{
			imageSrc = ImageIO.read(file.getInputStream());
			imagesInfo.add(new ImageInfo(SMALL_IMAGE_FOLDER, 125, 100));
			imagesInfo.add(new ImageInfo(MEDIUM_IMAGE_FOLDER, 275, 191));
			imagesInfo.add(new ImageInfo(LARGE_IMAGE_FOLDER, imageSrc.getWidth(), imageSrc.getHeight()));
		} catch(Exception e){
			throw e;
		} finally {
			if(imageSrc != null){
				imageSrc.flush();
			}
		}
		
		return this.uploadTempImage(file, avatarPath, imagesInfo);
	}
	
	private UploadedFile uploadTempImage(MultipartFile file, String tempPath, List<ImageInfo> imagesInfo)
			throws IOException, Exception, FileNotFoundException {
		
		String generatedFileName = FileHelper.getUniqueImageName(file.getOriginalFilename());
		
		String extension = FilenameUtils.getExtension(generatedFileName);
		String newFileName = generatedFileName.replace("." + extension, ".jpg");
		
		String originalImgPath = FileHelper.getFullPath(tempPath, ORIGINAL_IMAGE_FOLDER, generatedFileName);
		String convertedImgPath = FileHelper.getFullPath(tempPath, ORIGINAL_IMAGE_FOLDER, newFileName);
		
		//copia la imagen original en la carpeta temp.
		FileCopyUtils.copy(file.getBytes(), new FileOutputStream(originalImgPath));
		
		boolean isJpg = extension.toLowerCase().equals("jpeg") || extension.toLowerCase().equals("jpg");
		if(!isJpg){
			//convierte la imagen a jpg.
			FileHelper.convertToJPG(originalImgPath, convertedImgPath);
		}
		
		//comprimir la nueva imagen jpg.
		byte[] compressedImageBytes = FileHelper.compress(isJpg ? originalImgPath : convertedImgPath, 0.2f);
		
		FileHelper.generateImages2(compressedImageBytes, tempPath, newFileName, imagesInfo);
		//FileCopyUtils.copy(compressedImageBytes, new FileOutputStream(new File(tempPath, newFileName).getAbsolutePath()));
		
		return new UploadedFile(newFileName);
	}
}
