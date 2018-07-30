package jp.co.esp.sample.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link HomeLocalService}.
 *
 * @author SampleDeveloper
 * @see HomeLocalService
 * @generated
 */
public class HomeLocalServiceWrapper implements HomeLocalService,
    ServiceWrapper<HomeLocalService> {
    private HomeLocalService _homeLocalService;

    public HomeLocalServiceWrapper(HomeLocalService homeLocalService) {
        _homeLocalService = homeLocalService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _homeLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _homeLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _homeLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
    * お知らせ情報を返す
    *
    * @param loginUser ログインユーザー
    * @param info APIリクエストパラメータ
    * @return JSONObject
    * @throws SystemException
    */
    @Override
    public java.lang.Object getHomeInfo(
        com.liferay.portal.model.User loginUser,
        java.util.HashMap<java.lang.String, java.lang.String> info)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _homeLocalService.getHomeInfo(loginUser, info);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public HomeLocalService getWrappedHomeLocalService() {
        return _homeLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedHomeLocalService(HomeLocalService homeLocalService) {
        _homeLocalService = homeLocalService;
    }

    @Override
    public HomeLocalService getWrappedService() {
        return _homeLocalService;
    }

    @Override
    public void setWrappedService(HomeLocalService homeLocalService) {
        _homeLocalService = homeLocalService;
    }
}
