package Client.postgresql;

import Client.DAO.IDaoProceedDataObject;
import Client.DAO.PersistException;
import Client.domain.ProceedDataObject;
import org.apache.logging.log4j.LogManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PostgreProceedDataObjectDao implements IDaoProceedDataObject {

    private final Connection connection ;


    @Override
    public ProceedDataObject getProceedDataObject() throws PersistException {
        String query = getSelectedQuery();
        ProceedDataObject c;
        LogManager.getLogger("ClientPI").info("Preparing information for sending..");

        try(PreparedStatement stmn = connection.prepareStatement(query)) {
            ResultSet rs = stmn.executeQuery();
            c = parseResultSet(rs);
        }catch (SQLException e) {
            LogManager.getLogger("ClientPI").error("Preparing have not completed");
            throw new PersistException(e);
        }
        return c;
    }

    @Override
    public String getSelectedQuery() {
        return "SELECT ...";
    }

    @Override
    public ProceedDataObject parseResultSet(ResultSet rs) throws PersistException {
        ProceedDataObject c = new ProceedDataObject();
        try {
            while (rs.next()) {
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
                rs.close();
            }
        } catch (SQLException ex) {
            LogManager.getLogger("ClientPI").error("Preparing have not completed");
            throw new PersistException(ex);
        }
        return  c;
    }

    public PostgreProceedDataObjectDao(Connection connection) {
        this.connection = connection;
    }
}
