package Client;

import Client.DAO.IDaoFactory;
import Client.DAO.IDaoProceedDataObject;
import Client.DAO.PersistException;
import Client.postgresql.PostgreDaoFactory;
import Client.postgresql.PostgreProceedDataObjectDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Controller {
    IDaoFactory factory;
    IDaoProceedDataObject dao;
    Logger log = LogManager.getLogger("ClientPI");
    public Controller() {
        try {
            factory = new PostgreDaoFactory();
            log.info("Try establishing a connection...");
            dao = new PostgreProceedDataObjectDao(factory.getConnection());
            log.info("Connection is established");
        } catch (PersistException ex) {
            log.error("Connection problems", ex);
        }
    }
    public void start() {
        try {
            log.info("Start.");
            dao.getProceedDataObject();
        } catch (PersistException e) {
            LogManager.getLogger("ClientPI").error("Stop",e);
        }
    }
}
