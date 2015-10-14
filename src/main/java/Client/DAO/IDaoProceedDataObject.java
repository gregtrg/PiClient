package Client.DAO;

import Client.domain.ProceedDataObject;

import java.sql.ResultSet;


/**
 * Класс для работы с базой данных
 * @author Grigorii Moiseev
 */
public interface IDaoProceedDataObject {
    /** Запрашивает информцию из базы и возвращает объект, содержащий эту информацию.
     * @return объект, содержащий информацию для PI */
    public ProceedDataObject getProceedDataObject() throws PersistException;
    /** Передает заготовленный запрос на языке SQL.
     * @return запрос на выборку */
    public String getSelectedQuery();
    /** Приводит данные в вид, воспринимаемый JSON Simple.
     * @param rs выборка данных.
     * @return объект ProceedDataObject содержащий инфомацию из базы,<br>
     *     для дальнейшего преобразования в JSON объект*/
    public ProceedDataObject parseResultSet(ResultSet rs) throws PersistException;
}
