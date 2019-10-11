package org.worldbuild.project.service;

import javax.servlet.http.HttpServletRequest;

public interface EmailService {

	boolean sendEnquiryEmail(HttpServletRequest request);

	void sendEmail(String to, String suject, String content);

	void sendAsyncEmail(String to, String suject, String content);

}
