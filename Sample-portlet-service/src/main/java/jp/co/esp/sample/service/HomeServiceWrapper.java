package jp.co.esp.sample.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link HomeService}.
 *
 * @author SampleDeveloper
 * @see HomeService
 * @generated
 */
public class HomeServiceWrapper implements HomeService,
    ServiceWrapper<HomeService> {
    private HomeService _homeService;

    public HomeServiceWrapper(HomeService homeService) {
        _homeService = homeService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _homeService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _homeService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _homeService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
    * お知らせ情報を返す
    *
    * @param info APIリクエストパラメータ
    * @return お知らせ情報
    */
    @Override
    public com.liferay.portal.kernel.json.JSONObject getHomeInfo(
        java.util.HashMap info) {
        return _homeService.getHomeInfo(info);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public HomeService getWrappedHomeService() {
        return _homeService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedHomeService(HomeService homeService) {
        _homeService = homeService;
    }

    @Override
    public HomeService getWrappedService() {
        return _homeService;
    }

    @Override
    public void setWrappedService(HomeService homeService) {
        _homeService = homeService;
    }
}
