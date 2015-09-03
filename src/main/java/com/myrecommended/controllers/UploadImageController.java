package com.myrecommended.controllers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.myrecommended.constants.TempFolders;
import com.myrecommended.models.UploadedFile;
import com.myrecommended.services.utils.FileHelper;

@Controller
@RequestMapping("/image")
public class UploadImageController {

	@Value("#{configProps}")
	private Properties properties;
	
	@RequestMapping(value="/uploadAvatar", method=RequestMethod.POST)
	public @ResponseBody UploadedFile uploadAvatar(@RequestParam("file") MultipartFile file) throws Exception {
		return uploadTempImage(file, TempFolders.AVATAR_FOLDER.getValue());
	}
	
	@RequestMapping(value="/uploadRecommendedAvatar", method=RequestMethod.POST)
	public @ResponseBody UploadedFile uploadRecommendedAvatar(@RequestParam("file") MultipartFile file) throws Exception {
		return uploadTempImage(file, TempFolders.RECOMMENDED_AVATARS_FOLDER.getValue());
	}
	
	@RequestMapping(value="/uploadRecommendedOldJobsImages", method=RequestMethod.POST)
	public @ResponseBody UploadedFile uploadRecommendedOldJobsImages(@RequestParam("file") MultipartFile file) throws Exception{
		return uploadTempImage(file, TempFolders.RECOMMENDED_OLD_JOBS_FOLDER.getValue());
	}
	
	private UploadedFile uploadTempImage(MultipartFile file, String folder) throws IOException, Exception, FileNotFoundException {
		String tempPath = properties.getProperty("folder.temp");
		boolean isLocal = this.properties.getProperty("enviroment").equals("local");
		
		String generatedFileName = FileHelper.getUniqueImageName(file.getOriginalFilename(), isLocal);
		
		String extension = FilenameUtils.getExtension(generatedFileName).toLowerCase();
		String finalFileName = generatedFileName.replace("." + extension, ".jpg");
		
		String originalImgPath = FileHelper.getFullPath(tempPath, folder, generatedFileName);
		String convertedImgPath = FileHelper.getFullPath(tempPath, folder, finalFileName);
		
		//copia la imagen original en la carpeta temp.
		FileCopyUtils.copy(file.getBytes(), new FileOutputStream(originalImgPath));
		
		boolean isJpg = extension.toLowerCase().equals("jpg");//extension.toLowerCase().equals("jpeg") || 
		if(!isJpg){
			FileHelper.convertToJPG(originalImgPath, convertedImgPath);
		}
		
		return new UploadedFile(finalFileName);
	}
}