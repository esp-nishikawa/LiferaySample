package jp.co.esp.sample.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

/**
 * Servletユーティリティ
 */
public final class ServletUtil {

	/**
	 * コンストラクタ
	 */
	private ServletUtil() {
	}

	/**
	 * リクエストURL取得
	 * 
	 * @param httpRequest リクエスト情報
	 * @return リクエストURL
	 */
	public static String getRequestURL(final HttpServletRequest httpRequest) {
		String requestURL = new String(httpRequest.getRequestURL());
		final String requestQuery = httpRequest.getQueryString();
		if (!StringUtils.isEmpty(requestQuery)) {
			requestURL = requestURL + "?" + requestQuery;
		}
		return requestURL;
	}

	/**
	 * 同一ドメインチェック
	 * 
	 * @param url1 URL1
	 * @param url2 URL2
	 * @return boolean 同一ドメイン:true
	 * @throws IOException 入出力例外
	 */
	public static boolean equalsDomain(final String url1, final String url2)
			throws IOException {
		if (StringUtils.isEmpty(url1) || StringUtils.isEmpty(url2)) {
			throw new MalformedURLException();
		}
		final String host1 = new URL(url1).getHost();
		final String host2 = new URL(url2).getHost();
		return host1.equals(host2);
	}

	/**
	 * リダイレクト
	 * 
	 * @param httpResponse レスポンス情報
	 * @param url リダイレクトURL
	 */
	public static void redirectSeeOther(final HttpServletResponse httpResponse, final String url) {
		final URI uri = URI.create(url);
		httpResponse.setStatus(HttpServletResponse.SC_SEE_OTHER);
		httpResponse.setHeader("Location", uri.toString());
	}

	/**
	 * リクエスト情報のダンプ
	 * 
	 * @param httpRequest リクエスト情報
	 * @return リクエスト情報のダンプ
	 */
	@SuppressWarnings("rawtypes")
	public static String dumpRequest(final HttpServletRequest httpRequest) {
		final StringBuilder sb = new StringBuilder();

		sb.append("*** DUMP REQUEST START ***\n");

		sb.append("    AuthType: " + httpRequest.getAuthType() + "\n");
		sb.append("    CharacterEncoding: " + httpRequest.getCharacterEncoding() + "\n");
		sb.append("    ContentLength: " + httpRequest.getContentLength() + "\n");
		sb.append("    ContentType: " + httpRequest.getContentType() + "\n");
		sb.append("    ContextPath: " + httpRequest.getContextPath() + "\n");
		sb.append("    Locale: " + httpRequest.getLocale() + "\n");
		sb.append("    LocalAddr: " + httpRequest.getLocalAddr() + "\n");
		sb.append("    LocalName: " + httpRequest.getLocalName() + "\n");
		sb.append("    LocalPort: " + httpRequest.getLocalPort() + "\n");
		sb.append("    Method: " + httpRequest.getMethod() + "\n");
		sb.append("    PathInfo: " + httpRequest.getPathInfo() + "\n");
		sb.append("    PathTranslated: " + httpRequest.getPathTranslated() + "\n");
		sb.append("    Protocol: " + httpRequest.getProtocol() + "\n");
		sb.append("    QueryString: " + httpRequest.getQueryString() + "\n");
		sb.append("    RemoteAddr: " + httpRequest.getRemoteAddr() + "\n");
		sb.append("    RemoteHost: " + httpRequest.getRemoteHost() + "\n");
		sb.append("    RemotePort: " + httpRequest.getRemotePort() + "\n");
		sb.append("    RemoteUser: " + httpRequest.getRemoteUser() + "\n");
		sb.append("    RequestURI: " + httpRequest.getRequestURI() + "\n");
		sb.append("    RequestedSessionId: " + httpRequest.getRequestedSessionId() + "\n");
		sb.append("    RequestedSessionIdValid: " + httpRequest.isRequestedSessionIdValid() + "\n");
		sb.append("    RequestedSessionIdFromCookie: " + httpRequest.isRequestedSessionIdFromCookie() + "\n");
		sb.append("    RequestedSessionIdFromURL: " + httpRequest.isRequestedSessionIdFromURL() + "\n");
		sb.append("    Scheme: " + httpRequest.getScheme() + "\n");
		sb.append("    Secure: " + httpRequest.isSecure() + "\n");
		sb.append("    ServerName: " + httpRequest.getServerName() + "\n");
		sb.append("    ServerPort: " + httpRequest.getServerPort() + "\n");
		sb.append("    ServletPath: " + httpRequest.getServletPath() + "\n");

		sb.append("    Parameter:\n");
		final Enumeration paramNames = httpRequest.getParameterNames();
		while (paramNames.hasMoreElements()) {
			final String name = (String) paramNames.nextElement();
			final String[] values = httpRequest.getParameterValues(name);
			sb.append("        " + name + " : " + Arrays.toString(values) + "\n");
		}

		sb.append("    Header:\n");
		final Enumeration headerNames = httpRequest.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			final String name = (String) headerNames.nextElement();
			final String value = httpRequest.getHeader(name);
			sb.append("        " + name + " : " + value + "\n");
		}

		sb.append("    Attributes:\n");
		final Enumeration attributeNames = httpRequest.getAttributeNames();
		while (attributeNames.hasMoreElements()) {
			final String name = (String) attributeNames.nextElement();
			final Object value = httpRequest.getAttribute(name);
			sb.append("        " + name + " : " + value + "\n");
		}

		sb.append("    Cookies:\n");
		final Cookie[] cookies = httpRequest.getCookies();
		if (cookies.length > 0) {
			for (int i = 0; i < cookies.length; i++) {
				final String name = cookies[i].getName();
				final String value = cookies[i].getValue();
				sb.append("        " + name + " : " + value + "\n");
			}
		}

		sb.append("*** DUMP REQUEST END ***\n");
		return sb.toString();
	}
}