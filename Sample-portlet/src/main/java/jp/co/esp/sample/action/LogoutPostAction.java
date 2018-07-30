package jp.co.esp.sample.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;

import jp.co.esp.sample.util.LogUtil;

/**
 * ログアウト後処理
 */
public class LogoutPostAction extends Action {

	private static Logger logger = LogUtil.getLogger();

	@Override
	public void run(final HttpServletRequest request, final HttpServletResponse response) throws ActionException {

		logger.debug("### [START] \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" method.");

		final String screenName = (String) request.getAttribute("screenName"); // ユーザ名（ScreenName）

		logger.info(LogUtil.createAuditLogMsg("LOGOUT", screenName));

		logger.debug("### [END] \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" method.");

	}
}