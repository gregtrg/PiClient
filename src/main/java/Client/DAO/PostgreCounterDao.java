package Client.DAO;

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
    public Counte getSynchronizationInformation() throws SQLException{
        String query = "SELECT ... ";
        Counte c = new Counte();
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
