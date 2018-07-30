package jp.co.esp.sample.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author SampleDeveloper
 * @generated
 */
public class InformationSoap implements Serializable {
    private long _informationnumber;
    private String _title;
    private String _content;
    private Date _fromdate;
    private String _informationlevel;
    private Date _createdat;
    private String _createdby;
    private Date _modifiedat;
    private String _modifiedby;

    public InformationSoap() {
    }

    public static InformationSoap toSoapModel(Information model) {
        InformationSoap soapModel = new InformationSoap();

        soapModel.setInformationnumber(model.getInformationnumber());
        soapModel.setTitle(model.getTitle());
        soapModel.setContent(model.getContent());
        soapModel.setFromdate(model.getFromdate());
        soapModel.setInformationlevel(model.getInformationlevel());
        soapModel.setCreatedat(model.getCreatedat());
        soapModel.setCreatedby(model.getCreatedby());
        soapModel.setModifiedat(model.getModifiedat());
        soapModel.setModifiedby(model.getModifiedby());

        return soapModel;
    }

    public static InformationSoap[] toSoapModels(Information[] models) {
        InformationSoap[] soapModels = new InformationSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static InformationSoap[][] toSoapModels(Information[][] models) {
        InformationSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new InformationSoap[models.length][models[0].length];
        } else {
            soapModels = new InformationSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static InformationSoap[] toSoapModels(List<Information> models) {
        List<InformationSoap> soapModels = new ArrayList<InformationSoap>(models.size());

        for (Information model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new InformationSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _informationnumber;
    }

    public void setPrimaryKey(long pk) {
        setInformationnumber(pk);
    }

    public long getInformationnumber() {
        return _informationnumber;
    }

    public void setInformationnumber(long informationnumber) {
        _informationnumber = informationnumber;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public String getContent() {
        return _content;
    }

    public void setContent(String content) {
        _content = content;
    }

    public Date getFromdate() {
        return _fromdate;
    }

    public void setFromdate(Date fromdate) {
        _fromdate = fromdate;
    }

    public String getInformationlevel() {
        return _informationlevel;
    }

    public void setInformationlevel(String informationlevel) {
        _informationlevel = informationlevel;
    }

    public Date getCreatedat() {
        return _createdat;
    }

    public void setCreatedat(Date createdat) {
        _createdat = createdat;
    }

    public String getCreatedby() {
        return _createdby;
    }

    public void setCreatedby(String createdby) {
        _createdby = createdby;
    }

    public Date getModifiedat() {
        return _modifiedat;
    }

    public void setModifiedat(Date modifiedat) {
        _modifiedat = modifiedat;
    }

    public String getModifiedby() {
        return _modifiedby;
    }

    public void setModifiedby(String modifiedby) {
        _modifiedby = modifiedby;
    }
}
