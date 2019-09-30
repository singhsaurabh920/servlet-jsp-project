package org.worldbuild.project.listner;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

/**
 * Application Lifecycle Listener implementation class SessionListner
 *
 */
@WebListener
public class SessionListner implements HttpSessionListener {
	private static final Logger LOGGER = Logger.getLogger(SessionListner.class);

	/**
	 * Default constructor.
	 */
	public SessionListner() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent event) {
		
		HttpSession httpSession = event.getSession();
		ServletContext servletContext = httpSession.getServletContext();
		httpSession.setAttribute("company", servletContext.getInitParameter("company"));
		httpSession.setAttribute("website", servletContext.getInitParameter("website"));
		LOGGER.info("Session created: "+httpSession.getId());
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent event) {

	}

}
