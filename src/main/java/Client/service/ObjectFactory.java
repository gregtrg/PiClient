package Client.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import Client.service.UpdateValues;
import Client.service.UpdateValuesResponse;

@XmlRegistry
public class ObjectFactory {
    private static final QName _UpdateValuesResponseUpdateValuesResult_QNAME = new QName("http://tempuri.org/", "UpdateValuesResult");
    private static final QName _UpdateValuesValues_QNAME = new QName("http://tempuri.org/", "values");

    public ObjectFactory() {
    }

    public UpdateValues createUpdateValues() {
        return new UpdateValues();
    }

    public UpdateValuesResponse createUpdateValuesResponse() {
        return new UpdateValuesResponse();
    }

    @XmlElementDecl(
            namespace = "http://tempuri.org/",
            name = "UpdateValuesResult",
            scope = UpdateValuesResponse.class
    )
    public JAXBElement<String> createUpdateValuesResponseUpdateValuesResult(String var1) {
        return new JAXBElement(_UpdateValuesResponseUpdateValuesResult_QNAME, String.class, UpdateValuesResponse.class, var1);
    }

    @XmlElementDecl(
            namespace = "http://tempuri.org/",
            name = "values",
            scope = UpdateValues.class
    )
    public JAXBElement<String> createUpdateValuesValues(String var1) {
        return new JAXBElement(_UpdateValuesValues_QNAME, String.class, UpdateValues.class, var1);
    }
}
