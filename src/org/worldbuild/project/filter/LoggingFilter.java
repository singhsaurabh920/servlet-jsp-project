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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

/**
 * Servlet Filter implementation class LoggingFilter
 */
//@WebFilter("/LoggingFilter")
public class LoggingFilter implements Filter {
	private static final Logger LOGGER = Logger.getLogger(LoggingFilter.class);
    

	private FilterConfig fConfig;

	private ServletContext context;

	/**
	 * Default constructor.
	 */
	public LoggingFilter() {
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
		String uri = req.getRequestURI();
		boolean isLoggingMode = Boolean.valueOf(fConfig.getInitParameter("isLoggingMode"));
		if (isLoggingMode) {
			LOGGER.info("Requested Resource::" + uri);
			Enumeration<String> params = req.getParameterNames();
			while (params.hasMoreElements()) {
				String name = params.nextElement();
				String value = request.getParameter(name);
				LOGGER.info(req.getRemoteAddr() + "::Request Params::{" + name + "=" + value + "}");
			}
			Enumeration<String> attributes = req.getAttributeNames();
			while (attributes.hasMoreElements()) {
				String name = attributes.nextElement();
				Object value = request.getAttribute(name);
				LOGGER.info(req.getRemoteAddr() + "::Request Attribute::{" + name + "=" + value + "}");
			}
			Cookie[] cookies = req.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					LOGGER.info(req.getRemoteAddr() + "::Cookie::{" + cookie.getName() + "," + cookie.getValue() + "}");
				}
			}
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.fConfig = fConfig;
		this.context = fConfig.getServletContext();
		Enumeration<String> aCxtAttr = this.context.getAttributeNames();
		while (aCxtAttr.hasMoreElements()) {
			String name = (String) aCxtAttr.nextElement();
			LOGGER.info("Application Context Attribute[ " + name + " ]:" + this.context.getAttribute(name));
		}
		Enumeration<String> aCxtParam = this.context.getInitParameterNames();
		while (aCxtParam.hasMoreElements()) {
			String name = (String) aCxtParam.nextElement();
			LOGGER.info("Application Context Parameter[ " + name + " ]:" + this.context.getInitParameter(name));
		}
		LOGGER.info(fConfig.getFilterName()+" initialized");
		Enumeration<String> fCxt = fConfig.getInitParameterNames();
		while (fCxt.hasMoreElements()) {
			String name = (String) fCxt.nextElement();
			LOGGER.info(fConfig.getFilterName() + " Filter Context[ " + name + " ]:" + fConfig.getInitParameter(name));
		}
	}

}
