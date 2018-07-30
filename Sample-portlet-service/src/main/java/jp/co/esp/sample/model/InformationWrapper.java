package jp.co.esp.sample.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Information}.
 * </p>
 *
 * @author SampleDeveloper
 * @see Information
 * @generated
 */
public class InformationWrapper implements Information,
    ModelWrapper<Information> {
    private Information _information;

    public InformationWrapper(Information information) {
        _information = information;
    }

    @Override
    public Class<?> getModelClass() {
        return Information.class;
    }

    @Override
    public String getModelClassName() {
        return Information.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("informationnumber", getInformationnumber());
        attributes.put("title", getTitle());
        attributes.put("content", getContent());
        attributes.put("fromdate", getFromdate());
        attributes.put("informationlevel", getInformationlevel());
        attributes.put("createdat", getCreatedat());
        attributes.put("createdby", getCreatedby());
        attributes.put("modifiedat", getModifiedat());
        attributes.put("modifiedby", getModifiedby());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long informationnumber = (Long) attributes.get("informationnumber");

        if (informationnumber != null) {
            setInformationnumber(informationnumber);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String content = (String) attributes.get("content");

        if (content != null) {
            setContent(content);
        }

        Date fromdate = (Date) attributes.get("fromdate");

        if (fromdate != null) {
            setFromdate(fromdate);
        }

        String informationlevel = (String) attributes.get("informationlevel");

        if (informationlevel != null) {
            setInformationlevel(informationlevel);
        }

        Date createdat = (Date) attributes.get("createdat");

        if (createdat != null) {
            setCreatedat(createdat);
        }

        String createdby = (String) attributes.get("createdby");

        if (createdby != null) {
            setCreatedby(createdby);
        }

        Date modifiedat = (Date) attributes.get("modifiedat");

        if (modifiedat != null) {
            setModifiedat(modifiedat);
        }

        String modifiedby = (String) attributes.get("modifiedby");

        if (modifiedby != null) {
            setModifiedby(modifiedby);
        }
    }

    /**
    * Returns the primary key of this information.
    *
    * @return the primary key of this information
    */
    @Override
    public long getPrimaryKey() {
        return _information.getPrimaryKey();
    }

    /**
    * Sets the primary key of this information.
    *
    * @param primaryKey the primary key of this information
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _information.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the informationnumber of this information.
    *
    * @return the informationnumber of this information
    */
    @Override
    public long getInformationnumber() {
        return _information.getInformationnumber();
    }

    /**
    * Sets the informationnumber of this information.
    *
    * @param informationnumber the informationnumber of this information
    */
    @Override
    public void setInformationnumber(long informationnumber) {
        _information.setInformationnumber(informationnumber);
    }

    /**
    * Returns the title of this information.
    *
    * @return the title of this information
    */
    @Override
    public java.lang.String getTitle() {
        return _information.getTitle();
    }

    /**
    * Sets the title of this information.
    *
    * @param title the title of this information
    */
    @Override
    public void setTitle(java.lang.String title) {
        _information.setTitle(title);
    }

    /**
    * Returns the content of this information.
    *
    * @return the content of this information
    */
    @Override
    public java.lang.String getContent() {
        return _information.getContent();
    }

    /**
    * Sets the content of this information.
    *
    * @param content the content of this information
    */
    @Override
    public void setContent(java.lang.String content) {
        _information.setContent(content);
    }

    /**
    * Returns the fromdate of this information.
    *
    * @return the fromdate of this information
    */
    @Override
    public java.util.Date getFromdate() {
        return _information.getFromdate();
    }

    /**
    * Sets the fromdate of this information.
    *
    * @param fromdate the fromdate of this information
    */
    @Override
    public void setFromdate(java.util.Date fromdate) {
        _information.setFromdate(fromdate);
    }

    /**
    * Returns the informationlevel of this information.
    *
    * @return the informationlevel of this information
    */
    @Override
    public java.lang.String getInformationlevel() {
        return _information.getInformationlevel();
    }

    /**
    * Sets the informationlevel of this information.
    *
    * @param informationlevel the informationlevel of this information
    */
    @Override
    public void setInformationlevel(java.lang.String informationlevel) {
        _information.setInformationlevel(informationlevel);
    }

    /**
    * Returns the createdat of this information.
    *
    * @return the createdat of this information
    */
    @Override
    public java.util.Date getCreatedat() {
        return _information.getCreatedat();
    }

    /**
    * Sets the createdat of this information.
    *
    * @param createdat the createdat of this information
    */
    @Override
    public void setCreatedat(java.util.Date createdat) {
        _information.setCreatedat(createdat);
    }

    /**
    * Returns the createdby of this information.
    *
    * @return the createdby of this information
    */
    @Override
    public java.lang.String getCreatedby() {
        return _information.getCreatedby();
    }

    /**
    * Sets the createdby of this information.
    *
    * @param createdby the createdby of this information
    */
    @Override
    public void setCreatedby(java.lang.String createdby) {
        _information.setCreatedby(createdby);
    }

    /**
    * Returns the modifiedat of this information.
    *
    * @return the modifiedat of this information
    */
    @Override
    public java.util.Date getModifiedat() {
        return _information.getModifiedat();
    }

    /**
    * Sets the modifiedat of this information.
    *
    * @param modifiedat the modifiedat of this information
    */
    @Override
    public void setModifiedat(java.util.Date modifiedat) {
        _information.setModifiedat(modifiedat);
    }

    /**
    * Returns the modifiedby of this information.
    *
    * @return the modifiedby of this information
    */
    @Override
    public java.lang.String getModifiedby() {
        return _information.getModifiedby();
    }

    /**
    * Sets the modifiedby of this information.
    *
    * @param modifiedby the modifiedby of this information
    */
    @Override
    public void setModifiedby(java.lang.String modifiedby) {
        _information.setModifiedby(modifiedby);
    }

    @Override
    public boolean isNew() {
        return _information.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _information.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _information.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _information.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _information.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _information.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _information.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _information.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _information.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _information.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _information.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new InformationWrapper((Information) _information.clone());
    }

    @Override
    public int compareTo(jp.co.esp.sample.model.Information information) {
        return _information.compareTo(information);
    }

    @Override
    public int hashCode() {
        return _information.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<jp.co.esp.sample.model.Information> toCacheModel() {
        return _information.toCacheModel();
    }

    @Override
    public jp.co.esp.sample.model.Information toEscapedModel() {
        return new InformationWrapper(_information.toEscapedModel());
    }

    @Override
    public jp.co.esp.sample.model.Information toUnescapedModel() {
        return new InformationWrapper(_information.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _information.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _information.toXmlString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof InformationWrapper)) {
            return false;
        }

        InformationWrapper informationWrapper = (InformationWrapper) obj;

        if (Validator.equals(_information, informationWrapper._information)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Information getWrappedInformation() {
        return _information;
    }

    @Override
    public Information getWrappedModel() {
        return _information;
    }

    @Override
    public void resetOriginalValues() {
        _information.resetOriginalValues();
    }
}
