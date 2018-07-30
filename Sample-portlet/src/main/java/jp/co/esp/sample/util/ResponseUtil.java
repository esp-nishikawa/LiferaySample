package jp.co.esp.sample.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONNavi;
import net.minidev.json.JSONObject;

/**
 * レスポンスマップユーティティ
 */
public class ResponseUtil {

	/** ステータス （true:正常 false:異常） */
	private boolean status = false;

	/** データ */
	private Object resDatas;

	/** 例外情報 */
	private Object exceptionInfo;

	/**
	 * JSONレスポンス取得
	 * 
	 * @param status ステータス
	 * @param data 返却用DATAが格納されたObject
	 * @return JSON形式のString
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public com.liferay.portal.kernel.json.JSONObject createResponseJSON(final boolean status, final Object data) {
		this.status = status;

		if (data == null || StringUtils.isEmpty(data.toString())) {
			return this.getResponseJSON();
		} else {
			if (data instanceof List) {
				if (CollectionUtils.isNotEmpty((List<Map>) data)) {
					final JSONArray res = new JSONArray();
					res.addAll((List<Map>) data);
					this.resDatas = res;
				}
			} else if (data instanceof Map) {
				if (MapUtils.isNotEmpty((Map) data)) {
					this.resDatas = new JSONObject((Map) data);
				}
			} else if (data instanceof JSONObject) {
				final JSONObject obj = (JSONObject) data;
				if (!obj.isEmpty()) {
					this.resDatas = obj;
				}
			} else if (data instanceof JSONArray) {
				final JSONArray obj = (JSONArray) data;
				if (!obj.isEmpty()) {
					this.resDatas = obj;
				}
			} else if (data instanceof String) {
				this.resDatas = data;
			}
		}

		return this.getResponseJSON();
	}

	/**
	 * JSONレスポンス取得
	 * 
	 * @param status ステータス
	 * @param data 返却用DATAが格納されたObject
	 * @param exceptionInfo 例外情報
	 * @return JSON形式のString
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public com.liferay.portal.kernel.json.JSONObject createResponseJSON(final boolean status, final Object data, final String exceptionInfo) {
		this.status = status;
		this.exceptionInfo = exceptionInfo;

		if (data == null || StringUtils.isEmpty(data.toString())) {
			return this.getResponseJSON();
		} else {
			if (data instanceof List) {
				if (CollectionUtils.isNotEmpty((List<Map>) data)) {
					final JSONArray res = new JSONArray();
					res.addAll((List<Map>) data);
					this.resDatas = res;
				}
			} else if (data instanceof Map) {
				if (MapUtils.isNotEmpty((Map) data)) {
					this.resDatas = new JSONObject((Map) data);
				}
			} else if (data instanceof JSONObject) {
				final JSONObject obj = (JSONObject) data;
				if (!obj.isEmpty()) {
					this.resDatas = obj;
				}
			} else if (data instanceof JSONArray) {
				final JSONArray obj = (JSONArray) data;
				if (!obj.isEmpty()) {
					this.resDatas = obj;
				}
			} else if (data instanceof String) {
				this.resDatas = data;
			}
		}

		return this.getResponseJSON();
	}

	/**
	 * JSONレスポンスを書き込む
	 * 
	 * @param httpResponse レスポンス情報
	 * @param status ステータス
	 * @param data 返却用DATAが格納されたObject
	 * @param exceptionInfo 例外情報
	 * @throws IOException 入出力例外
	 */
	public void writeResponseJSON(final HttpServletResponse httpResponse,
			final boolean status, final Object data, final String exceptionInfo)
			throws IOException {
		httpResponse.setContentType("application/json;charset=UTF-8");
		final PrintWriter writer = httpResponse.getWriter();
		writer.print(this.createResponseJSON(status, data, exceptionInfo));
		writer.flush();
		writer.close();
	}

	/**
	 * JSONレスポンス作成
	 * 
	 * @return com.liferay.portal.kernel.json.JSONObject
	 */
	private com.liferay.portal.kernel.json.JSONObject getResponseJSON() {

		if (this.resDatas == null || StringUtils.isEmpty(this.resDatas.toString())) {
			this.resDatas = "";
		}
		if (this.exceptionInfo == null) {
			this.exceptionInfo = "";
		}

		JSONNavi<String> navi = null;
		if (this.resDatas instanceof JSONObject) {
			final JSONObject obj = (JSONObject) this.resDatas;
			navi = new JSONNavi<String>(obj.toString());
		} else if (this.resDatas instanceof JSONArray) {
			final JSONArray obj = (JSONArray) this.resDatas;
			navi = new JSONNavi<String>(obj.toString());
		} else {
			navi = new JSONNavi<String>((String) this.resDatas);
		}

		final com.liferay.portal.kernel.json.JSONObject ret = this.serialize(
				ArrayUtils.toMap(new Object[][] {
						{ "status", Boolean.toString(this.status) },
						{ "data", navi.getCurrentObject() },
						{ "exceptionInfo", this.exceptionInfo }
				}));

		return ret;
	}

	/**
	 * com.liferay.portal.kernel.json.JSONObject 作成
	 * 
	 * @param m map
	 * @return com.liferay.portal.kernel.json.JSONObject
	 */
	@SuppressWarnings("rawtypes")
	private com.liferay.portal.kernel.json.JSONObject serialize(final Map m) {
		final com.liferay.portal.kernel.json.JSONObject ret = com.liferay.portal.kernel.json.JSONFactoryUtil.createJSONObject();

		for (final Object k : m.keySet()) {
			final Object v = m.get(k);

			if (v == null || "null".equals(v)) {
				ret.put(String.valueOf(k), "");
			} else if (v instanceof List) {
				ret.put(String.valueOf(k), this.serialize((List) v));
			} else if (v.getClass().isArray()) {
				ret.put(String.valueOf(k), this.serialize((Object[]) v));
			} else if (v instanceof Map) {
				ret.put(String.valueOf(k), this.serialize((Map) v));
			} else {
				ret.put(String.valueOf(k), String.valueOf(v));
			}
		}
		return ret;
	}

	/**
	 * com.liferay.portal.kernel.json.JSONArray 作成
	 * 
	 * @param l List
	 * @return com.liferay.portal.kernel.json.JSONArray
	 */
	@SuppressWarnings("rawtypes")
	private com.liferay.portal.kernel.json.JSONArray serialize(final List l) {
		return this.serialize(l.toArray());
	}

	/**
	 * com.liferay.portal.kernel.json.JSONArray 作成
	 * 
	 * @param a Object[]
	 * @return com.liferay.portal.kernel.json.JSONArray
	 */
	@SuppressWarnings("rawtypes")
	private com.liferay.portal.kernel.json.JSONArray serialize(final Object[] a) {
		final com.liferay.portal.kernel.json.JSONArray ret = com.liferay.portal.kernel.json.JSONFactoryUtil.createJSONArray();

		for (final Object v : a) {
			if (v == null || "null".equals(v)) {
				ret.put("");
			} else if (v instanceof List) {
				ret.put(this.serialize((List) v));
			} else if (v.getClass().isArray()) {
				ret.put(this.serialize((Object[]) v));
			} else if (v instanceof Map) {
				ret.put(this.serialize((Map) v));
			} else {
				ret.put(String.valueOf(v));
			}
		}
		return ret;
	}
}