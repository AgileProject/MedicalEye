package cn.edu.seu.eye.module.base.utils;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ResourceBundleUtil {

	private static ResourceBundle resb = ResourceBundle.getBundle("message",
			Locale.getDefault());

	public static String getBundleMessage(String key) {
		try {
			return resb.getString(key);
		} catch (MissingResourceException e) {
			return null;
		}

	}
}
