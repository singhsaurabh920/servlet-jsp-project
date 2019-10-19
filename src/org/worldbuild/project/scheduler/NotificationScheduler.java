package org.worldbuild.project.scheduler;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.worldbuild.project.beans.ApplicationBeanContext;
import org.worldbuild.project.modal.NotificationSseModal;

public class NotificationScheduler {
	private static final Logger LOGGER = Logger.getLogger(NotificationScheduler.class);
	private static NotificationScheduler notificationScheduler;
	private static String[] CUSTMORS = { "Mohan", "Ram", "Shohan", "Shyam", "Sita", "Suresh", "Geeta", "Mahesh","Lalit", "Sarita" };

	private Random random;
	private LinkedBlockingQueue<NotificationSseModal> blockingQueue;
	private ScheduledExecutorService scheduledExecutorService;

	private NotificationScheduler() {
		super();
		if (notificationScheduler != null) {
			throw new RuntimeException("Cunstuctror call not allowed");
		}
		random = new Random();
		blockingQueue = ApplicationBeanContext.blockingQueue;
		scheduledExecutorService = ApplicationBeanContext.scheduledExecutorService;
	}

	public synchronized static NotificationScheduler getNotificationScheduler() {
		if (notificationScheduler == null) {
			notificationScheduler = new NotificationScheduler();
		}
		return notificationScheduler;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Clone not supported");
	}

	public void startSending() {
		scheduledExecutorService.scheduleWithFixedDelay(() -> {
			try {
				String name = CUSTMORS[random.nextInt(CUSTMORS.length)];
				String msg = name + " sent a message";
				blockingQueue.put(new NotificationSseModal(name,new Date(),msg));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, 2, 2, TimeUnit.SECONDS);
	}
}
