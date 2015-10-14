package Client.postgresql;

import Client.DAO.ErrorsTypes;
import Client.DAO.IDaoFactory;
import Client.DAO.IDaoProceedDataObject;
import Client.DAO.PersistException;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Реализация DAO для PostgreSQL
 */
@Component
public class PostgreDaoFactory implements IDaoFactory {
    private String user = "postgres"; //Логин пользователя
    private String password = ""; //Пароль пользователя
    private String url = "jdbc:postgresql://localhost:2223/WaterMeterCounterAnalysis"; //URL адрес
    private String driver = "org.postgresql.Driver";//Имя драйвера

    public Connection getConnection() throws PersistException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new PersistException(ErrorsTypes.CONNECTION.toString() + e);
        }
        return connection;
    }

    @Override
    public IDaoProceedDataObject getProceedDataObjectDao(Connection connection) {
        return new PostgreProceedDataObjectDao(connection);
    }

    public PostgreDaoFactory() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
