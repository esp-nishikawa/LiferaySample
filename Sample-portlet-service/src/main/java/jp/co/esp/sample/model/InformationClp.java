package jp.co.esp.sample.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import jp.co.esp.sample.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class InformationClp extends BaseModelImpl<Information>
    implements Information {
    private long _informationnumber;
    private String _title;
    private String _content;
    private Date _fromdate;
    private String _informationlevel;
    private Date _createdat;
    private String _createdby;
    private Date _modifiedat;
    private String _modifiedby;
    private BaseModel<?> _informationRemoteModel;
    private Class<?> _clpSerializerClass = jp.co.esp.sample.service.ClpSerializer.class;

    public InformationClp() {
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
    public long getPrimaryKey() {
        return _informationnumber;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setInformationnumber(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _informationnumber;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public long getInformationnumber() {
        return _informationnumber;
    }

    @Override
    public void setInformationnumber(long informationnumber) {
        _informationnumber = informationnumber;

        if (_informationRemoteModel != null) {
            try {
                Class<?> clazz = _informationRemoteModel.getClass();

                Method method = clazz.getMethod("setInformationnumber",
                        long.class);

                method.invoke(_informationRemoteModel, informationnumber);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTitle() {
        return _title;
    }

    @Override
    public void setTitle(String title) {
        _title = title;

        if (_informationRemoteModel != null) {
            try {
                Class<?> clazz = _informationRemoteModel.getClass();

                Method method = clazz.getMethod("setTitle", String.class);

                method.invoke(_informationRemoteModel, title);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getContent() {
        return _content;
    }

    @Override
    public void setContent(String content) {
        _content = content;

        if (_informationRemoteModel != null) {
            try {
                Class<?> clazz = _informationRemoteModel.getClass();

                Method method = clazz.getMethod("setContent", String.class);

                method.invoke(_informationRemoteModel, content);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getFromdate() {
        return _fromdate;
    }

    @Override
    public void setFromdate(Date fromdate) {
        _fromdate = fromdate;

        if (_informationRemoteModel != null) {
            try {
                Class<?> clazz = _informationRemoteModel.getClass();

                Method method = clazz.getMethod("setFromdate", Date.class);

                method.invoke(_informationRemoteModel, fromdate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getInformationlevel() {
        return _informationlevel;
    }

    @Override
    public void setInformationlevel(String informationlevel) {
        _informationlevel = informationlevel;

        if (_informationRemoteModel != null) {
            try {
                Class<?> clazz = _informationRemoteModel.getClass();

                Method method = clazz.getMethod("setInformationlevel",
                        String.class);

                method.invoke(_informationRemoteModel, informationlevel);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getCreatedat() {
        return _createdat;
    }

    @Override
    public void setCreatedat(Date createdat) {
        _createdat = createdat;

        if (_informationRemoteModel != null) {
            try {
                Class<?> clazz = _informationRemoteModel.getClass();

                Method method = clazz.getMethod("setCreatedat", Date.class);

                method.invoke(_informationRemoteModel, createdat);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCreatedby() {
        return _createdby;
    }

    @Override
    public void setCreatedby(String createdby) {
        _createdby = createdby;

        if (_informationRemoteModel != null) {
            try {
                Class<?> clazz = _informationRemoteModel.getClass();

                Method method = clazz.getMethod("setCreatedby", String.class);

                method.invoke(_informationRemoteModel, createdby);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getModifiedat() {
        return _modifiedat;
    }

    @Override
    public void setModifiedat(Date modifiedat) {
        _modifiedat = modifiedat;

        if (_informationRemoteModel != null) {
            try {
                Class<?> clazz = _informationRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedat", Date.class);

                method.invoke(_informationRemoteModel, modifiedat);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getModifiedby() {
        return _modifiedby;
    }

    @Override
    public void setModifiedby(String modifiedby) {
        _modifiedby = modifiedby;

        if (_informationRemoteModel != null) {
            try {
                Class<?> clazz = _informationRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedby", String.class);

                method.invoke(_informationRemoteModel, modifiedby);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getInformationRemoteModel() {
        return _informationRemoteModel;
    }

    public void setInformationRemoteModel(BaseModel<?> informationRemoteModel) {
        _informationRemoteModel = informationRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _informationRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_informationRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public Information toEscapedModel() {
        return (Information) ProxyUtil.newProxyInstance(Information.class.getClassLoader(),
            new Class[] { Information.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        InformationClp clone = new InformationClp();

        clone.setInformationnumber(getInformationnumber());
        clone.setTitle(getTitle());
        clone.setContent(getContent());
        clone.setFromdate(getFromdate());
        clone.setInformationlevel(getInformationlevel());
        clone.setCreatedat(getCreatedat());
        clone.setCreatedby(getCreatedby());
        clone.setModifiedat(getModifiedat());
        clone.setModifiedby(getModifiedby());

        return clone;
    }

    @Override
    public int compareTo(Information information) {
        int value = 0;

        value = DateUtil.compareTo(getFromdate(), information.getFromdate());

        value = value * -1;

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof InformationClp)) {
            return false;
        }

        InformationClp information = (InformationClp) obj;

        long primaryKey = information.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(19);

        sb.append("{informationnumber=");
        sb.append(getInformationnumber());
        sb.append(", title=");
        sb.append(getTitle());
        sb.append(", content=");
        sb.append(getContent());
        sb.append(", fromdate=");
        sb.append(getFromdate());
        sb.append(", informationlevel=");
        sb.append(getInformationlevel());
        sb.append(", createdat=");
        sb.append(getCreatedat());
        sb.append(", createdby=");
        sb.append(getCreatedby());
        sb.append(", modifiedat=");
        sb.append(getModifiedat());
        sb.append(", modifiedby=");
        sb.append(getModifiedby());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(31);

        sb.append("<model><model-name>");
        sb.append("jp.co.esp.sample.model.Information");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>informationnumber</column-name><column-value><![CDATA[");
        sb.append(getInformationnumber());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>title</column-name><column-value><![CDATA[");
        sb.append(getTitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>content</column-name><column-value><![CDATA[");
        sb.append(getContent());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>fromdate</column-name><column-value><![CDATA[");
        sb.append(getFromdate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>informationlevel</column-name><column-value><![CDATA[");
        sb.append(getInformationlevel());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createdat</column-name><column-value><![CDATA[");
        sb.append(getCreatedat());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createdby</column-name><column-value><![CDATA[");
        sb.append(getCreatedby());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modifiedat</column-name><column-value><![CDATA[");
        sb.append(getModifiedat());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modifiedby</column-name><column-value><![CDATA[");
        sb.append(getModifiedby());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
