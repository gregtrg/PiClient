package Client.DAO;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Grigorii Moiseev
 */
public interface IDaoFactory {

    /** Возвращает подключение к базе данных */
    public Connection getConnection() throws SQLException;
    /** Возвращает объект для управления персистентным состоянием объекта Counter */
    public IDaoCounter getCounterDao(Connection connection);
}
