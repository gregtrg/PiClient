import Client.domain.ProceedDataObject;
import Client.JSON.JsonPreparer;
import junit.framework.Assert;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

public class JsonPreparerTest {
    private ProceedDataObject dataObject = new ProceedDataObject();

    @Before
    public void setUp() {
        StringBuilder row = new StringBuilder();
        row.append("\"id\": ");
        row.append(1);
        row.append(", \"place_code\": ");
        row.append("\"B-1111\"");
        row.append(", \"datetime\": ");
        row.append("\"12.11.2015\"");

        dataObject.add("{"+row.toString() + ", \"parameter\": \"P\"  \"value\": " + "\"mwc\"}");
        dataObject.add("{"+row.toString() + ", \"parameter\": \"DC\", \"value\": " + "\"m3\"}");
        dataObject.add("{"+row.toString() + ", \"parameter\": \"RC\", \"value\": " + "\"volume_acc_m3\"}");
        dataObject.add("{"+row.toString() + ", \"parameter\": \"DFH\", \"value\": " + "\"volume_flow_m3_per_h\"}");
    }

    @Test
    public void getJSONfromPreparer() {
        System.out.println(dataObject.toString());
        JSONParser parser = new JSONParser();
        try{
            JsonPreparer temp = new JsonPreparer(dataObject);
            temp.javaToJSON();
        }catch (ParseException e) {
        System.err.println("Ошибка парсинга javaToJSON! \n" + e.getMessage() );
            Assert.fail();
        }




    }
}
