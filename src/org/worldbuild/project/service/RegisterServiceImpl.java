package org.worldbuild.project.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.worldbuild.project.context.UserContextHolder;
import org.worldbuild.project.entity.domain.User;
import org.worldbuild.project.utils.ValidationUtils;

public class RegisterServiceImpl implements RegisterService {
	private static final Logger LOGGER = Logger.getLogger(RegisterServiceImpl.class);


	@Override
	public boolean register(HttpServletRequest request) {
		Map<String, String> errors = new HashMap<String, String>();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirm = request.getParameter("confirm");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String imgUrl = request.getParameter("imgUrl");
		boolean active = Boolean.valueOf(request.getParameter("active"));
		if (ValidationUtils.isNotValid(username)) {
			errors.put("usernameError", "Please enter username");
		}
		if (ValidationUtils.isNotValid(password)) {
			errors.put("passwordError", "Please enter password");

		}else if (ValidationUtils.isNotValid(confirm)) {
			errors.put("confirmError", "Please confirm password");
		}else if (!password.equals(confirm)) {
			errors.put("confirmError", "Please confirm password");
		}
		if (ValidationUtils.isNotValid(name)) {
			errors.put("nameError", "Please enter name");
		}
		if (ValidationUtils.isNotValid(email)) {
			errors.put("emailError", "Please enter email");
		}
		if (ValidationUtils.isNotValid(phone)) {
			errors.put("phoneError", "Please enter phone number");
		}
		if (ValidationUtils.isNotValid(address)) {
			errors.put("addressError", "Please enter address");
		}
		if (errors.isEmpty()) {
			User user = new User(username, password, name, email, phone, address, active, imgUrl);
			UserContextHolder.setUsers(user);
			return true;
		}
		request.setAttribute("errors", errors);
		return false;
	}

}
