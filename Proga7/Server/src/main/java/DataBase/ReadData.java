package DataBase;

import DataFromTask.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public class ReadData {

    public static void readData(Set<Movie> set, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM movies");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Movie movie = new Movie();
            movie.setId();
            movie.setName(resultSet.getString("name"));
            movie.setCoordinates(new Coordinates(resultSet.getInt("x"), resultSet.getFloat("y")));
            movie.setOscarsCount((long) resultSet.getInt("count_of_oscars"));
            movie.setGenre(MovieGenre.valueOf(resultSet.getString("genre")));
            movie.setMpaaRating(resultSet.getString("mpaa_rating"));
            movie.setOperator(new Person(resultSet.getString("operator"), resultSet.getInt("weight"), Color.valueOf(resultSet.getString("hair_color")), Country.valueOf(resultSet.getString("nationality"))));
            movie.setUser_id(resultSet.getInt("user_id"));
            set.add(movie);
        }
    }

}
