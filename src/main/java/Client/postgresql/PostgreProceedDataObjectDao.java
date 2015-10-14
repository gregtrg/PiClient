package Client.postgresql;

import Client.DAO.ErrorsTypes;
import Client.DAO.IDaoProceedDataObject;
import Client.DAO.PersistException;
import Client.domain.ProceedDataObject;
import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
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
        } finally {
            if(connection!=null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return c;
    }

    @Override
    public String getSelectedQuery() {
        return "SELECT CD.sync_id, CD.data_id, CD.place_code, CD.serial_number, CD.sync_pi_send_flow_per_h, " +
                "(to_char(CD.created_datetime_rounded, 'YYYY-MM-DD') || 'T' || to_char(CD.created_datetime_rounded, 'HH24:MI')" +
                " || ':00') AS created_datetime, CD.pressure_bar, CD.pressure_mwc, CD.volume_m3, CD.volume_acc_m3, " +
                "CD.volume_flow_m3_per_h, CD.sync_try_count_max FROM \"CounterData_PISync\" AS CD " +
                "WHERE CD.sync_state=0 " +
                "ORDER BY CD.data_id LIMIT 1000";
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
            }
        } catch (SQLException ex) {
            LogManager.getLogger("ClientPI").error("Preparing have not completed");
            throw new PersistException(ErrorsTypes.PREPARING.toString() + ex);
        } finally {
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    throw new PersistException(ErrorsTypes.CLOSEING.toString() + ex);
                }
            }
        }
        return  c;
    }

    public PostgreProceedDataObjectDao(Connection connection) {
        this.connection = connection;
    }
}
