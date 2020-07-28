package jp.co.esp.sample.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 文字列ユーティリティ
 */
public final class StringUtil {

	/**
	 * コンストラクタ
	 */
	private StringUtil() {
	}

	/**
	 * nullまたは空であるかチェック
	 *
	 * @param value 対象文字列
	 * @return nullまたは空の場合true
	 */
	public static boolean isEmpty(final String value) {
		if (null == value || value.length() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * nullであれば空文字列に変換
	 *
	 * @param value 対象文字列
	 * @return 変換後の文字列
	 */
	public static String blankIfNull(final String value) {
		if (value == null) {
			return "";
		}
		return value;
	}

	/**
	 * intに変換（nullであれば0に変換）
	 *
	 * @param value 対象文字列
	 * @return int変換後値
	 */
	public static int toInt(final String value) {
		if (isEmpty(value)) {
			return 0;
		}
		return Integer.parseInt(value);
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
		if (isEmpty(value)) {
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
	 * キャメルケースをハイフン区切りに変換
	 *
	 * @param camel キャメルケース文字列
	 * @return ハイフン区切り文字列
	 */
	public static String hiphenate(final String camel) {
		if (isEmpty(camel)) {
			return camel;
		}
		final StringBuilder sb = new StringBuilder();
		final char[] characters = camel.toCharArray();

		for (int i = 0; i < characters.length; i++) {
			if (Character.isUpperCase(characters[i])) {
				if (sb.length() > 0) {
					sb.append('-');
				}
				sb.append(Character.toLowerCase(characters[i]));
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
	 * @return キャメルケース文字列
	 */
	public static String camelize(final String snake) {
		if (isEmpty(snake)) {
			return snake;
		}
		final StringBuilder sb = new StringBuilder();
		final char[] characters = snake.toCharArray();

		boolean capitalize = false;
		for (int i = 0; i < characters.length; i++) {
			if (characters[i] == '-') {
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
		if (isEmpty(value)) {
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
		if (isEmpty(value)) {
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
	 * @param value 元の文字列
	 * @param beforRegex 置換前
	 * @param afterRegex 置換後
	 * @return 正規表現によって変換された文字列
	 */
	public static String regexConverter(final String value, final String beforRegex, final String afterRegex) {
		if (isEmpty(value)) {
			return value;
		}
		final Pattern p = Pattern.compile(beforRegex);
		final Matcher m = p.matcher(value);
		final String result = m.replaceAll(afterRegex);
		return result;
	}

	/**
	 * 左パディング
	 * 
	 * @param value 対象文字列
	 * @param padding パディング文字
	 * @param maxLength 最大桁数
	 * @return パディングされた文字列
	 */
	public static String leftPadding(final String value, final char padding, final int maxLength) {
		final int paddingLength = maxLength - value.length();
		if (paddingLength <= 0) {
			return value; // 桁数オーバーはそのまま
		}
		final StringBuffer sb = new StringBuffer();
		for (int i = 0; i < paddingLength; i++) {
			sb.append(padding);
		}
		sb.append(value);
		return sb.toString();
	}
}
