package Client.DAO;

import java.sql.Connection;

/**
 * Класс-фабрика DAO
 * @author Grigorii Moiseev
 */
public interface IDaoFactory{

    /** Возвращает подключение к базе данных */
    public Connection getConnection() throws PersistException;
    /** Возвращает объект для управления персистентным состоянием объекта ProceedDataObject */
    public IDaoProceedDataObject getProceedDataObjectDao(Connection connection);
}
