package org.worldbuild.project.modal;

import java.util.Date;

public class NotificationSseModal {

	private String name;
	private String msg;
	private Date date;

	public NotificationSseModal(String name, Date date, String msg) {
		super();
		this.name=name;
		this.date = date;
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "SseData [msg=" + msg + ", date=" + date + "]";
	}
}
