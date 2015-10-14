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
        propOrder = {"values"}
)
@XmlRootElement(
        name = "UpdateValues"
)
public class UpdateValues {
    @XmlElementRef(
            name = "values",
            namespace = "http://tempuri.org/",
            type = JAXBElement.class,
            required = false
    )
    protected JAXBElement<String> values;

    public UpdateValues() {
    }

    public JAXBElement<String> getValues() {
        return this.values;
    }

    public void setValues(JAXBElement<String> var1) {
        this.values = var1;
    }
}

