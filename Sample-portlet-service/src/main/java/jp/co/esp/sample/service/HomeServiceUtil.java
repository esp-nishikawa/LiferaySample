package jp.co.esp.sample.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for Home. This utility wraps
 * {@link jp.co.esp.sample.service.impl.HomeServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author SampleDeveloper
 * @see HomeService
 * @see jp.co.esp.sample.service.base.HomeServiceBaseImpl
 * @see jp.co.esp.sample.service.impl.HomeServiceImpl
 * @generated
 */
public class HomeServiceUtil {
    private static HomeService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link jp.co.esp.sample.service.impl.HomeServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
    * @param info APIリクエストパラメータ
    * @return お知らせ情報
    */
    public static com.liferay.portal.kernel.json.JSONObject getHomeInfo(
        java.util.HashMap info) {
        return getService().getHomeInfo(info);
    }

    public static void clearService() {
        _service = null;
    }

    public static HomeService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    HomeService.class.getName());

            if (invokableService instanceof HomeService) {
                _service = (HomeService) invokableService;
            } else {
                _service = new HomeServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(HomeServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(HomeService service) {
    }
}
