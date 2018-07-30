package jp.co.esp.sample.util;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;

/**
 * ログユーティリティ
 */
public final class LogUtil {

	private static ThreadLocal<ServletRequest> servletRequest = new ThreadLocal<ServletRequest>();

	/**
	 * プライベートコンストラクタ
	 */
	private LogUtil() {
	}

	/**
	 * ロガーを取得する
	 * 
	 * @return ロガー
	 */
	public static Logger getLogger() {
		return LoggerFactory.getLogger(new Throwable().getStackTrace()[1].getClassName());
	}

	/**
	 * ロギング開始処理
	 * 
	 * @param request リクエスト情報
	 */
	public static void startLogging(final ServletRequest request) {
		servletRequest.set(request);
	}

	/**
	 * ロギング終了処理
	 */
	public static void endLogging() {
		servletRequest.remove();
	}

	/**
	 * 操作ログメッセージを作成する<br>
	 * 
	 * @param auditMsg ログメッセージ
	 * @return 操作ログメッセージ
	 */
	public static String createAuditLogMsg(final String auditMsg) {
		return createAuditLogMsg(auditMsg, getScreenName());
	}

	/**
	 * 操作ログメッセージを作成する<br>
	 * 
	 * @param auditMsg メッセージ
	 * @param screenName ユーザ名（ScreenName）
	 * @return 操作ログメッセージ
	 */
	public static String createAuditLogMsg(final String auditMsg, final String screenName) {
		return auditMsg + " [SCREEN_NAME:" + screenName + "]"
				+ " [SESSION_ID:" + getSessionId() + "]";
	}

	/**
	 * ユーザ名（ScreenName）を取得する
	 * 
	 * @return ユーザ名（ScreenName）
	 */
	public static String getScreenName() {
		String screenName = null;
		try {
			final ServletRequest request = servletRequest.get();
			if (request != null) {
				if (request instanceof HttpServletRequest) {
					final HttpServletRequest httpRequest = (HttpServletRequest) request;
					final User user = PortalUtil.getUser(httpRequest);
					if (user != null) {
						screenName = user.getScreenName();
					}
				}
			}
		} catch (final PortalException | SystemException e) {
			e.printStackTrace();
		}
		return screenName;
	}

	/**
	 * セッションIDを取得する
	 * 
	 * @return セッションID
	 */
	public static String getSessionId() {
		String sessionId = null;
		final ServletRequest request = servletRequest.get();
		if (request != null) {
			if (request instanceof HttpServletRequest) {
				final HttpServletRequest httpRequest = (HttpServletRequest) request;
				final HttpSession session = httpRequest.getSession();
				try {
					sessionId = session.getId();
				} catch (final IllegalStateException e) {
					e.printStackTrace();
				}
			}
		}
		return sessionId;
	}
}
