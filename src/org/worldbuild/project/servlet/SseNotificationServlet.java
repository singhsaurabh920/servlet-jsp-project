package org.worldbuild.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.LinkedBlockingQueue;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.worldbuild.project.beans.ApplicationBeanContext;
import org.worldbuild.project.modal.NotificationSseModal;
import org.worldbuild.project.scheduler.NotificationScheduler;

import com.google.gson.Gson;

/**
 * Servlet implementation class SseNotificationServlet
 */
@WebServlet("/sse/notification")
public class SseNotificationServlet extends HttpServlet {
	private static final Logger LOGGER = Logger.getLogger(SseNotificationServlet.class);
	private static final long serialVersionUID = 1L;
    private static  boolean isTrue=true; 
	private Gson gson;
    private NotificationScheduler notificationScheduler;
    private LinkedBlockingQueue<NotificationSseModal> linkedBlockingQueue;
	
    public SseNotificationServlet() {
        super();
		gson = ApplicationBeanContext.getGson();
	    linkedBlockingQueue=ApplicationBeanContext.getBlockingQueue();
	    notificationScheduler=NotificationScheduler.getNotificationScheduler();
    }

    
	@Override
	public void init() throws ServletException {
		super.init();
		notificationScheduler.startSending();
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info(Thread.currentThread().getName()+" :  notification event start");
		PrintWriter pw=response.getWriter();
		while(isTrue) {
			try {
				if(pw.checkError()) {
					break;
				}
				NotificationSseModal msg = linkedBlockingQueue.take();
				//LOGGER.info(Thread.currentThread().getName()+" : "+msg);
				String jsonObject = gson.toJson(msg);
				pw.println("data:"+jsonObject+"\n\n");
				pw.flush();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		pw.close();
		LOGGER.info(Thread.currentThread().getName()+" :  notification event stopped");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	public void destroy() {
		super.destroy();
		isTrue=false;
	}

}


