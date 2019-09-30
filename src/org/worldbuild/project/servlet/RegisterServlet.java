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
import org.worldbuild.project.service.RegisterService;
import org.worldbuild.project.service.RegisterServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(urlPatterns = {"/register"}, 
initParams = {
		@WebInitParam(name = "title", value = "Sign Up")
})
public class RegisterServlet extends HttpServlet {
	private static final Logger LOGGER = Logger.getLogger(RegisterServlet.class);
	private static final long serialVersionUID = 1L;
	private final RegisterService registerService;
	static {
		
	}
	{
		
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        registerService=new RegisterServiceImpl();
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
		response.sendRedirect("/signup/register.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isRegistered=registerService.register(request);
		if(isRegistered) {
			response.sendRedirect("/signin/login.jsp");
		}else {
			request.getRequestDispatcher("/signup/register.jsp").forward(request, response);
		}
	}

}
