package org.worldbuild.project.filter;

import java.io.IOException;
import java.io.PrintWriter;
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
import org.worldbuild.project.beans.ApplicationBeanContext;
import org.worldbuild.project.modal.Response;

import com.google.gson.Gson;

/**
 * Servlet Filter implementation class SseFilter
 */
@WebFilter(filterName = "SseFilter", urlPatterns = { "/sse/*" }, initParams = {
		@WebInitParam(name = "content-type", value = "text/event-stream") 
})
public class SseFilter implements Filter {
	private static final Logger LOGGER = Logger.getLogger(AjaxFilter.class);
	private Gson gson;

	private FilterConfig fConfig;

	private ServletContext context;


    /**
     * Default constructor. 
     */
    public SseFilter() {
    	super();
		gson = ApplicationBeanContext.getGson();
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		res.setContentType("text/event-stream");
		res.setCharacterEncoding("UTF-8");
		HttpSession httpSession = req.getSession(false);
		if (httpSession == null || httpSession.getAttribute("user") == null) {
			LOGGER.info("Unauthorized access request");
			res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			PrintWriter pw = response.getWriter();
			String jsonObject = gson.toJson(new Response<String>(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized access request"));
			pw.print("data:"+jsonObject+"\n\n");
			pw.flush();
			pw.close();
		} else {
			chain.doFilter(req, res);
			if(res.getStatus()==HttpServletResponse.SC_NOT_FOUND) {
				PrintWriter pw=res.getWriter();
				String jsonObject = gson.toJson(new Response<String>(HttpServletResponse.SC_NOT_FOUND,"Requested source not found"));
				pw.print("data:"+jsonObject+"\n\n");
				pw.flush();
				pw.close();
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.fConfig = fConfig;
		this.context = fConfig.getServletContext();
		LOGGER.info(fConfig.getFilterName() + " initialized");
		Enumeration<String> fCxt = fConfig.getInitParameterNames();
		while (fCxt.hasMoreElements()) {
			String name = (String) fCxt.nextElement();
			LOGGER.info(fConfig.getFilterName() + " Filter Context[ " + name + " ]:" + fConfig.getInitParameter(name));
		}	
	}

}
