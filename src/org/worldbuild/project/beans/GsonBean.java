package org.worldbuild.project.beans;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonBean {
	
	public static Gson gson= new GsonBuilder().create();

	private GsonBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static Gson getGson() {
		return gson;
	}
	
}
