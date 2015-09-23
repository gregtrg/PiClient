package Client.postgresql;

import Client.DAO.IDaoFactory;
import Client.DAO.IDaoProceedDataObject;
import Client.DAO.PersistException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Реализация DAO для PostgreSQL
 */
public class PostgreDaoFactory implements IDaoFactory {
    private String user = "root"; //Логин пользователя
    private String password = ""; //Пароль пользователя
    private String url = "jdbc:mysql://localhost:3306/DBuri"; //URL адрес
    private String driver = "org.postgresql.Driver";//Имя драйвера

    public Connection getConnection() throws PersistException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new PersistException(e);
        }
        return connection;
    }

    @Override
    public IDaoProceedDataObject getProceedDataObjectDao(Connection connection) {
        return new PostgreProceedDataObjectDao(connection);
    }

    public PostgreDaoFactory() {
        try {
            Class.forName(driver); //Регистрируем драйвер
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
