package jp.co.esp.sample.util;

import java.util.HashMap;
import java.util.Map;

/**
 * サニタイザ
 */
public class Sanitizer {

    /** HTMLエスケープマップ */
    private static final Map<Character, String> HTML_ESCAPE_MAP = new HashMap<Character, String>();

    static {
        HTML_ESCAPE_MAP.put('<', "&lt;");
        HTML_ESCAPE_MAP.put('>', "&gt;");
        HTML_ESCAPE_MAP.put('&', "&amp;");
        HTML_ESCAPE_MAP.put('"', "&quot;");
    }

    /**
     * コンストラクタ
     */
    private Sanitizer() {}

    /**
     * HTMLエスケープ
     *
     * @param value 文字列
     * @return サニタイズしたHTML
     */
    public static String escapeHtml(String value) {
        final StringBuffer sb = new StringBuffer();

        for (int index = 0; index < value.length(); index++) {
            final char c = value.charAt(index);
            final String escapedText = HTML_ESCAPE_MAP.get(c);
            if (escapedText == null) {
                sb.append(c);
            } else {
                sb.append(escapedText);
            }
        }

        return sb.toString();
    }

    /**
     * 改行コード削除
     *
     * @param value 文字列
     * @return 改行コードを削除した文字列
     */
    public static String removeCrlf(String value) {
        final StringBuffer sb = new StringBuffer();

        for (int index = 0; index < value.length(); index++) {
            final char c = value.charAt(index);
            if ((c != '\r') && (c != '\n')) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
