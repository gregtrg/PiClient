package Client.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Рабочий on 17.09.2015.
 */
public class PostgreDaoFactory implements IDaoFactory {
    private String user = "root"; //Логин пользователя
    private String password = ""; //Пароль пользователя
    private String url = "jdbc:mysql://localhost:3306/daotalk"; //URL адрес
    private String driver = "com.mysql.jdbc.Driver";//Имя драйвера

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public IDaoCounter getCounterDao(Connection connection) {
        return new PostgreCounterDao(connection);
    }

    public PostgreDaoFactory() {
        try {
            Class.forName(driver);//Регистрируем драйвер
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
