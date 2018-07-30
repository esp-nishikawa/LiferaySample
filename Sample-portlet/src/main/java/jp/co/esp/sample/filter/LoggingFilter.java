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

import jp.co.esp.sample.util.LogUtil;
import jp.co.esp.sample.util.ServletUtil;
import jp.co.esp.sample.util.StringUtil;

/**
 * Filter implementation class LoggingFilter
 */
public class LoggingFilter implements Filter {

	private static Logger logger = LogUtil.getLogger();

	/** 対象外URLパターン */
	private String[] excludeUrlPatternArr = null;

	/**
	 * @see Filter#init(FilterConfig filterConfig)
	 */
	@Override
	public void init(final FilterConfig filterConfig) throws ServletException {
		final String excludeUrlPattern = filterConfig.getInitParameter("exclude-url-pattern");
		if (StringUtils.isNotEmpty(excludeUrlPattern)) {
			this.excludeUrlPatternArr = excludeUrlPattern.split(",");
		}
		logger.debug("[exclude-url-pattern:" + excludeUrlPattern + "]");
	}

	/**
	 * @see Filter#doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	 */
	@Override
	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
			throws IOException, ServletException {
		final HttpServletRequest httpRequest = (HttpServletRequest) request;
		final String requestURL = ServletUtil.getRequestURL(httpRequest);

		// 対象外URLかチェック
		if (this.excludeUrlPatternArr != null) {
			for (final String excludeUrlPattern : this.excludeUrlPatternArr) {
				if (StringUtil.isMatchesWildcard(excludeUrlPattern, httpRequest.getRequestURI())) {
					logger.debug("[ExcludeURL:" + requestURL + "]");
					chain.doFilter(request, response);
					return;
				}
			}
		}

		try {
			LogUtil.startLogging(request);
			final StatusExposingServletResponse responseEx = new StatusExposingServletResponse((HttpServletResponse) response);
			chain.doFilter(request, responseEx);
			if (400 <= responseEx.getStatus()) {
				logger.warn("[STATUS:" + responseEx.getStatus() + "]\n"
						+ ServletUtil.dumpRequest((HttpServletRequest) request));
			}
		} finally {
			LogUtil.endLogging();
		}
	}

	/**
	 * @see Filter#destroy()
	 */
	@Override
	public void destroy() {
	}
}
