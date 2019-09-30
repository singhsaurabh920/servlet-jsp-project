package org.worldbuild.project.service;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {

	void logout(HttpServletRequest request);
	
	boolean authenticate(HttpServletRequest request);
}
