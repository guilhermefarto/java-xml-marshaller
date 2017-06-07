package farto.cleva.guilherme.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DateUtil {

	public static final String DATE_PATTERN = "dd/MM/yyyy";

	private static final DateFormat DF = new SimpleDateFormat(DATE_PATTERN);

	public static Date parse(String value) {
		try {
			return DF.parse(value);
		} catch (Exception e) {
			return null;
		}
	}

	public static String format(Date value) {
		try {
			return DF.format(value);
		} catch (Exception e) {
			return null;
		}
	}

}
