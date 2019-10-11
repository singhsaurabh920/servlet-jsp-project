package org.worldbuild.project.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.worldbuild.project.beans.ApplicationBeanContext;

import com.google.gson.Gson;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet(urlPatterns={"/secure/profile"},
initParams = {
		@WebInitParam(name = "title", value = "Profile")
})
public class ProfileServlet extends HttpServlet {
	private static final Logger LOGGER = Logger.getLogger(ProfileServlet.class);
	private static final long serialVersionUID = 1L;
	private Gson gson;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        gson=ApplicationBeanContext.getGson();
    }
    
    @Override
	public void init() throws ServletException {
		super.init();
		LOGGER.info(getServletName()+" initialized");
        Enumeration<String> sCxt=getInitParameterNames();
        while (sCxt.hasMoreElements()) {
			String name = (String) sCxt.nextElement();
			LOGGER.info(getServletName()+" Context[ "+name+" ]:"+getInitParameter(name));
		}
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/secure/profile.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);		
	}
}
