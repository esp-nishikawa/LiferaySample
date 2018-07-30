package jp.co.esp.sample.servlet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

/**
 * Servlet implementation class CSVDownloadServletTest
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ CSVDownloadServlet.class })
public class CSVDownloadServletTest {

	/**
	 * 
	 */
	@Test
	public void testDoPost() {
		try {
			// HttpRequest作成(モック)
			final MockHttpServletRequest mReq = new MockHttpServletRequest();
			final String attribute1 = "1111111111";
			final String attribute2 = "2222222222";
			final String attribute3 = "3333333333";
			// パラメータ追加
			mReq.addParameter("attribute1", attribute1);
			mReq.addParameter("attribute2", attribute2);
			mReq.addParameter("attribute3", attribute3);
			// HttpResponse作成(モック)
			final MockHttpServletResponse mRes = new MockHttpServletResponse();
			// privateメソッドのモック設定
			final CSVDownloadServlet wprs = PowerMockito.spy(new CSVDownloadServlet());
			PowerMockito.when(wprs, "createHeaderCsvList", Mockito.any()).thenReturn(new String[] { "キー", "値" });

			// 実行
			wprs.doPost(mReq, mRes);

			// レスポンス
			assertEquals(HttpServletResponse.SC_OK, mRes.getStatus());
			assertEquals("private", mRes.getHeader("Cache-Control"));
			assertEquals("no-cache", mRes.getHeader("Pragma"));
			// privateメソッドの呼び出し確認
			PowerMockito.verifyPrivate(wprs, Mockito.times(1)).invoke("createHeaderCsvList", Mockito.any());
			PowerMockito.verifyPrivate(wprs, Mockito.times(1)).invoke("createDataCsvList", Mockito.any());
		} catch (final Exception e) {
			e.printStackTrace();
			fail("Exception");
		}
	}
}
