package Client.DAO;

import java.sql.SQLException;

/**
 * Created by Рабочий on 17.09.2015.
 */
public interface IDaoProceedDataObject {
    /** Возвращает объект, содержащий информацию для PI */
    ProceedDataObject getProceedDataObject() throws SQLException;
}
