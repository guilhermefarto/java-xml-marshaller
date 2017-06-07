package farto.cleva.guilherme.utils;

import java.util.List;

public abstract class ListUtil {

	public static boolean isNull(List<?> list) {
		return list == null;
	}

	public static boolean isEmptyOrNull(List<?> list) {
		return ListUtil.isNull(list) || list.isEmpty();
	}

	public static boolean isNotEmptyOrNull(List<?> list) {
		return !ListUtil.isEmptyOrNull(list);
	}

}
