package org.worldbuild.project.listner;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;

@WebListener
public class FileLocationContextListener implements ServletContextListener {
	private static final Logger LOGGER = Logger.getLogger(FileLocationContextListener.class);

	public FileLocationContextListener() {
		super();
	}

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		String rootPath = System.getProperty("catalina.home");
		ServletContext ctx = servletContextEvent.getServletContext();
		String relativePath = ctx.getInitParameter("tempfile.dir");
		LOGGER.info("Path: " + rootPath + File.separator + relativePath);
		File file = new File(rootPath + File.separator + relativePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		LOGGER.info("File Directory created to be used for storing files");
		ctx.setAttribute("FILES_DIR_FILE", file);
		ctx.setAttribute("FILES_DIR", rootPath + File.separator + relativePath+ File.separator);
	}

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		// do cleanup if needed
	}

}
