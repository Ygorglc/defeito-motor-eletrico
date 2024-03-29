package com.costa.ygor.defeito_motor_eletrico.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public abstract class Criptografia {
	private static MessageDigest md = null;

	static {
		try {
			md = MessageDigest.getInstance("MD5");
		}
		catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
	}

	public static String md5(String password) {
		if (md != null) {
			return new String(hexCodes(md.digest(password.getBytes())));
		}
		return null;
	}

	private static char[] hexCodes(byte[] text) {
		char[] hexOutput = new char[text.length * 2];
		String hexString;

		for (int i = 0; i < text.length; i++) {
			hexString = "00" + Integer.toHexString(text[i]);
			hexString.getChars(hexString.length() - 2, hexString.length(), hexOutput, i * 2);
		}
		return hexOutput;
	}
}
