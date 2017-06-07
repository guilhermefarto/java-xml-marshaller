package farto.cleva.guilherme.utils;

public abstract class StringUtil {

	public static boolean isEmptyOrNull(String value) {
		return value == null || "".equals(value);
	}

	public static boolean isNotEmptyOrNull(String value) {
		return !StringUtil.isEmptyOrNull(value);
	}

}
