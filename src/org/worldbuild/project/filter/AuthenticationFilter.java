package org.worldbuild.project.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter(filterName = "AuthenticationFilter", urlPatterns = {"/secure/*"},
initParams = {
  @WebInitParam(name = "isSecureMode", value = "true")})
public class AuthenticationFilter implements Filter {
	private static final Logger LOGGER = Logger.getLogger(AuthenticationFilter.class);
	private ServletContext context;

    /**
     * Default constructor. 
     */
    public AuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String uri = req.getRequestURI();
		this.context.log("Requested Secure Resource::"+uri);
		HttpSession httpSession=req.getSession(false);
		if (httpSession == null || httpSession.getAttribute("user") == null) {
			LOGGER.info("Unauthorized access request");
			res.sendRedirect("/login");
		}else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		LOGGER.info(fConfig.getFilterName()+" initialized");
		Enumeration< String> fCxt=fConfig.getInitParameterNames();
		while (fCxt.hasMoreElements()) {
			String name = (String) fCxt.nextElement();
			LOGGER.info(fConfig.getFilterName()+" Filter Context[ "+name+" ]:"+fConfig.getInitParameter(name));
		}
	}

}
