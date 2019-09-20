package com.daxie.daxie_api.core;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;


public class BaseController {

	protected final String SUCCESS = "success";
	protected final String FAIL = "fail";
	
	/***
	 * 	管理员Session名 
	 */
	public static final String adminSessionName = "adminInfo";				 
	/***
	 * 	机构人员Session名 
	 */
	public static final String organizaitonSessionName = "organizaitonInfo"; 
	
	/**
	 * 上传文件
	 * 
	 * @param request
	 * @param baseResourceUrl
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	public String uploadResourceFile(HttpServletRequest request, MultipartFile resourceFile,String baseResourceUrl)
			throws IllegalStateException, IOException {
		int currentMonth = DateUtil.getCurrentMonth();
		int currentYear = DateUtil.getCurrentYear();
		//文件名带后缀
		String fileName =  System.currentTimeMillis()+ resourceFile.getOriginalFilename().substring(resourceFile.getOriginalFilename().lastIndexOf("."));
		StringBuffer url = new StringBuffer("");
		// 如果文件不为空，写入上传路径
		if (!resourceFile.isEmpty()) {
			// 上传文件路径
			//StringBuffer pathBuffer = new StringBuffer(File.separator).append("opt").append(File.separator).append("resource").append(File.separator ).append(currentYear).append(File.separator ).append(currentMonth) ;
			StringBuffer pathBuffer = new StringBuffer("D:\\upload").append(File.separator).append("opt").append(File.separator).append("resource").append(File.separator ).append(currentYear).append(File.separator ).append(currentMonth) ;
			File filepath = new File(pathBuffer.toString());
			// 判断路径是否存在，如果不存在就创建一个
			if (!filepath.exists()) {
				filepath.mkdirs();
			}
			// 将上传文件保存到一个目标文件当中
			resourceFile.transferTo(new File(pathBuffer.toString() + File.separator + fileName));
			if(null != baseResourceUrl && !"/".equals(baseResourceUrl.substring(baseResourceUrl.length()-1))) {
				url.append(baseResourceUrl).append(File.separator ).append(currentYear).append(File.separator ).append(currentMonth).append( File.separator).append(fileName);
			}else {
				url.append(baseResourceUrl).append(currentYear).append(File.separator ).append(currentMonth).append( File.separator).append(fileName);
			}
		}
		return url.toString();
	}
	
	
	
	
	
	
	
	
	/**
	 * session获取当前登录用户
	 * @return 
	 * @return
	 */
	public <T> T getSessionUser(HttpServletRequest request, String attributeName, Class<T> sessionBeanClass) {
		if(StringUtils.isEmpty(attributeName)) {
			return null;
		}
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(12 * 60 * 60);
		Object bean = session.getAttribute(attributeName);
		if(null == bean) {
			return null;
		}
		Map<String, Object> map = BeanUtils.toMap(bean, false);
		T sessionBean = BeanUtils.toBean(sessionBeanClass, map);
		return sessionBean;
	}
	/**
	 * 判断是否登陆
	 * @param request
	 * @param attributeName
	 * @return
	 */
	public Boolean isLogin(HttpServletRequest request,String attributeName) {
		if(StringUtils.isNotEmpty(attributeName)) {
			Object sessionBean = request.getSession().getAttribute(attributeName);
			if(null != sessionBean) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public Map<String , String> getRequestParams(HttpServletRequest request){
		Map<String, String> paramsMap = new HashMap<>();
		Enumeration<String> enu=request.getParameterNames();  
		while(enu.hasMoreElements()){  
			String paraName= enu.nextElement();  
			paramsMap.put(paraName, request.getParameter(paraName));
		}
		return paramsMap;
	}
	
	/**
	 * 获取客户端IP
	 * 
	 * @author ZhangLong
	 * @date 2014-2-16 上午11:08:15
	 * @param request
	 * @return
	 */
	public static String getClientIP4(HttpServletRequest request) {
		if (request != null) {
			String ip = request.getHeader("x-forwarded-for");
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("WL-Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getRemoteAddr();
			}
			return ip;
		} else {
			return "";
		}
	}
	
	public String getClientIp(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
			// 多次反向代理后会有多个ip值，第一个ip才是真实ip
			int index = ip.indexOf(",");
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		}
		ip = request.getHeader("X-Real-IP");
		if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
			return ip;
		}
		return request.getRemoteAddr();
	}
	
	public String getDemoSessionUsername(HttpServletRequest request){
		Object usernameStr = request.getSession().getAttribute("username");
		if(null != usernameStr){
			return String.valueOf(usernameStr);
		}
		return null;
		
	}

}
