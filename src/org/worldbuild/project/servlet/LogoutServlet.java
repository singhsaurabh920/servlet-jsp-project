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
import org.worldbuild.project.service.LoginService;
import org.worldbuild.project.service.LoginServiceImpl;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet(urlPatterns = {"/logout"}, 
initParams = {
		@WebInitParam(name = "title", value = "Logout")
})
public class LogoutServlet extends HttpServlet {
	private static final Logger LOGGER = Logger.getLogger(LogoutServlet.class);
	private static final long serialVersionUID = 1L;
	private LoginService loginService;
	static {
		
	}
	{
		
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        loginService=new LoginServiceImpl();
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
		// TODO Auto-generated method stub
		loginService.logout(request);
		response.sendRedirect("/index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
