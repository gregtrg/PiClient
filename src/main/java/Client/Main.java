package Client;

import Client.DAO.IDaoFactory;
import Client.DAO.IDaoProceedDataObject;
import Client.DAO.PersistException;
import Client.postgresql.PostgreDaoFactory;
import Client.postgresql.PostgreProceedDataObjectDao;
import Client.JSON.JsonPreparer;
import Client.service.IWriterPiService;
import Client.service.WriterPiService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.parser.ParseException;

/**
 * Главный класс клиента веб-сервиса PI.
 * @author Grigorii
 */
public class Main {
    IDaoFactory factory;
    IDaoProceedDataObject dao;
    Logger log = LogManager.getLogger("ClientPI");
    public Main() {
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
            JsonPreparer parser = new JsonPreparer(dao.getProceedDataObject());
            System.out.println(parser.javaToJSON());
            //WriterPiService k  = new WriterPiService();
            //Нужно заслать данные parser.javaToJSON() сервису WriterPiService()
            log.info("Done.");

        } catch (PersistException ex) {
            LogManager.getLogger("ClientPI").error("Stop",ex);
        } catch (ParseException ex) {
            LogManager.getLogger("ClientPI").error("Parsing Java2JSON problems!",ex);
        }
    }
    public static void main (String[] str) {

        Main mainObj = new Main();
        mainObj.start();
    }
}
