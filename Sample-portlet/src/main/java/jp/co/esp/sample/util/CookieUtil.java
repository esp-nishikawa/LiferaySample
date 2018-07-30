package jp.co.esp.sample.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

/**
 * Cookieユーティリティ
 */
public final class CookieUtil {

	/**
	 * コンストラクタ
	 */
	private CookieUtil() {
	}

	/**
	 * Cookieから値を取得
	 *
	 * @param httpRequest リクエスト情報
	 * @param key キー
	 * @return String ワンタイムトークン
	 */
	public static String getFromCookie(final HttpServletRequest httpRequest, final String key) {
		String value = null;
		final Cookie[] cookies = httpRequest.getCookies();
		if (cookies != null) {
			for (final Cookie cookie : cookies) {
				if (StringUtils.equals(cookie.getName(), key)) {
					try {
						value = URLDecoder.decode(cookie.getValue(), "UTF-8");
					} catch (final UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
		return value;
	}

	/**
	 * Cookieに指定したキーと値を追加
	 *
	 * @param httpResponse レスポンス情報
	 * @param key キー
	 * @param value 値
	 * @param isSecure セキュアフラグ
	 * @param maxAge 有効期限
	 * @throws IOException 入出力例外
	 */
	public static void addCookie(final HttpServletResponse httpResponse, final String key, final String value,
			final boolean isSecure, final int maxAge)
			throws IOException {
		final Cookie cookie = new Cookie(key, URLEncoder.encode(value, "UTF-8"));
		cookie.setSecure(isSecure);
		if (maxAge > 0) {
			cookie.setMaxAge(maxAge);
		}
		cookie.setPath("/");
		httpResponse.addCookie(cookie);
	}

	/**
	 * Cookieから指定したキーを削除
	 *
	 * @param httpResponse レスポンス情報
	 * @param key キー
	 */
	public static void deleteCookie(final HttpServletResponse httpResponse, final String key) {
		final Cookie cookie = new Cookie(key, "");
		cookie.setMaxAge(0);
		cookie.setPath("/");
		httpResponse.addCookie(cookie);
	}
}