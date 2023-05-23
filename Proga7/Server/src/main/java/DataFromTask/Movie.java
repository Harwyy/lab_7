package DataFromTask;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Class by tz.
 * @author Andrew Lazarchuk
 */
public class Movie implements Comparable<Movie>{
    private int id;
    private String name;
    private Coordinates coordinates;
    private LocalDateTime creationDate = LocalDateTime.now();
    private Long oscarsCount;
    private MovieGenre genre;
    private MpaaRating mpaaRating;
    private Person operator;
    public static int counterId = 1;
    int user_id;

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setId() {
        this.id = Movie.counterId;
        Movie.counterId += 1;
    }

    public int getUser_id() {
        return user_id;
    }

    public Movie() {
    }

    public Movie(String name, Coordinates coordinates, LocalDateTime creationDate, Long oscarsCount, MovieGenre genre, MpaaRating mpaaRating, Person operator) {
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.oscarsCount = oscarsCount;
        this.genre = genre;
        this.mpaaRating = mpaaRating;
        this.operator = operator;
        this.id = Movie.counterId;
        Movie.counterId += 1;
    }

    public Long getOscarsCount() {
        return oscarsCount;
    }

    public void setOscarsCount(Long oscarsCount) {
        this.oscarsCount =oscarsCount;
    }

    public MovieGenre getGenre() {
        return genre;
    }

    public void setGenre(MovieGenre genre) {
        this.genre = genre;
    }

    public MpaaRating getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String str) {
        this.mpaaRating = MpaaRating.valueOf(str);
    }

    public Person getOperator() {
        return operator;
    }

    public void setOperator(Person operator) {
        this.operator = operator;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public int compareTo(Movie movie) {
        if (id - movie.getId() == 0){
            return this.getName().compareTo(movie.getName());
        }
        return id - movie.getId();
    }

    @Override
    public String toString() {
        String stringLine = "---".repeat(15);
        return stringLine + "\n"
                + "Movie: " + name + "\n"
                + stringLine + "\n"
                + "id: " + id + "\n"
                + "coordinates: " + coordinates + "\n"
                + "creation date: " + creationDate.format(DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy")) + "\n"
                + "oscars count: " + oscarsCount + "\n"
                + "genre: " + genre + "\n"
                + "MPAA raiting: " + mpaaRating + "\n"
                + "operator: " + operator;

    }
}
