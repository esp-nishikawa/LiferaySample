package jp.co.esp.sample.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
 * 共通Stringユーティリティ
 */
public final class StringUtil {

	/**
	 * コンストラクタ
	 */
	private StringUtil() {
	}

	/**
	 * intに変換
	 * <p>
	 * NULLの場合、0に変換
	 * </p>
	 *
	 * @param value 対象文字列
	 *
	 * @return int変換後値
	 */
	public static int toInt(final String value) {

		if (null == value) {
			return 0;
		}

		final String trim = value.trim();
		if (StringUtils.isEmpty(trim)) {
			return 0;
		}

		return Integer.parseInt(trim);
	}

	/**
	 * 日付フォーマットを別のフォーマットに変換
	 *
	 * @param value 対象文字列
	 * @param beforeFormat 変換前フォーマット
	 * @param afterFormat 変換後フォーマット
	 * @return 変換後日付文字列
	 */
	public static String convertDateFormat(final String value, final String beforeFormat, final String afterFormat) {
		if (StringUtils.isEmpty(value)) {
			return value;
		}
		try {
			final SimpleDateFormat sdf = new SimpleDateFormat(beforeFormat);
			final Date date = sdf.parse(value);
			sdf.applyPattern(afterFormat);
			return sdf.format(date);
		} catch (final ParseException e) {
			return value;
		}
	}

	/**
	 * サニタイジング対策
	 *
	 * @param value 対象文字列
	 *
	 * @return true:形式とマッチ false:空白または、形式にマッチしない
	 */
	public static String toEscapeStr(String value) {

		if (StringUtils.isEmpty(value)) {
			return value;
		}

		value = value.replaceAll("&", "&amp;")
				.replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;")
				.replaceAll("\"", "&quot;")
				.replaceAll("'", "&#39;");

		return value;
	}

	/**
	 * キャメルケースをハイフン区切りに変換
	 *
	 * @param camel キャメルケース文字列
	 *
	 * @return ハイフン区切り文字列
	 */
	public static String hiphenate(final String camel) {
		return reverse(camel, '-');
	}

	/**
	 * キャメルケースを指定区切りに変換
	 *
	 * @param camel キャメルケース文字列
	 * @param val 区切り文字
	 *
	 * @return 指定区切り文字列
	 */
	public static String reverse(final String camel, final char val) {
		if (Character.isUpperCase(camel.charAt(0))) {
			return camel.toLowerCase();
		}

		final StringBuilder sb = new StringBuilder();
		final char[] characters = camel.toCharArray();

		for (int i = 0, iLim = characters.length; i < iLim; i++) {
			if (Character.isUpperCase(characters[i])) {
				sb.append(val).append(Character.toLowerCase(characters[i]));
			} else {
				sb.append(characters[i]);
			}
		}

		return sb.toString();
	}

	/**
	 * ハイフン区切りをキャメルケースに変換
	 *
	 * @param snake ハイフン区切り文字列
	 *
	 * @return キャメルケース文字列
	 */
	public static String camelize(final String snake) {
		return convert(snake, '-');
	}

	/**
	 * 指定区切りをキャメルケースに変換
	 *
	 * @param snake 指定区切り文字列
	 * @param val 区切り文字
	 *
	 * @return キャメルケース文字列
	 */
	public static String convert(final String snake, final char val) {
		final StringBuilder sb = new StringBuilder();
		final char[] characters = snake.toCharArray();

		boolean capitalize = false;
		for (int i = 0, iLim = characters.length; i < iLim; i++) {
			if (characters[i] == val) {
				capitalize = true;
			} else {
				sb.append(capitalize ? Character.toUpperCase(characters[i]) : characters[i]);
				capitalize = false;
			}
		}

		return sb.toString();
	}

	/**
	 * 指定した区切り文字列の前を取り出す
	 *
	 * @param value 対象文字列
	 * @param delim 区切り文字列
	 * @return 取り出した文字列
	 */
	public static String left(final String value, final String delim) {
		if (StringUtils.isEmpty(value)) {
			return value;
		}
		final int index = value.indexOf(delim);
		if (index < 0) {
			return value;
		}
		return value.substring(0, index);
	}

	/**
	 * 指定した区切り文字列の後を取り出す
	 *
	 * @param value 対象文字列
	 * @param delim 区切り文字列
	 * @return 取り出した文字列
	 */
	public static String right(final String value, final String delim) {
		if (StringUtils.isEmpty(value)) {
			return value;
		}
		final int index = value.indexOf(delim);
		if (index < 0) {
			return value;
		}
		return value.substring(index + delim.length());
	}

	/**
	 * ワイルドカードパターンにマッチするかチェック
	 *
	 * @param pattern パターン文字列
	 * @param value 対象文字列
	 * @return true:一致
	 */
	public static boolean isMatchesWildcard(final String pattern, final String value) {
		final String regex = "\\Q" + pattern.replace("*", "\\E.*\\Q") + "\\E";
		return value.matches(regex);
	}

	/**
	 *
	 * 正規表現パターンにしたがって文字列を置換する
	 *
	 * @param str 元の文字列
	 * @param beforRegex 置換前
	 * @param afterRegex 置換後
	 * @return 正規表現によって変換された文字列
	 */
	public static String regexConverter(final String str, final String beforRegex, final String afterRegex) {
		final Pattern p = Pattern.compile(beforRegex);
		final Matcher m = p.matcher(str);
		final String result = m.replaceAll(afterRegex);
		return result;
	}

	/**
	 * ゼロパディング
	 * maxlength以上の桁数の場合は、右からmaxlength桁オーバーを切り捨て
	 *
	 * @param num ゼロ埋め対象数値
	 * @param maxlength ゼロ埋め後の最大桁数
	 * @return ゼロ埋めされた文字列
	 */
	public static String zeroPadding(final long num, final int maxlength) {
		final String ret = String.valueOf(num);
		if (ret.length() == maxlength) {
			return ret; // 0埋め不要
		} else if (ret.length() > maxlength) {
			return ret.substring(ret.length() - maxlength); // 桁数オーバーは右からmaxlength桁数切り出す
		}
		return StringUtils.leftPad(ret, maxlength, "0");
	}
}