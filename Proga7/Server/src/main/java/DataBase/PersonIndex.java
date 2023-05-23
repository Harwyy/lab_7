package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonIndex {

    public static int personIndex(Connection connection, ArrayList<String> list) throws SQLException {
        PreparedStatement preparedStatement =  connection.prepareStatement("SELECT id from users where name = ? and password = ?");
        preparedStatement.setString(1, list.get(0) );
        preparedStatement.setString(2, list.get(1) );
        ResultSet set = preparedStatement.executeQuery();
        set.next();
        return set.getInt("id");
    }
}
