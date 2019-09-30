package org.worldbuild.project.context;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;
import org.worldbuild.project.entity.domain.User;


public class UserContextHolder {
	private static final Logger LOGGER = Logger.getLogger(UserContextHolder.class);
	
	private static Map<String,User> users=new ConcurrentHashMap<>();
	
	static {
		setDefaultUser();
	}

	public static User getUser(String username) {
		return users.get(username);
	}

	public static void setUsers(User user) {
		users.put(user.getUsername(), user);
	}

	public static void setDefaultUser() {
		User user=new User("saurabhs39","123456","Saurabh Singh","singhsaurabh@gmail.com","9696848127","E-218 WVN Delhi",true,"");
		setUsers(user);
	}
	
	
	
}
