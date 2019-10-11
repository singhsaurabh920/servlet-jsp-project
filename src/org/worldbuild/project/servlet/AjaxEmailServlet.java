package org.worldbuild.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.worldbuild.project.beans.ApplicationBeanContext;
import org.worldbuild.project.entity.domain.User;
import org.worldbuild.project.modal.Response;
import org.worldbuild.project.service.EmailService;
import org.worldbuild.project.utils.UserUtils;

import com.google.gson.Gson;

/**
 * Servlet implementation class AjaxEmailServlet
 */
@WebServlet("/ajax/send/enquiry")
public class AjaxEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(AjaxProfileServlet.class);
	private Gson gson;
	private EmailService emailService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxEmailServlet() {
        super();
        gson=ApplicationBeanContext.getGson();
        emailService = ApplicationBeanContext.getEmailService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = UserUtils.getUser(request);
		boolean isSend = emailService.sendEnquiryEmail(request);
		PrintWriter pw = response.getWriter();
		Response<String> res ;
		if (isSend) {
			response.setStatus(HttpServletResponse.SC_OK);
			res = new Response<String>("Enquiry queued");
		}else {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			res = new Response<String>(HttpServletResponse.SC_BAD_REQUEST,"Error in submitting enquiry");
		}
		String jsonObject = gson.toJson(res);
		pw.print(jsonObject);
		pw.flush();
		pw.close();
	}

}
