package com.daxie.daxie_api.core;



import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期时间工具类，提供日期时间字符串解析Date对象和Date对象的格式化功能。
 * 
 * 
 * @author C
 */
public class DateUtil {

	/**
	 * 私有构造函数，防止被实例化
	 */
	private DateUtil() {

	}

	/**
	 * 年
	 */
	public static final String FORMAT_DATE_yyyy = "yyyy";
	/**
	 * 年月
	 */
	public static final String FORMAT_DATE_yyyyMM = "yyyyMM";
	/**
	 * 年月日
	 */
	public static final String FORMAT_DATE_yyyyMMdd = "yyyyMMdd";
	/**
	 * 年/月
	 */
	public static final String FORMAT_DATE_yyyyMM_SLASH = "yyyy/MM";
	/**
	 * 年/月/日
	 */
	public static final String FORMAT_DATE_yyyyMMdd_SLASH = "yyyy/MM/dd";
	/**
	 * 年-月
	 */
	public static final String FORMAT_DATE_yyyyMM_MINUS = "yyyy-MM";
	/**
	 * 年-月-日
	 */
	public static final String FORMAT_DATE_yyyyMMdd_MINUS = "yyyy-MM-dd";
	/**
	 * 年月日 时:分:秒
	 */
	public static final String FORMAT_DATEANDTIME_yyyyMMddHHmmss = "yyyyMMdd HH:mm:ss";
	/**
	 * 年/月/日 时:分:秒
	 */
	public static final String FORMAT_DATEANDTIME_yyyyMMddHHmmss_SLASH = "yyyy/MM/dd HH:mm:ss";
	/**
	 * 年-月-日 时:分:秒
	 * ***常用***
	 */
	public static final String FORMAT_DATEANDTIME_yyyyMMddHHmmss_MINUS = "yyyy-MM-dd HH:mm:ss";
	/**
	 * 年月日 时:分:秒
	 */
	public static final String FORMAT_DATEANDTIME_yyyyMMddHHmmssSSS = "yyyyMMdd HH:mm:ss.SSS";
	/**
	 * 年/月/日 时:分:秒.毫秒
	 */
	public static final String FORMAT_DATEANDTIME_yyyyMMddHHmmssSSS_SLASH = "yyyy/MM/dd HH:mm:ss.SSS";
	/**
	 * 年-月-日 时:分:秒.毫秒
	 */
	public static final String FORMAT_DATEANDTIME_yyyyMMddHHmmssSSS_MINUS = "yyyy-MM-dd HH:mm:ss.SSS";
	/**
	 * 年月日时分秒
	 */
	public static final String FORMAT_DATEANDTIME_yyyyMMddHHmmss_NONE = "yyyyMMddHHmmss";
	/**
	 * 年月日时分秒毫秒
	 */
	public static final String FORMAT_DATEANDTIME_yyyyMMddHHmmssSSSS = "yyyyMMddHHmmssSSSS";
	
	
	/***
	 * 淘宝时间
	 */
	public static final  String WEBURL1 = "http://www.taobao.com"; 
	/***
	 * 淘宝时间
	 */
	public static final  String WEBURL2 = "http://www.ntsc.ac.cn"; 
	/***
	 * 360时间
	 */
	public static final  String WEBURL3 = "http://www.360.cn"; 
	/***
	 * 163时间
	 */
	public static final  String WEBURL4 = "http://www.163.com/"; 
	public static final  String WEBURL5 = "https://www.tmall.com/";// ��è
	/***
	 * 	北京时间
	 */
	public static final  String WEBUR_BEIJING = "http://www.beijing-time.org";// beijing-time
	
	/**
	 *  百度时间
	 */
	public static final  String WEBURL_BAIDU = "http://www.baidu.com";
	
	

	
	public static void main(String[] args) {
//		Date d =   parseStringToDate(  DateUtil.getNetworkTime(DateUtil.WEBURL_BAIDU)   ,  DateUtil.FORMAT_DATEANDTIME_yyyyMMddHHmmssSSS_MINUS);
	 
		Date date2=parseStringToDate( "2019-04-01 22:02:10", DateUtil.FORMAT_DATEANDTIME_yyyyMMddHHmmss_MINUS);
	    Date date=	parseStringToDate( "2018-04-01 22:02:10", DateUtil.FORMAT_DATEANDTIME_yyyyMMddHHmmss_MINUS);
	    Integer month= 62/30;
	    System.out.println("222222:"+month);
	    
//	    System.out.println(date.getTime());
		System.out.println(calcDayOffset(date,date2));
//		System.out.println(distributionFee(new Date()));
//		for (int i = 0; i < 24; i++) {
//			Date d1 = new Date(); 
//			Calendar c = Calendar.getInstance();  
//			c.setTime(d1);
//			c.set(Calendar.HOUR_OF_DAY , i ); 		//设置时
//			c.set(Calendar.MINUTE ,30); 			//设置分
//			c.set(Calendar.SECOND ,30); 			//设置秒
//			d1=c.getTime();
//			
//			System.out.println(i+"---->"+distributionFee(d1));
//		}
		

//			for (int i = 0; i < 24; i++) {
//				Date d1 = new Date();
//				Calendar c = Calendar.getInstance();
//				c.setTime(d1);
//				c.set(Calendar.HOUR_OF_DAY , i ); 		//设置时
//				c.set(Calendar.MINUTE ,30); 			//设置分
//			c.set(Calendar.SECOND ,30); 			//设置秒
//			d1=c.getTime();
//			
//		}
	}
	

	
	
	
	
	
	// *********************解析字符串为日期格式*********************//

