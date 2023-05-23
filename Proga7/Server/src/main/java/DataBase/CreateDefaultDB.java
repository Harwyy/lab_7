package DataBase;

import java.sql.SQLException;
import java.sql.Statement;

public class CreateDefaultDB {

    private Statement statement;

    public CreateDefaultDB(Statement statement) {
        this.statement = statement;
    }

    public void makeUsersTable() throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS Users(id serial PRIMARY KEY, name text, password text)");
    }

    public void makeMoviesTable(){
        try {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Movies(id serial PRIMARY KEY" +
                    ", name text, x integer, y float, add_time text, count_of_oscars integer, genre text, " +
                    "MPAA_rating text, operator text, weight float, hair_color text, nationality text," +
                    "user_id integer)");
            statement.executeUpdate("alter table Movies add constraint user_id_FK FOREIGN KEY (user_id) REFERENCES Users(id)");
        } catch (SQLException e){

        }
    }
}
