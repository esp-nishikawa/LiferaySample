package jp.co.esp.sample.util;

import java.util.Iterator;
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
	 * 変換の種類
	 */
	public enum Transform {
		CAMEL_TO_HIPHEN,
		HIPHEN_TO_CAMEL,
		CAMEL_TO_UNSCORE,
		UNSCORE_TO_CAMEL
	}

	/**
	 * コンストラクタ
	 */
	private JSONUtil() {
	}

	/**
	 * キャメルケースをハイフン区切りに変換
	 *
	 * @param camel キャメルケースJSONObject
	 *
	 * @return ハイフン区切りJSONObject
	 */
	public static JSONObject hiphenate(final JSONObject camel) {
		return transform(camel, Transform.CAMEL_TO_HIPHEN);
	}

	/**
	 * キャメルケースをハイフン区切りに変換
	 *
	 * @param camel キャメルケースJSONArray
	 *
	 * @return ハイフン区切りJSONArray
	 */
	public static JSONArray hiphenate(final JSONArray camel) {
		return transform(camel, Transform.CAMEL_TO_HIPHEN);
	}

	/**
	 * ハイフン区切りをキャメルケースに変換
	 *
	 * @param snake ハイフン区切りJSONObject
	 *
	 * @return キャメルケースJSONObject
	 */
	public static JSONObject camelize(final JSONObject snake) {
		return transform(snake, Transform.HIPHEN_TO_CAMEL);
	}

	/**
	 * ハイフン区切りをキャメルケースに変換
	 *
	 * @param snake ハイフン区切りJSONArray
	 *
	 * @return キャメルケースJSONArray
	 */
	public static JSONArray camelize(final JSONArray snake) {
		return transform(snake, Transform.HIPHEN_TO_CAMEL);
	}

	/**
	 * JSONObjectを指定した形式に変換
	 *
	 * @param jo 対象JSONObject
	 * @param transform 変換の形式
	 *
	 * @return 変換JSONObject
	 */
	public static JSONObject convert(final JSONObject jo, final Transform transform) {
		return transform(jo, transform);
	}

	/**
	 * JSONArrayを指定した形式に変換
	 *
	 * @param ja 対象JSONArray
	 * @param transform 変換の形式
	 *
	 * @return 変換JSONArray
	 */
	public static JSONArray convert(final JSONArray ja, final Transform transform) {
		return transform(ja, transform);
	}

	/**
	 * JSONObjectを指定した形式に変換
	 *
	 * @param jo 対象JSONObject
	 * @param transform 変換の形式
	 *
	 * @return 変換JSONObject
	 */
	private static JSONObject transform(final JSONObject jo, final Transform transform) {
		final JSONObject ret = new JSONObject();

		final Iterator<String> keys = jo.keySet().iterator();
		while (keys.hasNext()) {

			final String key = keys.next();
			Object v = jo.get(key);
			if (v instanceof JSONObject) {
				v = transform((JSONObject) v, transform);
			} else if (v instanceof JSONArray) {
				v = transform((JSONArray) v, transform);
			}

			switch (transform) {
				case CAMEL_TO_HIPHEN:
					ret.put(StringUtil.hiphenate(key), v);
					break;
				case HIPHEN_TO_CAMEL:
					ret.put(StringUtil.camelize(key), v);
					break;
				case CAMEL_TO_UNSCORE:
					ret.put(StringUtil.reverse(key, '_'), v);
					break;
				case UNSCORE_TO_CAMEL:
					ret.put(StringUtil.convert(key, '_'), v);
					break;
				default:
					ret.put(StringUtil.camelize(key), v);
			}
		}
		return ret;
	}

	/**
	 * JSONArrayを指定した形式に変換
	 *
	 * @param ja 対象JSONArray
	 * @param transform 変換の形式
	 *
	 * @return 変換JSONArray
	 */
	private static JSONArray transform(final JSONArray ja, final Transform transform) {
		final JSONArray ret = new JSONArray();

		for (int i = 0, iLim = ja.size(); i < iLim; i++) {
			final Object o = ja.get(i);

			if (o instanceof JSONObject) {
				ret.add(transform((JSONObject) o, transform));
			} else if (o instanceof JSONArray) {
				ret.add(transform((JSONArray) o, transform));

			} else {
				ret.add(o);
			}

		}

		return ret;
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