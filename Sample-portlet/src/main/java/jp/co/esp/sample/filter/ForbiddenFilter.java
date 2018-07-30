package jp.co.esp.sample.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;

import jp.co.esp.sample.util.LogUtil;
import jp.co.esp.sample.util.ServletUtil;
import jp.co.esp.sample.util.StringUtil;

/**
 * Filter implementation class ForbiddenFilter
 */
public class ForbiddenFilter implements Filter {

	private static Logger logger = LogUtil.getLogger();

	/** 対象外コマンドパターン */
	private String[] excludeCmdPatternArr = null;

	/**
	 * @see Filter#init(FilterConfig filterConfig)
	 */
	@Override
	public void init(final FilterConfig filterConfig) throws ServletException {
		final String excludeCmdPattern = filterConfig.getInitParameter("exclude-cmd-pattern");
		if (StringUtils.isNotEmpty(excludeCmdPattern)) {
			this.excludeCmdPatternArr = excludeCmdPattern.split(",");
		}
		logger.debug("[exclude-cmd-pattern:" + excludeCmdPattern + "]");
	}

	/**
	 * @see Filter#doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	 */
	@Override
	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
			throws IOException, ServletException {
		final HttpServletRequest httpRequest = (HttpServletRequest) request;
		final HttpServletResponse httpResponse = (HttpServletResponse) response;
		final String requestURL = ServletUtil.getRequestURL(httpRequest);
		final String cmd = request.getParameter("cmd");

		// 対象外コマンドかチェック
		if (StringUtils.isNotEmpty(cmd)) {
			if (this.excludeCmdPatternArr != null) {
				for (final String excludeCmdPattern : this.excludeCmdPatternArr) {
					if (StringUtil.isMatchesWildcard(excludeCmdPattern, cmd)) {
						logger.debug("Exclude: [RequestURL:" + requestURL + "][cmd:" + cmd + "]");
						chain.doFilter(request, response);
						return;
					}
				}
			}
		}

		// Administratorチェック
		boolean isAdministrator;
		try {
			isAdministrator = isAdministrator(httpRequest);
		} catch (final SystemException e) {
			logger.error("Error: [RequestURL:" + requestURL + "][cmd:" + cmd + "]");
			httpResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return;
		}
		if (isAdministrator) {
			logger.info("Administrator: [RequestURL:" + requestURL + "][cmd:" + cmd + "]");
			chain.doFilter(request, response);
			return;
		}

		// Forbidden(403)を返却
		logger.info("Forbidden: [RequestURL:" + requestURL + "][cmd:" + cmd + "]");
		httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
	}

	/**
	 * @see Filter#destroy()
	 */
	@Override
	public void destroy() {
	}

	/**
	 * Administratorチェック
	 *
	 * @param httpRequest リクエスト情報
	 * @return Administrator：true
	 * @throws SystemException システムエラー発生時
	 */
	public static boolean isAdministrator(final HttpServletRequest httpRequest)
			throws SystemException {
		User user = null;
		try {
			user = PortalUtil.getUser(httpRequest);
		} catch (final PortalException e) {
			return false;
		}
		if (user != null) {
			for (final Role r : user.getRoles()) {
				if ("Administrator".equalsIgnoreCase(r.getName())) {
					return true;
				}
			}
		}
		return false;
	}
}
