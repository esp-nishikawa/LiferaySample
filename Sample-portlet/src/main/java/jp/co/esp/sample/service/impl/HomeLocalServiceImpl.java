package jp.co.esp.sample.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;

import jp.co.esp.sample.model.Information;
import jp.co.esp.sample.service.base.HomeLocalServiceBaseImpl;
import jp.co.esp.sample.service.persistence.InformationUtil;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

/**
 * The implementation of the home local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link jp.co.esp.sample.service.HomeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Bria Wig Shu Cha
 * @see jp.co.esp.sample.service.base.HomeLocalServiceBaseImpl
 * @see jp.co.esp.sample.service.HomeLocalServiceUtil
 */
public class HomeLocalServiceImpl extends HomeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * jp.co.esp.sample.service.HomeLocalServiceUtil} to access the home
	 * local service.
	 */

	private static Log logger = LogFactoryUtil.getLog(HomeLocalServiceImpl.class);

	/**
	 * お知らせ情報を返す
	 *
	 * @param loginUser ログインユーザー
	 * @param info APIリクエストパラメータ
	 * @return JSONObject
	 * @throws SystemException
	 */
	@Override
	public Object getHomeInfo(final User loginUser, final HashMap<String, String> info) throws SystemException {
		final JSONObject ret = new JSONObject();

		final List<Information> informationList = InformationUtil.findByInformationList(new Date());
		final JSONArray infoJSONArray = new JSONArray();
		if (informationList != null) {
			for (final Information information : informationList) {
				final JSONObject infoJSON = new JSONObject();
				infoJSON.put("informationnumber", information.getInformationnumber());
				infoJSON.put("title", information.getTitle());
				infoJSON.put("content", information.getContent());
				final Date fromDate = information.getFromdate();
				final SimpleDateFormat sbt = new SimpleDateFormat("yyyy/MM/dd");
				infoJSON.put("fromdate", sbt.format(fromDate));
				infoJSON.put("informationlevel", information.getInformationlevel());
				infoJSON.put("createdat", information.getCreatedat());
				infoJSON.put("createdby", information.getCreatedby());
				infoJSON.put("modifiedat", information.getModifiedat());
				infoJSON.put("modifiedby", information.getModifiedby());
				infoJSONArray.add(infoJSON);
			}
		}
		ret.put("informationList", infoJSONArray);
		return ret;
	}
}
