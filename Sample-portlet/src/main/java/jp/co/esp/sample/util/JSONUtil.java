package jp.co.esp.sample.util;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.json.XML;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;

/**
 * JSONユーティリティ
 */
public final class JSONUtil {

	/**
	 * コンストラクタ
	 */
	private JSONUtil() {
	}

	/**
	 * Map形式をJSONObject形式に変換
	 *
	 * @param m 対象Map
	 *
	 * @return 変換JSONObject
	 */
	@SuppressWarnings("rawtypes")
	public static JSONObject serialize(final Map m) {
		final JSONObject ret = new JSONObject();

		for (final Object k : m.keySet()) {
			final Object v = m.get(k);

			if (v instanceof List) {
				ret.put(String.valueOf(k), serialize((List) v));
			} else if (v.getClass().isArray()) {
				ret.put(String.valueOf(k), serialize((Object[]) v));
			} else if (v instanceof Map) {
				ret.put(String.valueOf(k), serialize((Map) v));
			} else {
				ret.put(String.valueOf(k), String.valueOf(v));
			}
		}

		return ret;
	}

	/**
	 * List形式をJSONArray形式に変換
	 *
	 * @param l 対象List
	 *
	 * @return 変換JSONArray
	 */
	@SuppressWarnings("rawtypes")
	private static JSONArray serialize(final List l) {
		return serialize(l.toArray());
	}

	/**
	 * 配列形式をJSONArray形式に変換
	 *
	 * @param a 対象配列
	 *
	 * @return 変換JSONArray
	 */
	@SuppressWarnings("rawtypes")
	private static JSONArray serialize(final Object[] a) {
		final JSONArray ret = new JSONArray();

		for (final Object v : a) {
			if (v instanceof List) {
				ret.add(serialize((List) v));
			} else if (v.getClass().isArray()) {
				ret.add(serialize((Object[]) v));
			} else if (v instanceof Map) {
				ret.add(serialize((Map) v));
			} else {
				ret.add(String.valueOf(v));
			}
		}

		return ret;
	}

	/**
	 * XMLからJSONObjectに変換
	 *
	 * @param xmlString xml文字列
	 * @return JSONObject
	 */
	public static JSONObject convertXml2JSON(final String xmlString) {
		String xml = xmlString.replaceAll("<\\?[^<>]*\\?>", ""); // 宣言ディレクティブ削除
		xml = Pattern.compile("<([^ ]+) [^<>]+/>").matcher(xml).replaceAll("<$1/>"); // 一行タグの属性削除
		xml = Pattern.compile("<([^ ]+) [^<>]+[^/]>").matcher(xml).replaceAll("<$1>"); // 開始タグの属性削除
		xml = Pattern.compile("<[^/<>:]+:([^<>:]+)").matcher(xml).replaceAll("<$1"); // 開始タグ一行タグの名前空間prefixの削除
		xml = Pattern.compile("</[^<>:]+:([^<>:]+)").matcher(xml).replaceAll("</$1"); // 終了タグの名前空間prefixの削除

		final org.json.JSONObject orgJson = XML.toJSONObject(xml);
		return (JSONObject) JSONValue.parse(orgJson.toString());
	}
}