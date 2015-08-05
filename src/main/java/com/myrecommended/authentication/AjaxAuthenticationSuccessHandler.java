package com.myrecommended.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;
import org.springframework.stereotype.Component;

@Component("ajaxAuthenticationSuccessHandler")
public class AjaxAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	public AjaxAuthenticationSuccessHandler() {
	}

	@SuppressWarnings("unused")
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

		HttpSession session = request.getSession();
		DefaultSavedRequest defaultSavedRequest = (DefaultSavedRequest) session.getAttribute(WebAttributes.SAVED_REQUEST);
		// check if login is originated from ajax call
		if ("true".equals(request.getHeader("X-Ajax-call"))) {
			try {
				response.getWriter().print("ok");// return "ok" string
				response.getWriter().flush();
			} catch (IOException ex) {
			}
		} else {
			setAlwaysUseDefaultTargetUrl(false);
			super.onAuthenticationSuccess(request, response, authentication);
		}
	}
}
