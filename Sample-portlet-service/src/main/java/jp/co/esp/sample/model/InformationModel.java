package jp.co.esp.sample.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Information service. Represents a row in the &quot;Sample_Information&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link jp.co.esp.sample.model.impl.InformationModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link jp.co.esp.sample.model.impl.InformationImpl}.
 * </p>
 *
 * @author SampleDeveloper
 * @see Information
 * @see jp.co.esp.sample.model.impl.InformationImpl
 * @see jp.co.esp.sample.model.impl.InformationModelImpl
 * @generated
 */
public interface InformationModel extends BaseModel<Information> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a information model instance should use the {@link Information} interface instead.
     */

    /**
     * Returns the primary key of this information.
     *
     * @return the primary key of this information
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this information.
     *
     * @param primaryKey the primary key of this information
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the informationnumber of this information.
     *
     * @return the informationnumber of this information
     */
    public long getInformationnumber();

    /**
     * Sets the informationnumber of this information.
     *
     * @param informationnumber the informationnumber of this information
     */
    public void setInformationnumber(long informationnumber);

    /**
     * Returns the title of this information.
     *
     * @return the title of this information
     */
    @AutoEscape
    public String getTitle();

    /**
     * Sets the title of this information.
     *
     * @param title the title of this information
     */
    public void setTitle(String title);

    /**
     * Returns the content of this information.
     *
     * @return the content of this information
     */
    @AutoEscape
    public String getContent();

    /**
     * Sets the content of this information.
     *
     * @param content the content of this information
     */
    public void setContent(String content);

    /**
     * Returns the fromdate of this information.
     *
     * @return the fromdate of this information
     */
    public Date getFromdate();

    /**
     * Sets the fromdate of this information.
     *
     * @param fromdate the fromdate of this information
     */
    public void setFromdate(Date fromdate);

    /**
     * Returns the informationlevel of this information.
     *
     * @return the informationlevel of this information
     */
    @AutoEscape
    public String getInformationlevel();

    /**
     * Sets the informationlevel of this information.
     *
     * @param informationlevel the informationlevel of this information
     */
    public void setInformationlevel(String informationlevel);

    /**
     * Returns the createdat of this information.
     *
     * @return the createdat of this information
     */
    public Date getCreatedat();

    /**
     * Sets the createdat of this information.
     *
     * @param createdat the createdat of this information
     */
    public void setCreatedat(Date createdat);

    /**
     * Returns the createdby of this information.
     *
     * @return the createdby of this information
     */
    @AutoEscape
    public String getCreatedby();

    /**
     * Sets the createdby of this information.
     *
     * @param createdby the createdby of this information
     */
    public void setCreatedby(String createdby);

    /**
     * Returns the modifiedat of this information.
     *
     * @return the modifiedat of this information
     */
    public Date getModifiedat();

    /**
     * Sets the modifiedat of this information.
     *
     * @param modifiedat the modifiedat of this information
     */
    public void setModifiedat(Date modifiedat);

    /**
     * Returns the modifiedby of this information.
     *
     * @return the modifiedby of this information
     */
    @AutoEscape
    public String getModifiedby();

    /**
     * Sets the modifiedby of this information.
     *
     * @param modifiedby the modifiedby of this information
     */
    public void setModifiedby(String modifiedby);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    @Override
    public Object clone();

    @Override
    public int compareTo(jp.co.esp.sample.model.Information information);

    @Override
    public int hashCode();

    @Override
    public CacheModel<jp.co.esp.sample.model.Information> toCacheModel();

    @Override
    public jp.co.esp.sample.model.Information toEscapedModel();

    @Override
    public jp.co.esp.sample.model.Information toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
