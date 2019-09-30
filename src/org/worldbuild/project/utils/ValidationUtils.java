package org.worldbuild.project.utils;

public interface ValidationUtils {
	
	
	public static boolean isNotValid(String field) {
		if (field==null|| field=="") {
			return true;
		}
		return false;
	};

}