	/**
	 * 将日期字符串对象格式化为一个日期Date对象。
	 * 
	 * @param dateStr   日期字符串
	 * @param formatStr 格式化字符串
	 * @return 日期Date对象。
	 */
	public static Date parseStringToDate(String dateStr, String formatStr) {
		SimpleDateFormat sFormat = new SimpleDateFormat(formatStr);
		try {
			Date date = sFormat.parse(dateStr);
			return date;
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	/**
	 * 格式化输入的日期Date对象
	 * 
	 * @param date      待格式化的日期Date对象
	 * @param formatStr 格式化字符串
	 * @return 经过格式化后的日期对象
	 */
	public static String formatDate(Date date, String formatStr) {
		SimpleDateFormat sFormat = new SimpleDateFormat(formatStr);
		return sFormat.format(date);
	}

	/**
	 * 获取日期中指定字段的值。
	 * 
	 * @param date  日期
	 * @param field 指定的字段，可由Calendar类的静态字段指定。
	 * @return 指定字段对应的值。
	 */
	public static int getFieldValue(Date date, int field) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(field);
	}

	/**
	 * 获取当前的年份
	 */
	public static int getCurrentYear() {
		int year = DateUtil.getFieldValue(new Date(), Calendar.YEAR);

		return year;
	}

	/**
	 * 获取当前的季度
	 */
	public static int getCurrentQuarter() {
		int month = DateUtil.getFieldValue(new Date(), Calendar.MONTH);
		int quarter = 1;
		if (month == 1 || month == 2 || month == 3)
			quarter = 1;
		else if (month == 4 || month == 5 || month == 6)
			quarter = 2;
		else if (month == 7 || month == 8 || month == 9)
			quarter = 3;
		else if (month == 10 || month == 11 || month == 12)
			quarter = 4;

		return quarter;
	}

	/**
	 * 获取当前月
	 */
	public static int getCurrentMonth() {
		int month = DateUtil.getFieldValue(new Date(), Calendar.MONTH) + 1;

		return month;
	}

	/**
	 * 获取当前所在月的天数
	 */
	public static int getCurrentDay() {
		int day = DateUtil.getFieldValue(new Date(), Calendar.DAY_OF_MONTH);

		return day;
	}

	/**
	 * 获取两个时期之间的天数差
	 * 
	 * @param oldDate 老日期
	 *
	 * @param newDate 新日期
	 * 
	 *                return 两个日期之间的天数差
	 */
	public static int getDaysFromDates(Date oldDate, Date newDate) {
		int days = (int) ((newDate.getTime() - oldDate.getTime()) / 86400000);
		return days;
	}

	/**
	 * 获取从某一年，某一月开始，所有的工作日
	 * 
	 */
	public static ArrayList<Date> getDates(int year, int month, int d) {
		ArrayList<Date> dates = new ArrayList<Date>();

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DATE, d);

		while (cal.get(Calendar.YEAR) == year && cal.get(Calendar.MONTH) < month) {
			int day = cal.get(Calendar.DAY_OF_WEEK);

			if (!(day == Calendar.SUNDAY || day == Calendar.SATURDAY)) {
				dates.add((Date) cal.getTime().clone());
			}
			cal.add(Calendar.DATE, 1);
		}

		return dates;
	}

	/**
	 * 将date往前推迟days天
	 */
	public static Date DelayDateByDay(Date date, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, days);

