package jp.co.esp.sample.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * ステータスコード確認用のレスポンス情報
 */
public class StatusExposingServletResponse extends HttpServletResponseWrapper {

	private int httpStatus;

	/**
	 * コンストラクタ
	 * 
	 * @param response レスポンス情報
	 */
	public StatusExposingServletResponse(final HttpServletResponse response) {
		super(response);
	}

	/**
	 * @see HttpServletResponseWrapper#sendError(int sc)
	 */
	@Override
	public void sendError(final int sc) throws IOException {
		this.httpStatus = sc;
		super.sendError(sc);
	}

	/**
	 * @see HttpServletResponseWrapper#sendError(int sc, String msg)
	 */
	@Override
	public void sendError(final int sc, final String msg) throws IOException {
		this.httpStatus = sc;
		super.sendError(sc, msg);
	}

	/**
	 * @see HttpServletResponseWrapper#setStatus(int sc)
	 */
	@Override
	public void setStatus(final int sc) {
		this.httpStatus = sc;
		super.setStatus(sc);
	}

	/**
	 * @see HttpServletResponseWrapper#setStatus(int sc, String sm)
	 */
	@Override
	public void setStatus(final int sc, final String sm) {
		this.httpStatus = sc;
		super.setStatus(sc, sm);
	}

	/**
	 * ステータスコード取得
	 * 
	 * @return int ステータスコード
	 */
	public int getStatus() {
		return this.httpStatus;
	}

}