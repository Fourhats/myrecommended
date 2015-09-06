package com.myrecommended.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myrecommended.constants.TempFolders;
import com.myrecommended.services.recommended.RecommendedService;
import com.myrecommended.services.users.UserService;

@Controller
@RequestMapping("imageHandler")
public class ImageHandlerController extends BaseController {

	@Value("#{configProps}")
	private Properties properties;
	
	@Autowired
	private UserService userService;

	@Autowired
	private RecommendedService recommendedService;
	
	private final String DEFAULT_AVATAR = "defaultAvatar.jpg";
	
	@RequestMapping(value="/avatarThumb", method=RequestMethod.GET)
	public void avatarThumb(HttpServletResponse response, String fileName, String type){
		String avatarPath = properties.getProperty("folder.avatar");
		File directory = new File(avatarPath, type);
		if(fileName == null || fileName.isEmpty()) {
			fileName = this.DEFAULT_AVATAR;
		}
		
		handleImage(response, fileName, directory.getAbsolutePath());
	}
	
	@RequestMapping(value="/currentAvatarThumb", method=RequestMethod.GET)
	public void currentAvatarThumb(HttpServletResponse response, String type){
		this.verifyAuthentication();
		
		String avatarName = this.userService.getUserAvatar(this.getUserId());
		this.avatarThumb(response, avatarName, type);
	}
	
	@RequestMapping(value="/recommendedAvatarThumb", method=RequestMethod.GET)
	public void recommendedAvatarThumb(HttpServletResponse response, String fileName, String type){
		String recommendedAvatarPath = properties.getProperty("folder.recommendedAvatars");
		File directory = new File(recommendedAvatarPath, type);
		if(fileName == null || fileName.isEmpty()) {
			fileName = this.DEFAULT_AVATAR;
		}
		
		handleImage(response, fileName, directory.getAbsolutePath());
	}
	
	@RequestMapping(value="/currentRecommendedAvatarThumb", method=RequestMethod.GET)
	public void currentRecommendedAvatarThumb(HttpServletResponse response, String type){
		this.verifyAuthentication();
		
		String avatarName = this.recommendedService.getRecommendedAvatarByUser(this.getUserId());
		this.recommendedAvatarThumb(response, avatarName, type);
	}

	@RequestMapping(value="/recommendedOldJobsThumb", method=RequestMethod.GET)
	public void recommendedOldJobsThumb(HttpServletResponse response, String fileName, String type){
		String oldJobsPath = properties.getProperty("folder.recommendedOldJobs");
		File directory = new File(oldJobsPath, type);
		handleImage(response, fileName, directory.getAbsolutePath());
	}
	
	@RequestMapping(value="/tempRecommendedThumb", method=RequestMethod.GET)
	public void tempRecommendedThumb(HttpServletResponse response, String fileName){
		String tempPath = properties.getProperty("folder.temp");
		File directory = new File(tempPath, TempFolders.RECOMMENDED_AVATARS_FOLDER.getValue());
		handleImage(response, fileName, directory.getAbsolutePath());
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
	
	//TODO: REVISAR
	/*private void resize(HttpServletResponse response, String folderPath, String fileName, int width, int height) {
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
	}*/
}
