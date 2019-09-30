package org.worldbuild.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.worldbuild.project.beans.GsonBean;
import org.worldbuild.project.context.PictureContextHolder;
import org.worldbuild.project.entity.domain.User;
import org.worldbuild.project.utils.UserUtils;

import com.google.gson.Gson;

/**
 * Servlet implementation class AjaxUploadServlet
 */
@WebServlet("/ajax/upload")
public class AjaxUploadServlet extends HttpServlet {
	private static final Logger LOGGER = Logger.getLogger(AjaxUploadServlet.class);
	private static final long serialVersionUID = 1L;
    private Gson gson;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxUploadServlet() {
        super();
        gson=GsonBean.getGson();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=UserUtils.getUser(request);
		PrintWriter pw=response.getWriter();
		List<String> pictures = PictureContextHolder.getPictures(user.getUsername());
		String jsonObject = gson.toJson(pictures);
		pw.print(jsonObject);
		pw.flush();
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
