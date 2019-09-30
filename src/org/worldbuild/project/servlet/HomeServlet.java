package org.worldbuild.project.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class HomeServlet
 */
public class HomeServlet extends HttpServlet {
	private static final Logger LOGGER = Logger.getLogger(HomeServlet.class);
	private static final long serialVersionUID = 1L;
	static {
		
	}
	{
		
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
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
