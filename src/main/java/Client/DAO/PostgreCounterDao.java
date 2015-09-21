package Client.DAO;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Рабочий on 17.09.2015.
 */
public class PostgreCounterDao implements IDaoCounter {

    private final Connection connection ;

    @Override
    public Counter getSynchronizationInformation() throws SQLException{
        String query = "SELECT ... ";
        Counter c = new Counter();
        try(PreparedStatement stmn = connection.prepareStatement(query)) {
            ResultSet rs = stmn.executeQuery();
            rs.next();
            c.setInformation(rs.toString()); //??
        }
        return c;
    }
    PostgreCounterDao(Connection connection) {
        this.connection = connection;
    }
}
