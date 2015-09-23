import Client.DAO.IDaoFactory;
import Client.DAO.IDaoProceedDataObject;
import Client.DAO.PersistException;
import Client.postgresql.PostgreDaoFactory;
import org.junit.After;
import org.junit.Before;

import java.sql.Connection;
import java.sql.SQLException;

public class PostgreDaoTest extends DaoTest {

    private Connection connection;

    private IDaoProceedDataObject dao;

    private static final IDaoFactory factory = new PostgreDaoFactory();

    @Before
    public void setUp() throws PersistException, SQLException {
        connection = factory.getConnection();
        connection.setAutoCommit(false);
        dao = factory.getProceedDataObjectDao(connection);
    }

    @After
    public void tearDown() throws SQLException {
        context().rollback();
        context().close();
    }

    @Override
    public IDaoProceedDataObject dao() {
        return dao;
    }

    @Override
    public Connection context() {
        return connection;
    }
}
