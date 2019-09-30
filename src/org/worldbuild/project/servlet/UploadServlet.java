package org.worldbuild.project.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.worldbuild.project.context.PictureContextHolder;
import org.worldbuild.project.entity.domain.User;
import org.worldbuild.project.utils.UserUtils;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/secure/upload")
public class UploadServlet extends HttpServlet {
	private static final Logger LOGGER = Logger.getLogger(UploadServlet.class);

	private static final long serialVersionUID = 1L;
	private String FILES_DIR = null;
	private File FILES_DIR_FILE = null;
	private ServletFileUpload uploader = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		this.FILES_DIR = (String) getServletContext().getAttribute("FILES_DIR");
		this.FILES_DIR_FILE = (File) getServletContext().getAttribute("FILES_DIR_FILE");
		DiskFileItemFactory fileFactory = new DiskFileItemFactory();
		fileFactory.setRepository(FILES_DIR_FILE);
		this.uploader = new ServletFileUpload(fileFactory);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		response.sendRedirect("/secure/upload.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=UserUtils.getUser(request);
		if (!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("errorFileName", "Content type is not multipart/form-data.");
		} else {
			try {
				List<FileItem> fileItemsList = uploader.parseRequest(request);
				Iterator<FileItem> fileItemsIterator = fileItemsList.iterator();
				while (fileItemsIterator.hasNext()) {
					FileItem fileItem = fileItemsIterator.next();
					File file = new File(FILES_DIR + fileItem.getName());
					fileItem.write(file);
					PictureContextHolder.setPictures(user.getUsername(), file.getName());
				}
				request.setAttribute("successFileName", "Picture uploaded successfully");
				response.sendRedirect("/secure/upload.jsp");
				return;
			} catch (FileUploadException e) {
				request.setAttribute("errorFileName", "Exception in uploading file.");
				e.printStackTrace();
			} catch (Exception e) {
				request.setAttribute("errorFileName", "Exception in uploading file.");
				e.printStackTrace();
			}
		}
		request.getRequestDispatcher("/secure/upload.jsp").forward(request, response);
	}

}
