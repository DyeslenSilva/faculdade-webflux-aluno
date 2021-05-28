package es.faculdade.moodle.aluno.util;

import javax.servlet.http.HttpServletRequest;

import lombok.Getter;
import lombok.Setter;

public class URLUtils {
	
	
	@Getter @Setter
	private String urlsUtils;
	
	public static String getBaseUrl(HttpServletRequest request) {
		String scheme = request.getScheme();
		String serveName= request.getServerName();
		int serverPort = request.getServerPort();
		String contextPath = request.getContextPath();
		StringBuffer url = new StringBuffer();
		url.append(scheme).append("://").append(serveName);
		if((serverPort!=80) && (serverPort !=443)) {
			url.append(":").append(serverPort);
		}
		url.append(contextPath);
		if(url.toString().endsWith("/")) {
			url.append("/");
		}
		
		return url.toString();
	}
}
