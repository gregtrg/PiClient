package Client.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(
        name = "IWriterPiService",
        targetNamespace = "http://tempuri.org/"
)
@XmlSeeAlso({ObjectFactory.class, Client.service.ObjectFactory.class})
public interface IWriterPiService {
    @WebMethod(
            operationName = "UpdateValues",
            action = "http://tempuri.org/IWriterPiService/UpdateValues"
    )
    @WebResult(
            name = "UpdateValuesResult",
            targetNamespace = "http://tempuri.org/"
    )
    @RequestWrapper(
            localName = "UpdateValues",
            targetNamespace = "http://tempuri.org/",
            className = "org.tempuri.UpdateValues"
    )
    @ResponseWrapper(
            localName = "UpdateValuesResponse",
            targetNamespace = "http://tempuri.org/",
            className = "org.tempuri.UpdateValuesResponse"
    )
    String updateValues(@WebParam(
            name = "values",
            targetNamespace = "http://tempuri.org/"
    ) String var1);
}