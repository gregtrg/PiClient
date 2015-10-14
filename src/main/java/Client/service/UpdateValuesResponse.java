package Client.service;


import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"updateValuesResult"}
)
@XmlRootElement(
        name = "UpdateValuesResponse"
)
public class UpdateValuesResponse {
    @XmlElementRef(
            name = "UpdateValuesResult",
            namespace = "http://tempuri.org/",
            type = JAXBElement.class,
            required = false
    )
    protected JAXBElement<String> updateValuesResult;

    public UpdateValuesResponse() {
    }

    public JAXBElement<String> getUpdateValuesResult() {
        return this.updateValuesResult;
    }

    public void setUpdateValuesResult(JAXBElement<String> var1) {
        this.updateValuesResult = var1;
    }
}

