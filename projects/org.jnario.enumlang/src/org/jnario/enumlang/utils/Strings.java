package org.jnario.enumlang.utils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Strings {

	public static String toString(java.io.InputStream is) {
	    try {
	        return new java.util.Scanner(is).useDelimiter("\\A").next();
	    } catch (java.util.NoSuchElementException e) {
	        return "";
	    }
	}

	public static InputStream toInputStream(CharSequence s) {
		byte[] bytes;
		if(s == null){
			bytes = new byte[0];
		}else{
			bytes = s.toString().getBytes();
		}
		return new ByteArrayInputStream(bytes);
	}
	
}
