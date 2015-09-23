package Client.DAO;

import Client.domain.ProceedDataObject;

import java.sql.ResultSet;


/**
 * Класс DAO для ProceedDataObject
 * @author Grigorii Moiseev
 */
public interface IDaoProceedDataObject {
    /** Возвращает объект, содержащий информацию для PI */
    public ProceedDataObject getProceedDataObject() throws PersistException;
    /** Возвращает запрос на выборку */
    public String getSelectedQuery();
    /** Возвращает объект ProceedDataObject содержащий инфомацию */
    public ProceedDataObject parseResultSet(ResultSet rs) throws PersistException;
}
