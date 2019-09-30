package org.worldbuild.project.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.worldbuild.project.context.UserContextHolder;
import org.worldbuild.project.entity.domain.User;
import org.worldbuild.project.utils.ValidationUtils;

public class LoginServiceImpl implements LoginService {
	private static final Logger LOGGER = Logger.getLogger(LoginServiceImpl.class);

	
	@Override
	public boolean authenticate(HttpServletRequest request) {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(ValidationUtils.isNotValid(username)) {
			request.setAttribute("usernameError", "Enter valid username");
			return false;
		}
		if(ValidationUtils.isNotValid(password)) {
			request.setAttribute("passwordError", "Enter valid password");
			return false;
		}
		User user=UserContextHolder.getUser(username);
		if (user==null) {
			request.setAttribute("usernameError", "User does not exists");
			return false;
		}else if (!user.isActive()) {
			request.setAttribute("usernameError", "User is not active");
			return false;
		}else if(!user.getPassword().equals(password)) {
			request.setAttribute("passwordError", "Password does not matched");
			return false;
		}else {
			request.getSession().setAttribute("user", user);
			request.getSession().setAttribute("isAuthenticated", true);
			return true;
		}
	}

	@Override
	public void logout(HttpServletRequest request) {
		HttpSession httpSession=request.getSession(false);
		if (httpSession!=null) {
		    httpSession.invalidate();
		}
	}

}
