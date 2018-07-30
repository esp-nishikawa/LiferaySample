package jp.co.esp.sample.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import jp.co.esp.sample.model.Information;

import java.util.List;

/**
 * The persistence utility for the information service. This utility wraps {@link InformationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author SampleDeveloper
 * @see InformationPersistence
 * @see InformationPersistenceImpl
 * @generated
 */
public class InformationUtil {
    private static InformationPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(Information information) {
        getPersistence().clearCache(information);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<Information> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Information> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Information> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Information update(Information information)
        throws SystemException {
        return getPersistence().update(information);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Information update(Information information,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(information, serviceContext);
    }

    /**
    * Returns all the informations where fromdate &le; &#63;.
    *
    * @param fromdate the fromdate
    * @return the matching informations
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<jp.co.esp.sample.model.Information> findByInformationList(
        java.util.Date fromdate)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByInformationList(fromdate);
    }

    /**
    * Returns a range of all the informations where fromdate &le; &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link jp.co.esp.sample.model.impl.InformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param fromdate the fromdate
    * @param start the lower bound of the range of informations
    * @param end the upper bound of the range of informations (not inclusive)
    * @return the range of matching informations
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<jp.co.esp.sample.model.Information> findByInformationList(
        java.util.Date fromdate, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByInformationList(fromdate, start, end);
    }

    /**
    * Returns an ordered range of all the informations where fromdate &le; &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link jp.co.esp.sample.model.impl.InformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param fromdate the fromdate
    * @param start the lower bound of the range of informations
    * @param end the upper bound of the range of informations (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching informations
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<jp.co.esp.sample.model.Information> findByInformationList(
        java.util.Date fromdate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByInformationList(fromdate, start, end,
            orderByComparator);
    }

    /**
    * Returns the first information in the ordered set where fromdate &le; &#63;.
    *
    * @param fromdate the fromdate
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching information
    * @throws jp.co.esp.sample.NoSuchInformationException if a matching information could not be found
    * @throws SystemException if a system exception occurred
    */
    public static jp.co.esp.sample.model.Information findByInformationList_First(
        java.util.Date fromdate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            jp.co.esp.sample.NoSuchInformationException {
        return getPersistence()
                   .findByInformationList_First(fromdate, orderByComparator);
    }

    /**
    * Returns the first information in the ordered set where fromdate &le; &#63;.
    *
    * @param fromdate the fromdate
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching information, or <code>null</code> if a matching information could not be found
    * @throws SystemException if a system exception occurred
    */
    public static jp.co.esp.sample.model.Information fetchByInformationList_First(
        java.util.Date fromdate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByInformationList_First(fromdate, orderByComparator);
    }

    /**
    * Returns the last information in the ordered set where fromdate &le; &#63;.
    *
    * @param fromdate the fromdate
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching information
    * @throws jp.co.esp.sample.NoSuchInformationException if a matching information could not be found
    * @throws SystemException if a system exception occurred
    */
    public static jp.co.esp.sample.model.Information findByInformationList_Last(
        java.util.Date fromdate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            jp.co.esp.sample.NoSuchInformationException {
        return getPersistence()
                   .findByInformationList_Last(fromdate, orderByComparator);
    }

    /**
    * Returns the last information in the ordered set where fromdate &le; &#63;.
    *
    * @param fromdate the fromdate
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching information, or <code>null</code> if a matching information could not be found
    * @throws SystemException if a system exception occurred
    */
    public static jp.co.esp.sample.model.Information fetchByInformationList_Last(
        java.util.Date fromdate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByInformationList_Last(fromdate, orderByComparator);
    }

    /**
    * Returns the informations before and after the current information in the ordered set where fromdate &le; &#63;.
    *
    * @param informationnumber the primary key of the current information
    * @param fromdate the fromdate
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next information
    * @throws jp.co.esp.sample.NoSuchInformationException if a information with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static jp.co.esp.sample.model.Information[] findByInformationList_PrevAndNext(
        long informationnumber, java.util.Date fromdate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            jp.co.esp.sample.NoSuchInformationException {
        return getPersistence()
                   .findByInformationList_PrevAndNext(informationnumber,
            fromdate, orderByComparator);
    }

    /**
    * Returns all the informations where fromdate &le; all &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link jp.co.esp.sample.model.impl.InformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param fromdates the fromdates
    * @return the matching informations
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<jp.co.esp.sample.model.Information> findByInformationList(
        java.util.Date[] fromdates)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByInformationList(fromdates);
    }

    /**
    * Returns a range of all the informations where fromdate &le; all &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link jp.co.esp.sample.model.impl.InformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param fromdates the fromdates
    * @param start the lower bound of the range of informations
    * @param end the upper bound of the range of informations (not inclusive)
    * @return the range of matching informations
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<jp.co.esp.sample.model.Information> findByInformationList(
        java.util.Date[] fromdates, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByInformationList(fromdates, start, end);
    }

    /**
    * Returns an ordered range of all the informations where fromdate &le; all &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link jp.co.esp.sample.model.impl.InformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param fromdates the fromdates
    * @param start the lower bound of the range of informations
    * @param end the upper bound of the range of informations (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching informations
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<jp.co.esp.sample.model.Information> findByInformationList(
        java.util.Date[] fromdates, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByInformationList(fromdates, start, end,
            orderByComparator);
    }

    /**
    * Removes all the informations where fromdate &le; &#63; from the database.
    *
    * @param fromdate the fromdate
    * @throws SystemException if a system exception occurred
    */
    public static void removeByInformationList(java.util.Date fromdate)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByInformationList(fromdate);
    }

    /**
    * Returns the number of informations where fromdate &le; &#63;.
    *
    * @param fromdate the fromdate
    * @return the number of matching informations
    * @throws SystemException if a system exception occurred
    */
    public static int countByInformationList(java.util.Date fromdate)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByInformationList(fromdate);
    }

    /**
    * Returns the number of informations where fromdate &le; all &#63;.
    *
    * @param fromdates the fromdates
    * @return the number of matching informations
    * @throws SystemException if a system exception occurred
    */
    public static int countByInformationList(java.util.Date[] fromdates)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByInformationList(fromdates);
    }

    /**
    * Caches the information in the entity cache if it is enabled.
    *
    * @param information the information
    */
    public static void cacheResult(
        jp.co.esp.sample.model.Information information) {
        getPersistence().cacheResult(information);
    }

    /**
    * Caches the informations in the entity cache if it is enabled.
    *
    * @param informations the informations
    */
    public static void cacheResult(
        java.util.List<jp.co.esp.sample.model.Information> informations) {
        getPersistence().cacheResult(informations);
    }

    /**
    * Creates a new information with the primary key. Does not add the information to the database.
    *
    * @param informationnumber the primary key for the new information
    * @return the new information
    */
    public static jp.co.esp.sample.model.Information create(
        long informationnumber) {
        return getPersistence().create(informationnumber);
    }

    /**
    * Removes the information with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param informationnumber the primary key of the information
    * @return the information that was removed
    * @throws jp.co.esp.sample.NoSuchInformationException if a information with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static jp.co.esp.sample.model.Information remove(
        long informationnumber)
        throws com.liferay.portal.kernel.exception.SystemException,
            jp.co.esp.sample.NoSuchInformationException {
        return getPersistence().remove(informationnumber);
    }

    public static jp.co.esp.sample.model.Information updateImpl(
        jp.co.esp.sample.model.Information information)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(information);
    }

    /**
    * Returns the information with the primary key or throws a {@link jp.co.esp.sample.NoSuchInformationException} if it could not be found.
    *
    * @param informationnumber the primary key of the information
    * @return the information
    * @throws jp.co.esp.sample.NoSuchInformationException if a information with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static jp.co.esp.sample.model.Information findByPrimaryKey(
        long informationnumber)
        throws com.liferay.portal.kernel.exception.SystemException,
            jp.co.esp.sample.NoSuchInformationException {
        return getPersistence().findByPrimaryKey(informationnumber);
    }

    /**
    * Returns the information with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param informationnumber the primary key of the information
    * @return the information, or <code>null</code> if a information with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static jp.co.esp.sample.model.Information fetchByPrimaryKey(
        long informationnumber)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(informationnumber);
    }

    /**
    * Returns all the informations.
    *
    * @return the informations
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<jp.co.esp.sample.model.Information> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the informations.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link jp.co.esp.sample.model.impl.InformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of informations
    * @param end the upper bound of the range of informations (not inclusive)
    * @return the range of informations
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<jp.co.esp.sample.model.Information> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the informations.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link jp.co.esp.sample.model.impl.InformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of informations
    * @param end the upper bound of the range of informations (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of informations
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<jp.co.esp.sample.model.Information> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the informations from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of informations.
    *
    * @return the number of informations
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static InformationPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (InformationPersistence) PortletBeanLocatorUtil.locate(jp.co.esp.sample.service.ClpSerializer.getServletContextName(),
                    InformationPersistence.class.getName());

            ReferenceRegistry.registerReference(InformationUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(InformationPersistence persistence) {
    }
}
