package cn.hassan.common.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String,Date> {
	public Date convert(String s) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
		try {
			Date date = sdf.parse(s);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
