package jp.co.esp.sample.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.orangesignal.csv.Csv;
import com.orangesignal.csv.CsvConfig;
import com.orangesignal.csv.handlers.StringArrayListHandler;

import jp.co.esp.sample.util.LogUtil;

/**
 * Servlet implementation class CSVDownloadServlet
 */
public class CSVDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LogUtil.getLogger();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
		try {
			// ログインユーザ取得
			final User loginUser = PortalUtil.getUser(req);

			// ファイル名生成
			final Date date = new Date();
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			final String fileName = loginUser.getScreenName() + sdf.format(date) + ".csv";

			// コンテンツタイプ指定：ダウンロード/csv
			res.setContentType("application/csv");
			res.addHeader("Content-Disposition", fileName);
			res.setHeader("Cache-Control", "private");
			res.setHeader("Pragma", "no-cache");

			// CSV形式設定
			final CsvConfig cfg = new CsvConfig();
			cfg.setLineSeparator("\n");
			// ヘッダCSV出力
			Csv.save(this.createHeaderCsvList(loginUser), res.getOutputStream(), "Shift_JIS", cfg, new StringArrayListHandler());
			// データCSV出力
			Csv.save(this.createDataCsvList(req), res.getOutputStream(), "Shift_JIS", cfg, new StringArrayListHandler());
			logger.info(LogUtil.createAuditLogMsg("CSVダウンロード"));
		} catch (final PortalException | SystemException e) {
			logger.error(LogUtil.createAuditLogMsg(e.getMessage()), e);
			throw new ServletException(e.getMessage());
		}
	}

	/**
	 * ヘッダCSV作成
	 *
	 * @param loginUser ログインユーザ
	 * @return ヘッダCSVリスト
	 */
	private List<String[]> createHeaderCsvList(final User loginUser) {
		final List<String[]> headerCsvList = new ArrayList<String[]>();
		headerCsvList.add(new String[] { LanguageUtil.get(loginUser.getLocale(), "label.csv.key"),
				LanguageUtil.get(loginUser.getLocale(), "label.csv.value") });
		return headerCsvList;
	}

	/**
	 * データCSV作成
	 *
	 * @param httpRequest リクエスト情報
	 * @return データCSVリスト
	 */
	private List<String[]> createDataCsvList(final HttpServletRequest httpRequest) {
		final List<String[]> dataCsvList = new ArrayList<String[]>();
		dataCsvList.add(new String[] { "attribute1", httpRequest.getParameter("attribute1") });
		dataCsvList.add(new String[] { "attribute2", httpRequest.getParameter("attribute2") });
		dataCsvList.add(new String[] { "attribute3", httpRequest.getParameter("attribute3") });
		return dataCsvList;
	}
}
