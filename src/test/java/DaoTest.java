import Client.DAO.IDaoProceedDataObject;
import Client.domain.ProceedDataObject;
import junit.framework.Assert;
import org.junit.Test;

import java.sql.Connection;


public abstract class DaoTest {
    public abstract IDaoProceedDataObject dao();
    public abstract Connection context();

    @Test
    public void getProceedDataObjectTest() throws Exception {
        ProceedDataObject dataObject = dao().getProceedDataObject();
        //Assert.assertNotNull(dataObject);
        Assert.assertTrue(dataObject.size() > 0);
    }

}
