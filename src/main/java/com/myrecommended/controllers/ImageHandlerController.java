package com.myrecommended.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("imageHandler")
public class ImageHandlerController {

	@Value("#{configProps}")
	private Properties properties;
	
	//TODO: PASAR A UNA COSTANTE
	private final String SMALL_IMAGE_FOLDER = "small";
	private final String MEDIUM_IMAGE_FOLDER = "medium";
	private final String LARGE_IMAGE_FOLDER = "large";
	private final String ORIGINAL_IMAGE_FOLDER = "originals";
	
	/*@RequestMapping(value="/avatarThumb", method=RequestMethod.GET, params={"fileName", "w"})
	public void avatarThumb(HttpServletResponse response, @RequestParam(value="fileName") String fileName, @RequestParam(value="w") int width){
		this.avatarThumb(response, fileName, width, width);
	}
	
	@RequestMapping(value="/avatarThumb", method=RequestMethod.GET, params={"fileName", "w", "h"})
	public void avatarThumb(HttpServletResponse response, @RequestParam(value="fileName") String fileName, @RequestParam(value="w") int width, @RequestParam(value="h") int height){
		if(!StringUtils.isNotBlank(fileName)){
			fileName = "defaultAvatar.jpg";
		}
		
		String avatarPath = properties.getProperty("folder.avatar");
		File directory = new File(avatarPath, ORIGINAL_IMAGE_FOLDER);
		resize(response, directory.getAbsolutePath(), fileName, width, height);
	}*/
	
	@RequestMapping(value="/avatarThumb", method=RequestMethod.GET)
	public void avatarThumb(HttpServletResponse response, String fileName, String type){
		String tempPath = properties.getProperty("folder.avatar");
		File directory = new File(tempPath, type);
		handleImage(response, fileName, directory.getAbsolutePath());
	}

	private void resize(HttpServletResponse response, String folderPath, String fileName, int width, int height) {
		BufferedImage imageSrc = null;
		BufferedImage thumbnail = null;
		try {
			imageSrc = ImageIO.read(new File(folderPath, fileName));
			thumbnail = Scalr.resize(imageSrc, Scalr.Method.QUALITY, Scalr.Mode.AUTOMATIC, width, height, Scalr.OP_ANTIALIAS, Scalr.OP_BRIGHTER);
			generateImage(response, thumbnail);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void generateImage(HttpServletResponse response, BufferedImage thumbnail) {
		response.setContentType("image/jpeg");
		OutputStream output = null;
		InputStream input = null;
		
		try {
			output = response.getOutputStream();
			
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			ImageIO.write(thumbnail, "jpg", os);
			
			input = new ByteArrayInputStream(os.toByteArray());
			byte[] buffer = new byte[(int) os.size()];
			input.read(buffer);
			response.setContentLength(buffer.length);
			output.write(buffer);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				input.close();
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void handleImage(HttpServletResponse response, String fileName, String imagePath) {
		response.setContentType("image/jpeg");
		OutputStream output  = null;
		FileInputStream input = null;
		File file = new File(imagePath, fileName);
		try {
			output = response.getOutputStream();
			input = new FileInputStream(file);
			byte[] buffer = new byte[(int) file.length()];
			input.read(buffer);
			response.setContentLength(buffer.length);
			output.write(buffer);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				input.close();
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
