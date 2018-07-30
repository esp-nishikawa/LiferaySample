package jp.co.esp.sample.service.impl;

import java.util.HashMap;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;

import jp.co.esp.sample.service.HomeLocalServiceUtil;
import jp.co.esp.sample.service.base.HomeServiceBaseImpl;
import jp.co.esp.sample.util.LogUtil;
import jp.co.esp.sample.util.ResponseUtil;

/**
 * The implementation of the home remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the
 * {@link jp.co.esp.sample.service.HomeService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see jp.co.esp.sample.service.base.HomeServiceBaseImpl
 * @see jp.co.esp.sample.service.HomeServiceUtil
 */
public class HomeServiceImpl extends HomeServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link jp.co.esp.sample.service.HomeServiceUtil} to access the home remote service.
	 */
	private static Log logger = LogFactoryUtil.getLog(HomeServiceImpl.class);

	/**
	 * お知らせ情報を返す
	 * 
	 * @param info APIリクエストパラメータ
	 * @return お知らせ情報
	 */
	@Override
	@JSONWebService(method = "GET")
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JSONObject getHomeInfo(final HashMap info) {
		Object ret = new Object();
		final ResponseUtil util = new ResponseUtil();
		try {
			final User loginUser = super.getUser();
			ret = HomeLocalServiceUtil.getHomeInfo(loginUser, info);
			logger.info(LogUtil.createAuditLogMsg("HOME"));
		} catch (final PortalException | SystemException | RuntimeException e) {
			logger.error(LogUtil.createAuditLogMsg(e.getMessage()), e);
			return util.createResponseJSON(false, ret, e.toString());
		}
		return util.createResponseJSON(true, ret);
	}

}