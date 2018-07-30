package jp.co.esp.sample.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;

/**
 * HttpRequestユーティリティ
 */
public final class HttpRequestUtil {

	private static Logger logger = LogUtil.getLogger();

	/**
	 * コンストラクタ
	 */
	private HttpRequestUtil() {
	}

	/**
	 * POSTリクエスト
	 *
	 * @param uri URL
	 * @param postData POSTするデータ
	 * @return JSONObject
	 * @throws IOException 入出力例外
	 */
	public static JSONObject doPost(final String uri, final JSONObject postData) throws IOException {
		return connect(uri, postData, "POST", "100000", "100000");
	}

	/**
	 * URL確立
	 *
	 * @param uri URL
	 * @param data データ
	 * @param methodType メソッド
	 * @param connectTimeout コネクションタイムアウト値(ミリ秒)
	 * @param readTimeout 読み取りタイムアウト値(ミリ秒)
	 * @return JSONObject
	 * @throws IOException 入出力例外
	 */
	private static JSONObject connect(final String uri, final JSONObject data, final String methodType,
			final String connectTimeout, final String readTimeout) throws IOException {

		final URL url = new URL(uri);
		final HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		BufferedReader r = null;
		OutputStreamWriter w = null;
		try {
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestMethod(methodType);
			conn.setRequestProperty("Content-Type", "application/json");

			if (StringUtils.isNotEmpty(connectTimeout)) {
				conn.setConnectTimeout(Integer.parseInt(connectTimeout));
			}
			if (StringUtils.isNotEmpty(readTimeout)) {
				conn.setReadTimeout(Integer.parseInt(readTimeout));
			}

			final long startTime = System.nanoTime();
			w = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
			w.write(data.toString());
			w.flush();
			// conn.connect(); // getOutputStreamでconnectされるので不要
			r = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String l = "";
			final StringBuilder sb = new StringBuilder();
			while ((l = r.readLine()) != null) {
				sb.append(l);
			}
			final long endTime = System.nanoTime();
			logger.info("[ExecuteTime:" + ((endTime - startTime) / 1000000f + "ms]"));

			return (JSONObject) JSONValue.parse(sb.toString());
		} catch (final IOException ie) {
			logger.error("[ResponseCode:" + conn.getResponseCode() + "]");
			r = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
			String l = "";
			final StringBuilder sb = new StringBuilder();
			while ((l = r.readLine()) != null) {
				sb.append(l);
			}
			logger.error("[ErrorStream:" + sb.toString() + "]");

			throw ie;
		} finally {
			if (r != null) {
				r.close();
			}
			if (w != null) {
				w.close();
			}
			if (conn != null) {
				conn.disconnect();
			}
		}
	}

	/**
	 * HTTPS通信の検証無効化<br>
	 * テスト用
	 *
	 * @param conn HTTPS接続
	 * @throws NoSuchAlgorithmException 暗号アルゴリズム使用不可
	 * @throws KeyManagementException 鍵管理例外
	 */
	@SuppressWarnings("unused")
	private static void ignoreHttpsValidate(final HttpsURLConnection conn) throws NoSuchAlgorithmException, KeyManagementException {
		final TrustManager[] trustManagers = { new X509TrustManager() {
			@Override
			public void checkClientTrusted(final X509Certificate[] arg0, final String arg1) throws CertificateException {
			}

			@Override
			public void checkServerTrusted(final X509Certificate[] arg0, final String arg1) throws CertificateException {
			}

			@Override
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		} };
		final SSLContext sslContext = SSLContext.getInstance("SSL");
		sslContext.init(null, trustManagers, new SecureRandom());
		conn.setSSLSocketFactory(sslContext.getSocketFactory());
		conn.setHostnameVerifier(new HostnameVerifier() {
			@Override
			public boolean verify(final String arg0, final SSLSession arg1) {
				return true;
			}
		});
	}
}