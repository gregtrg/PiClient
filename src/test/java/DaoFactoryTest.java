import Client.DAO.IDaoFactory;
import Client.DAO.PersistException;
import Client.postgresql.PostgreDaoFactory;
import junit.framework.Assert;
import org.junit.Test;
import java.sql.Connection;

public class DaoFactoryTest {
    IDaoFactory daoFactory = new PostgreDaoFactory();

    @Test
    public void testConnection() {
        try {
            Connection con = daoFactory.getConnection();
        } catch (PersistException ex) {
            Assert.fail("Connection problems");
        }
    }

}
