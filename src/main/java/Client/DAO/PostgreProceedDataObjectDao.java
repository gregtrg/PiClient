package Client.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Рабочий on 17.09.2015.
 */
public class PostgreProceedDataObjectDao implements IDaoProceedDataObject {

    private final Connection connection ;

    @Override
    public DataObject getProceedDataObject() throws SQLException{
        String query = "SELECT ... ";
        DataObject c = new DataObject();
        try(PreparedStatement stmn = connection.prepareStatement(query)) {
            ResultSet rs = stmn.executeQuery();
            while(rs.next()) {
                StringBuilder row = new StringBuilder();
                row.append("\"id\": ");
                row.append("\"" + rs.getObject("sync_id") + "\"");
                row.append(", \"place_code\": ");
                row.append("\"" + rs.getObject("place_code") + "\"");
                row.append(", \"datetime\": ");
                row.append("\"" + rs.getObject("created_datetime") + "\"");

                if (rs.getObject("pressure_mwc") != null) {
                    c.add("{" + row.toString() + ", \"parameter\": \"P\", \"value\": \"" + rs.getObject("pressure_mwc") + "\"}");
                }
                if (rs.getObject("volume_m3") != null) {
                    c.add("{" + row.toString() + ", \"parameter\": \"DC\", \"value\": \"" + rs.getObject("volume_m3") + "\"}");
                }
                if (rs.getObject("volume_acc_m3") != null) {
                    c.add("{" + row.toString() + ", \"parameter\": \"RC\", \"value\": \"" + rs.getObject("volume_acc_m3") + "\"}");
                }
                if (rs.getObject("volume_flow_m3_per_h") != null) {
                    c.add("{" + row.toString() + ", \"parameter\": \"DFH\", \"value\": \"" + rs.getObject("volume_flow_m3_per_h") + "\"}");
                }
            }
            rs.close();
            stmn.close();
        }
        return c;
    }
    PostgreProceedDataObjectDao(Connection connection) {
        this.connection = connection;
    }
}
