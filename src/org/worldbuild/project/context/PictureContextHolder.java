package org.worldbuild.project.context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

public class PictureContextHolder {
	private static final Logger LOGGER = Logger.getLogger(PictureContextHolder.class);

	private static Map<String, List<String>> pictures = new ConcurrentHashMap<>();

	public static List<String> getPictures(String username) {
		return pictures.get(username);
	}

	public static void setPictures(String username,String imageUrl) {
		if (pictures.containsKey(username)) {
			List<String> pList=new ArrayList<String>(pictures.get(username));
			pList.add(imageUrl);
			pictures.put(username, pList);
		}else {
			pictures.put(username, Arrays.asList(imageUrl));
		}
		
	}

}
