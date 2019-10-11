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
 * Servlet implementation class ProfileAjaxServlet
 */
@WebServlet("/ajax/profile")
public class AjaxProfileServlet extends HttpServlet {
	private static final Logger LOGGER = Logger.getLogger(AjaxProfileServlet.class);
	private static final long serialVersionUID = 1L;
	private Gson gson;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjaxProfileServlet() {
		super();
		gson = ApplicationBeanContext.getGson();	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=UserUtils.getUser(request);
		PrintWriter pw=response.getWriter();
		String jsonObject = gson.toJson(user);
		pw.print(jsonObject);
		pw.flush();
		pw.close();
	}

}
