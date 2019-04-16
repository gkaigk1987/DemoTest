package com.gk.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Random;

public class DateUtil {
	
	/**
	 * 日期按格式化转换成字符串
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String date2String(Date date, String pattern) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(date);		
	}

	/**
	 * 获取一个时间段内的随机时间点
	 * @param startSate
	 * @param endDate
	 * @return
	 */
	public static long randomTime(String startSate, String endDate) {
		SimpleDateFormat spf = new SimpleDateFormat("yyyyMMdd");
		try {
			Date start = spf.parse(startSate);
			Date end = spf.parse(endDate);
			if(start.getTime() >= end.getTime()) {
				return 0;
			}
			long random = random(start.getTime(), end.getTime());
			return random / 1000;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static long randomTime(String startSate, String endDate,String pattern) {
		SimpleDateFormat spf = new SimpleDateFormat(pattern);
		try {
			Date start = spf.parse(startSate);
			Date end = spf.parse(endDate);
			if(start.getTime() >= end.getTime()) {
				return 0;
			}
			long random = random(start.getTime(), end.getTime());
			return random / 1000;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}

	private static long random(long begin, long end) {
		long rtn = begin + (long) (Math.random() * (end - begin));
		if (rtn == begin || rtn == end) {
			return random(begin, end);
		}
		return rtn;
	}
	
	/**
	 * long类型时间转字符串型(根据转化模式)
	 * @param dateLong
	 * @param pattern
	 * @return
	 */
	public static String long2String(long dateLong, String pattern) {
		if(0 == dateLong) {
			return null;
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date date = new Date(dateLong * 1000);
		return simpleDateFormat.format(date);
	}
	
	/**
	 * 时间随机增加1-100秒
	 * @param time
	 * @return
	 * @throws ParseException
	 */
	public static String timePlusRandomSeconds(String time) throws ParseException {
		//生成1000-10000之间的额随机属于
		Random random = new Random();
		int plusSeconds = random.nextInt(99000) + 1000;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = sdf.parse(time);
		date.setTime(date.getTime() + plusSeconds);
		return sdf.format(date);
	}
	
	/**
	 * 时间随机减少1-100秒
	 * @param time
	 * @return
	 */
	public static String timeMinusRandomSeconds(String time) {
		DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		LocalDateTime localDateTime = LocalDateTime.parse(time, ofPattern);
		Random random = new Random();
		int nextInt = random.nextInt(100);
		localDateTime = localDateTime.minusSeconds(nextInt);
		return localDateTime.format(ofPattern);
	}
	
	/**
	 * 时间随机增加3-10分钟
	 * @param time
	 * @return
	 */
	public static String timePlusRandomMinites(String time) {
		Random random = new Random();
		int plusSeconds = random.nextInt(420) + 180;
		LocalDateTime localDateTime = LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		localDateTime = localDateTime.plusSeconds(plusSeconds);
		return localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
	}
	
	/**
	 * 时间增加秒，分钟，小时
	 * @param time
	 * @param plus
	 * @param type
	 * @return
	 */
	public static String timePlus(String time, long plus, String type) {
		DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		LocalDateTime localDateTime = LocalDateTime.parse(time, ofPattern);
		if("SEC".equals(type)) {
			//加秒
			localDateTime = localDateTime.plusSeconds(plus);
		}else if("MIN".equals(type)) {
			//加分钟
			localDateTime = localDateTime.plusMinutes(plus);
		}else {
			//加小时
			localDateTime = localDateTime.plusHours(plus);
		}
		return localDateTime.format(ofPattern);
	}
	
	/**
	 * 计算两个时间的时间差
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static long timeDuration(String startTime, String endTime,ChronoUnit unit) {
		DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		LocalDateTime start = LocalDateTime.parse(startTime, ofPattern);
		LocalDateTime end = LocalDateTime.parse(endTime, ofPattern);
		long until = start.until(end, unit);
		return until;
	}
	
	/**
	 * 
	 * @param startDay
	 * @param random
	 * @return
	 */
	public static String dayPlus(String startDay,long days) {
		DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyyMMdd");
		LocalDate localDate = LocalDate.parse(startDay, ofPattern);
		localDate = localDate.plusDays(days);
		return localDate.format(ofPattern);
	}
}
