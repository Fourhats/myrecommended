package com.myrecommended.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myrecommended.business.MyRecommendedBusinessException;
import com.myrecommended.controllers.BaseController;
import com.myrecommended.services.petitions.PetitionService;
import com.myrecommended.services.petitions.dtos.PetitionDTO;
import com.myrecommended.services.petitions.dtos.PetitionRequestDTO;
import com.myrecommended.services.users.UserService;
import com.myrecommended.services.users.dtos.ChangePasswordRequestDTO;
import com.myrecommended.services.users.dtos.LoggedUserDTO;
import com.myrecommended.services.users.dtos.UpdateUserRequestDTO;
import com.myrecommended.services.users.dtos.UserRequestDTO;
import com.myrecommended.services.utils.MyRecommendedBaseDTO;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.User;

@RestController
public class UserApiController extends BaseController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PetitionService petitionService;
	
	@RequestMapping(value = "/users/existUserWithEmail", method = RequestMethod.POST)
    public @ResponseBody boolean existUserWithEmail(@RequestBody String email, Model model) {
		return this.userService.existUserWithEmail(email);
	}
	
	@RequestMapping(value = "/users/loginFBUser", method = RequestMethod.POST)
    public @ResponseBody LoggedUserDTO getFBUserInfo(@RequestBody String accessToken, Model model) {
		FacebookClient facebookClient = new DefaultFacebookClient(accessToken);
		User user = facebookClient.fetchObject("me", User.class);
		
		LoggedUserDTO returnObject = new LoggedUserDTO();
		try {
			if(this.userService.existUserWithEmail(user.getEmail())) {
				returnObject = this.userService.getFbLoggedUserByEmail(user.getEmail());
			} else {
				returnObject = this.userService.addUser(user);
			}
			
		} catch (MyRecommendedBusinessException e) {
			returnObject.setError(e.getMessage());
			e.printStackTrace();
		}
			
		return returnObject;
	}
	
	@RequestMapping(value = "/users/createUser", method = RequestMethod.POST)
    public @ResponseBody LoggedUserDTO addUser(@RequestBody UserRequestDTO userDto, Model model) {
		LoggedUserDTO returnObject = new LoggedUserDTO();
		try {
			returnObject = this.userService.addUser(userDto);
		} catch (MyRecommendedBusinessException e) {
			returnObject.setError(e.getMessage());
			e.printStackTrace();
		}
		
		return returnObject;
    }
	
	@RequestMapping(value = "/users/updateUser", method = RequestMethod.POST)
    public MyRecommendedBaseDTO updateUser(@RequestBody UpdateUserRequestDTO userDto, Model model) {
		MyRecommendedBaseDTO returnObject = new MyRecommendedBaseDTO();
		
		try {
			this.verifyAuthentication();
			
			userDto.setId(this.getUserId());
			this.userService.updateUser(userDto);
		} catch (AuthenticationCredentialsNotFoundException e) {
			returnObject.setError(e.getMessage());
			e.printStackTrace();
		} catch (MyRecommendedBusinessException e) {
			returnObject.setError(e.getMessage());
			e.printStackTrace();
		}
		
		return returnObject;
    }
	
	@RequestMapping(value = "/users/changePassword", method = RequestMethod.POST)
    public MyRecommendedBaseDTO changePassword(@RequestBody ChangePasswordRequestDTO changePasswordDto, Model model) {
		MyRecommendedBaseDTO returnObject = new MyRecommendedBaseDTO();
		
		try {
			this.verifyAuthentication();
			
			changePasswordDto.setUserId(this.getUserId());
			this.userService.changePassword(changePasswordDto);
		} catch (AuthenticationCredentialsNotFoundException e) {
			returnObject.setError(e.getMessage());
			e.printStackTrace();
		} catch (MyRecommendedBusinessException e) {
			returnObject.setError(e.getMessage());
			e.printStackTrace();
		}
		
		return returnObject;
    }
	
	@RequestMapping(value = "/users/createPetition", method = RequestMethod.POST)
	public @ResponseBody PetitionDTO createPetition(@RequestBody PetitionRequestDTO petitionDto) {
		PetitionDTO returnObject = new PetitionDTO();
		try {
			this.verifyAuthentication();
			
			petitionDto.setUserId(this.getUserId());
			returnObject = this.petitionService.addPetition(petitionDto);
		} catch (MyRecommendedBusinessException e) {
			returnObject.setError(e.getMessage());
			e.printStackTrace();
		} catch (AuthenticationCredentialsNotFoundException e) {
			returnObject.setError(e.getMessage());
			e.printStackTrace();
		}
		
		return returnObject;
	}
}