package jp.co.esp.sample.util;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

import org.slf4j.Logger;

/**
 * プロパティファイルユーティリティ
 */
public final class PropsUtil {

	private static final String FILE_NAME = "application.properties";
	private static Logger logger = LogUtil.getLogger();
	private static Properties prop = new Properties();
	private static long lastModified = 0L;

	/**
	 * コンストラクタ
	 */
	private PropsUtil() {
	}

	/**
	 * プロパティ値の取得
	 * 
	 * @param key キー
	 * @return プロパティ値
	 */
	public static synchronized String getProperty(final String key) {
		load();
		final String value = prop.getProperty(key);
		logger.debug("PROPS_UTIL_KEY : " + key + " : " + value);
		return value;
	}

	/**
	 * プロパティファイル読み込み
	 */
	private static void load() {
		try {
			final URL resource = PropsUtil.class.getClassLoader().getResource(FILE_NAME);
			if (resource == null) {
				logger.warn("PROPS_UTIL_NOTFOUND : " + System.getProperty("java.class.path"));
				return;
			}
			final File propFile = new File(resource.getPath());
			if (lastModified != propFile.lastModified()) {
				prop.load(new FileInputStream(propFile));
				lastModified = propFile.lastModified();
				logger.info("PROPS_UTIL_LOAD : " + propFile.getAbsolutePath());
			}
		} catch (final Exception ex) {
			logger.warn("PROPS_UTIL_ERROR >> ", ex);
		}
	}

}