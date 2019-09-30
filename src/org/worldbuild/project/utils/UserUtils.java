package org.worldbuild.project.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.worldbuild.project.entity.domain.User;


public interface UserUtils {

	public static User getUser(HttpServletRequest request){
		HttpSession httpSession=request.getSession(false);
		if(httpSession!=null) {
			return (User) httpSession.getAttribute("user");
		}
		return null;
	}
}
