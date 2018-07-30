package jp.co.esp.sample.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Home. This utility wraps
 * {@link jp.co.esp.sample.service.impl.HomeLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author SampleDeveloper
 * @see HomeLocalService
 * @see jp.co.esp.sample.service.base.HomeLocalServiceBaseImpl
 * @see jp.co.esp.sample.service.impl.HomeLocalServiceImpl
 * @generated
 */
public class HomeLocalServiceUtil {
    private static HomeLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link jp.co.esp.sample.service.impl.HomeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    /**
    * お知らせ情報を返す
    *
    * @param loginUser ログインユーザー
    * @param info APIリクエストパラメータ
    * @return JSONObject
    * @throws SystemException
    */
    public static java.lang.Object getHomeInfo(
        com.liferay.portal.model.User loginUser,
        java.util.HashMap<java.lang.String, java.lang.String> info)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getHomeInfo(loginUser, info);
    }

    public static void clearService() {
        _service = null;
    }

    public static HomeLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    HomeLocalService.class.getName());

            if (invokableLocalService instanceof HomeLocalService) {
                _service = (HomeLocalService) invokableLocalService;
            } else {
                _service = new HomeLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(HomeLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(HomeLocalService service) {
    }
}
