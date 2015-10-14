package Client.service;


import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;
import Client.service.IWriterPiService;

@WebServiceClient(
        name = "WriterPiService",
        targetNamespace = "http://tempuri.org/",
        wsdlLocation = "META-INF/wsdl/WriterPiService.wsdl"
)
public class WriterPiService extends Service {
    private static final URL WRITERPISERVICE_WSDL_LOCATION = WriterPiService.class.getClassLoader().getResource("META-INF/wsdl/WriterPiService.wsdl");
    private static final WebServiceException WRITERPISERVICE_EXCEPTION;
    private static final QName WRITERPISERVICE_QNAME = new QName("http://tempuri.org/", "WriterPiService");

    public WriterPiService() {
        super(__getWsdlLocation(), WRITERPISERVICE_QNAME);
    }

    public WriterPiService(WebServiceFeature... var1) {
        super(__getWsdlLocation(), WRITERPISERVICE_QNAME, var1);
    }

    public WriterPiService(URL var1) {
        super(var1, WRITERPISERVICE_QNAME);
    }

    public WriterPiService(URL var1, WebServiceFeature... var2) {
        super(var1, WRITERPISERVICE_QNAME, var2);
    }

    public WriterPiService(URL var1, QName var2) {
        super(var1, var2);
    }

    public WriterPiService(URL var1, QName var2, WebServiceFeature... var3) {
        super(var1, var2, var3);
    }

    @WebEndpoint(
            name = "Indusoft.WriterPI.Service.EndPoint"
    )
    public IWriterPiService getIndusoftWriterPIServiceEndPoint() {
        return (IWriterPiService)super.getPort(new QName("http://tempuri.org/", "Indusoft.WriterPI.Service.EndPoint"), IWriterPiService.class);
    }

    @WebEndpoint(
            name = "Indusoft.WriterPI.Service.EndPoint"
    )
    public IWriterPiService getIndusoftWriterPIServiceEndPoint(WebServiceFeature... var1) {
        return (IWriterPiService)super.getPort(new QName("http://tempuri.org/", "Indusoft.WriterPI.Service.EndPoint"), IWriterPiService.class, var1);
    }

    private static URL __getWsdlLocation() {
        if(WRITERPISERVICE_EXCEPTION != null) {
            throw WRITERPISERVICE_EXCEPTION;
        } else {
            return WRITERPISERVICE_WSDL_LOCATION;
        }
    }

    static {
        WebServiceException var0 = null;
        if(WRITERPISERVICE_WSDL_LOCATION == null) {
            var0 = new WebServiceException("Cannot find \'META-INF/wsdl/WriterPiService.wsdl\' wsdl. Place the resource correctly in the classpath.");
        }

        WRITERPISERVICE_EXCEPTION = var0;
    }
}
