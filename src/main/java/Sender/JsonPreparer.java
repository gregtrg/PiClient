package Sender;

import Client.DAO.ProceedDataObject;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Класс для отправки информации к PI сервису
 */
public class JsonPreparer {

    ProceedDataObject dataObject;

    public JsonPreparer(ProceedDataObject dataObject) {
        this.dataObject = dataObject;
    }

    public JSONObject javaToJSON() throws ParseException{
        JSONObject jsonObject = null;
        if(dataObject.size() != 0) {
            JSONParser parser = new JSONParser();
            jsonObject = (JSONObject) parser.parse(dataObject.toString());
        }
        return jsonObject;
    }

}
