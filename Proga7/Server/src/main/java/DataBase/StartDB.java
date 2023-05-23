package DataBase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class StartDB{
    private Statement statement;
    private Connection connection;

    public Statement getStatement() {
        return statement;
    }

    public Connection getConnection() {
        return connection;
    }

    public void startDataBase() throws ClassNotFoundException, SQLException {
        MakeConnection.maKeAdatabaseConnection();
        CreateDefaultDB defaultDB = new CreateDefaultDB(MakeConnection.getStatement());
        defaultDB.makeUsersTable();
        defaultDB.makeMoviesTable();
        this.statement = MakeConnection.getStatement();
        this.connection = MakeConnection.getConnection();
    }
}
