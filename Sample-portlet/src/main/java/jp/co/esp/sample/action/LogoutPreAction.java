package jp.co.esp.sample.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;

import jp.co.esp.sample.util.LogUtil;

/**
 * ログアウト前処理
 */
public class LogoutPreAction extends Action {

	private static Logger logger = LogUtil.getLogger();

	@Override
	public void run(final HttpServletRequest request, final HttpServletResponse response) throws ActionException {

		logger.debug("### [START] \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" method.");

		// ユーザ名（ScreenName）を取得
		final String screenName = LogUtil.getScreenName();

		// パラメータをリクエストスコープにセット
		request.setAttribute("screenName", screenName);

		logger.debug("### [END] \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" method.");

	}
}