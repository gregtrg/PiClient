package Client.DAO;

import java.sql.SQLException;

/**
 * Created by Рабочий on 17.09.2015.
 */
public interface IDaoCounter {
    /** Возвращает необходимую для синхронизации информацию*/
    Counte getSynchronizationInformation() throws SQLException;
}
