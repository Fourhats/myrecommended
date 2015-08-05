package com.myrecommended.controllers;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.myrecommended.security.CustomUser;

public class BaseController {
	
	protected final String FAIL_MESSAGE = "USER_IS_NOT_AUTHENTICATED";
	protected final String SUCCESS_MESSAGE = "SUCCESSFUL";

	/*@ExceptionHandler(AuthenticationCredentialsNotFoundException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody String handleException(Exception ex, HttpServletResponse response) {
		return ex.getMessage();
	}*/

	public void verifyAuthentication() {
		if (!isUserLogged()) {
			throw new AuthenticationCredentialsNotFoundException(FAIL_MESSAGE);
		}
	}

	public boolean isUserLogged() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth instanceof AnonymousAuthenticationToken) {
			return false;
		}

		return true;
	}

	public long getUserId() {
		if(isUserLogged()) {
			CustomUser customUser = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			return customUser.getId();
		} else {
			return 0;
		}
	}
}