		Date delayDate = calendar.getTime();
		return delayDate;
	}

	/**
	 * @author LuoB.
	 * @param oldTime 较小的时间
	 * @param newTime 较大的时间 (如果为空 默认当前时间 ,表示和当前时间相比)
	 * @return -1 ：同一天. 0：昨天 . 1 ：至少是前天.
	 * @throws ParseException 转换异常
	 */
	public static int isYeaterday(Date oldTime, Date newTime) throws ParseException {
		if (newTime == null) {
			newTime = new Date();
		}
		// 将下面的 理解成 yyyy-MM-dd 00：00：00 更好理解点
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String todayStr = format.format(newTime);
		Date today = format.parse(todayStr);
		// 昨天 86400000=24*60*60*1000 一天
		if ((today.getTime() - oldTime.getTime()) > 0 && (today.getTime() - oldTime.getTime()) <= 86400000) {
			return 0;
		} else if ((today.getTime() - oldTime.getTime()) <= 0) { // 至少是今天
			return -1;
		} else { // 至少是前天
			return 1;
		}

	}

	/***
	 * 计算天数差
	 * 
	 * @param oldDate
	 * @param newDate
	 * @return
	 */
	public static int calcDayOffset(Date oldDate, Date newDate) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(oldDate);

		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(newDate);
		int day1 = cal1.get(Calendar.DAY_OF_YEAR);
		int day2 = cal2.get(Calendar.DAY_OF_YEAR);

		int year1 = cal1.get(Calendar.YEAR);
		int year2 = cal2.get(Calendar.YEAR);
		if (year1 != year2) { // 同一年
			int timeDistance = 0;
			for (int i = year1; i < year2; i++) {
				if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) { // 闰年
					timeDistance += 366;
				} else { // 不是闰年
					timeDistance += 365;
				}
			}
			return timeDistance + (day2 - day1);
		} else { // 不同年
			return day2 - day1;
		}
	}

	/**
	 * date2比date1多的周数
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static int calcWeekOffset(Date startTime, Date endTime) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(startTime);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		dayOfWeek = dayOfWeek - 1;
		if (dayOfWeek == 0)
			dayOfWeek = 7;

		int dayOffset = calcDayOffset(startTime, endTime);

		int weekOffset = dayOffset / 7;
		int a;
		if (dayOffset > 0) {
			a = (dayOffset % 7 + dayOfWeek > 7) ? 1 : 0;
		} else {
			a = (dayOfWeek + dayOffset % 7 < 1) ? -1 : 0;
		}
		weekOffset = weekOffset + a;
		return weekOffset;
	}

	/**
	 * 获取网络时间
	 * @param webUrl
	 * @return
	 */
	public static String getNetworkTime(String webUrl) {
		try {
			URL url = new URL(webUrl);
			URLConnection conn = url.openConnection();
			conn.connect();
			long dateL = conn.getDate();
			Date date = new Date(dateL);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return dateFormat.format(date);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "";
	}
 
	
	/**
	 * 计算两个时间差，返回相差的毫秒数
	 * 
	 * @param startTime 开始时间，yyyy-MM-dd HH:mm:ss形式
	 * @param endTime   结束时间，yyyy-MM-dd HH:mm:ss形式
	 * @return 两时间差的毫秒数
	 */
	public static Long getTimeMill(String startTime, String endTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Long timMill = 0L;// 两个时间相差毫秒数

		try {
			timMill = sdf.parse(endTime).getTime() - sdf.parse(startTime).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return timMill;
	}

	/**
	 * 获取时间差，返回H:M:S形式
	 * 
	 * @param startTime 开始时间，yyyy-MM-dd HH:mm:ss形式
	 * @param endTime   结束时间，yyyy-MM-dd HH:mm:ss形式
	 * @return H:M:S
	 */
	public static String getTimeDifference(String startTime, String endTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Long timMill = 0L;// 两个时间相差毫秒数

		try {
			timMill = sdf.parse(endTime).getTime() - sdf.parse(startTime).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Integer ss = 1000;
		Integer mi = ss * 60;
		Integer hh = mi * 60;
		Integer dd = hh * 24;

		long day = timMill / dd;
		long hour = (timMill - day * dd) / hh;
		long miunte = (timMill - day * dd - hour * hh) / mi;
		long second = (timMill - day * dd - hour * hh - miunte * mi) / ss;

		String timeDiff = day * 24 + hour + ":" + miunte + ":" + second;

		return timeDiff;
	}
	
	/**
	 * 将毫秒数转为分钟数
	 * @param MillTime 毫秒值
	 * @return 分钟值
	 */
    public static double getMin(Long MillTime){

        Integer ss = 1000;
        Integer mi = ss * 60;
        Integer hh = mi * 60;
        Integer dd = hh * 24;

        long day = MillTime / dd;
        long hour = (MillTime - day * dd) / hh;
        long minute = (MillTime - day * dd - hour * hh) / mi;
        long second = (MillTime - day * dd - hour * hh - minute * mi) / ss;

        double doubleTime = day * 24 * 60 + minute + second / (double)60;
        BigDecimal bigDecimal = new BigDecimal(doubleTime);
        double time = bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();//保留两位小数，四舍五入

        return time;
    }

 

}
