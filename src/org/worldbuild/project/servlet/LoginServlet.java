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
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = {"/login"}, 
initParams = {
		@WebInitParam(name = "title", value = "Sign In")
})
public class LoginServlet extends HttpServlet {
	private static final Logger LOGGER = Logger.getLogger(LoginServlet.class);
	private static final long serialVersionUID = 1L;
	private final LoginService loginService;
	static {
		
	}
	{
		
	}
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        loginService=new LoginServiceImpl();
        // TODO Auto-generated constructor stub
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
		response.sendRedirect("/signin/login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean isAuthenticated=loginService.authenticate(request);
		if (isAuthenticated) {
			response.sendRedirect("/index.jsp");
		}else {
			request.getRequestDispatcher("/signin/login.jsp").forward(request, response);
		}
	}

}
