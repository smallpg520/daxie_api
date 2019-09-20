package com.daxie.daxie_api.core;

import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringEscapeUtils;

/**
 * 字符串工具类, 继承org.apache.commons.lang3.StringUtils类
 */
public final class StringUtils extends org.apache.commons.lang3.StringUtils {

	private final static Pattern COLUMN_PATTERN = Pattern.compile("_\\w");

	private final static Pattern BLANK_PATTERN = Pattern.compile("\\s*|\t|\r|\n");
	
//	public static void main(String[] args) {
//		String[] m = { "1", "2", "3", "4", "5" };
//		String[] n = { "3", "4", };
//
//        System.out.println("----------并集------------");
//        Integer[] b = getB(m, n);
//        for (Integer i : b)
//        {
//            System.out.println(i);
//        }
//
//        System.out.println("----------交集------------");
//        String[] j = getJ(m, n);
//        for (String i : j)
//        {
//            System.out.println(i);
//        }
//
//        System.out.println("----------差集------------");
//        String[] c = getC(m, n);
//        for (String i : c)
//        {
//            System.out.println(i);
//        }
//	}
	
	   /**
     * 求并集
     * 
     * @param m
     * @param n
     * @return
     */
	public static Integer[] getB(Integer[] m, Integer[] n)
    {
        // 将数组转换为set集合
        Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(m));
        Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(n));

        // 合并两个集合
        set1.addAll(set2);

        Integer[] arr = {};
        return set1.toArray(arr);
    }

    /**
     * 求交集
     * 
     * @param m
     * @param n
     * @return
     */
	public static String[] getJ(String[] m, String[] n)
    {
        List<String> rs = new ArrayList<String>();

        // 将较长的数组转换为set
        Set<String> set = new HashSet<String>(Arrays.asList(m.length > n.length ? m : n));

        // 遍历较短的数组，实现最少循环
        for (String i : m.length > n.length ? n : m)
        {
            if (set.contains(i))
            {
                rs.add(i);
            }
        }

        String[] arr = {};
        return rs.toArray(arr);
    }

    /**
     * 求差集
     * 
     * @param m
     * @param n
     * @return
     */
	public static String[] getC(String[] m, String[] n){
        // 将较长的数组转换为set
        Set<String> set = new HashSet<String>(Arrays.asList(m.length > n.length ? m : n));

        // 遍历较短的数组，实现最少循环
        for (String i : m.length > n.length ? n : m)
        {
            // 如果集合里有相同的就删掉，如果没有就将值添加到集合
            if (set.contains(i))
            {
                set.remove(i);
            } else
            {
                set.add(i);
            }
        }

        String[] arr = {};
        return set.toArray(arr);
    }

	
	
	
	 /**
    * StringUtils工具类方法
    * 	获取一定长度的随机字符串，范围0-9，a-z
    * @param length：指定字符串长度
    * @return 一定长度的随机字符串
    */
   public static String getRandomStringByLength(int length) {
       String base = "abcdefghijklmnopqrstuvwxyz0123456789";
       Random random = new Random();
       StringBuffer sb = new StringBuffer();
       for (int i = 0; i < length; i++) {
           int number = random.nextInt(base.length());
           sb.append(base.charAt(number));
       }
       return sb.toString();
   }

   /**
    * StringUtils工具类方法
    * 	获取一定长度的随机字符串，范围0-9 
    * @param length：指定字符串长度
    * @return 一定长度的随机字符串
    */
   public static String getRandomNumberByLength(int length) {
       String base = "0123456789";
       Random random = new Random();
       StringBuffer sb = new StringBuffer();
       for (int i = 0; i < length; i++) {
           int number = random.nextInt(base.length());
           sb.append(base.charAt(number));
       }
       return sb.toString();
   }
   /**
    * 	（可多传多个参数）判断字符串是否为空
    */
   public static boolean isEmpty(String ... str){
       boolean stat = true ;
       for(String  temp: str){
       	System.out.println(temp);
       	System.out.println(temp==null);
       	System.out.println( "".equals(temp));
       	
           if (temp==null || "".equals(temp)  ){
           	stat  = false;
           }
       }
       return stat;
   }

   /**
    * 	（可多传多个参数）判断字符串是否为空(包括对"null")
    */
   public static boolean isNullOrEmpty(String ... str  ){
   	 //遍历参数内容
   	boolean stat = true ;
       for(String temp : str){
           if (temp==null || "".equals(temp) || "null".equals(temp)  ){
           	stat  = false;
           }
           
       }
       return stat;

   }
	
	
	public static String lowerFirst(String str) {
		if (StringUtils.isBlank(str)) {
			return "";
		} else {
			return str.substring(0, 1).toLowerCase() + str.substring(1);
		}
	}

	public static String upperFirst(String str) {
		if (StringUtils.isBlank(str)) {
			return "";
		} else {
			return str.substring(0, 1).toUpperCase() + str.substring(1);
		}
	}

	/**
	 * 替换掉HTML标签方法
	 */
	public static String replaceHtml(String html) {
		if (isBlank(html)) {
			return "";
		}
		String regEx = "<.+?>";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(html);
		String s = m.replaceAll("");
		return s;
	}

	/**
	 * 缩略字符串（不区分中英文字符）
	 * @param str 目标字符串
	 * @param length 截取长度
	 * @return
	 */
	public static String abbr(String str, int length) {
		if (str == null) {
			return "";
		}
		try {
			StringBuilder sb = new StringBuilder();
			int currentLength = 0;
			for (char c : replaceHtml(StringEscapeUtils.unescapeHtml4(str)).toCharArray()) {
				currentLength += String.valueOf(c).getBytes("utf-8").length;
				if (currentLength <= length - 3) {
					sb.append(c);
				} else {
					sb.append("...");
					break;
				}
			}
			return sb.toString();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 缩略字符串（替换html）
	 * @param str 目标字符串
	 * @param length 截取长度
	 * @return
	 */
	public static String rabbr(String str, int length) {
		return abbr(replaceHtml(str), length);
	}

	/**
	 * 转换为Double类型
	 */
	public static Double toDouble(Object val) {
		if (val == null) {
			return 0D;
		}
		try {
			return Double.valueOf(trim(val.toString()));
		} catch (Exception e) {
			return 0D;
		}
	}

	/**
	 * 转换为Float类型
	 */
	public static Float toFloat(Object val) {
		return toDouble(val).floatValue();
	}

	/**
	 * 转换为Long类型
	 */
	public static Long toLong(Object val) {
		return toDouble(val).longValue();
	}

	/**
	 * 转换为Integer类型
	 */
	public static Integer toInteger(Object val) {
		return toLong(val).intValue();
	}

	/**
	 * 获得i18n字符串
	 */
//	public static String getMessage(String code, Object[] args) {
//		return SpringContextHolder.getApplicationContext().getMessage(code, args, Locale.SIMPLIFIED_CHINESE);
//	}

	/**
	 * 获得用户远程地址
	 */
	public static String getRemoteAddr(HttpServletRequest request) {
		String remoteAddr = request.getHeader("X-Real-IP");
		if (isNotBlank(remoteAddr)) {
			remoteAddr = request.getHeader("X-Forwarded-For");
		} else if (isNotBlank(remoteAddr)) {
			remoteAddr = request.getHeader("Proxy-Client-IP");
		} else if (isNotBlank(remoteAddr)) {
			remoteAddr = request.getHeader("WL-Proxy-Client-IP");
		}
		return remoteAddr != null ? remoteAddr : request.getRemoteAddr();
	}

	/**
	 * 将字段名转换成Java规范的属性名，如"MODEL_CODE"--"modelCode"
	 * @param column 字段名称，如"MODEL_CODE"
	 * @return 符合Java规范的属性名(对于连续带多个_的不能成功转换)
	 */
	public static String toProperty(String column) {
		String s = column.toLowerCase();
		Matcher m = COLUMN_PATTERN.matcher(column);
		if (!m.find())
			return s;

		StringBuffer sb = new StringBuffer(100);
		int index = 0;
		while (m.find(index)) {
			sb.append(s.substring(index, m.start()));
			sb.append(m.group().substring(1).toUpperCase());
			index = m.end();
		}
		sb.append(s.substring(index));
		return sb.toString();
	}

	/**
	 * Merged 字符串
	 * 
	 * Format : Hi {0}
	 * @param pattern
	 * @param params
	 * @return
	 */
	public static String getMergeMessage(String pattern, Object... params) {
		return MessageFormat.format(pattern, params);
	}

	/**
	 * 将 \s、\n、\t、\r等替换为空格
	 * @param str
	 * @return
	 */
	public static String replaceBlank(String str) {
		String dest = "";
		if (str == null) {
			return dest;
		}
		Matcher m = BLANK_PATTERN.matcher(str);
		dest = m.replaceAll("");
		return dest;
	}

}
