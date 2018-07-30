package jp.co.esp.sample.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service interface for Home. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author SampleDeveloper
 * @see HomeLocalServiceUtil
 * @see jp.co.esp.sample.service.base.HomeLocalServiceBaseImpl
 * @see jp.co.esp.sample.service.impl.HomeLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface HomeLocalService extends BaseLocalService, InvokableLocalService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link HomeLocalServiceUtil} to access the home local service. Add custom service methods to {@link jp.co.esp.sample.service.impl.HomeLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier();

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier);

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable;

    /**
    * お知らせ情報を返す
    *
    * @param loginUser ログインユーザー
    * @param info APIリクエストパラメータ
    * @return JSONObject
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.lang.Object getHomeInfo(
        com.liferay.portal.model.User loginUser,
        java.util.HashMap<java.lang.String, java.lang.String> info)
        throws com.liferay.portal.kernel.exception.SystemException;
}
