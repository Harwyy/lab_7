package Launcher;

import DataBase.MakeConnection;
import DataBase.PersonIndex;
import DataBase.ReadData;
import DataFromTask.*;
import org.postgresql.util.OSUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Launcher {

    private static TreeSet<Movie> treeSet = new TreeSet<>();
    public static Set<Movie> set =  Collections.synchronizedSet(treeSet);
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
    public static Connection connection = MakeConnection.getConnection();

    public static void readDataPro() throws SQLException {
        ReadData.readData(set, connection);
    }

    public static String launcher(ArrayList<ArrayList<String>> list) throws SQLException {
//        Connection connection = MakeConnection.getConnection();
        StringBuilder stringBuilder = new StringBuilder();
        for (ArrayList<String> miniList : list){

            System.out.println(miniList);

            if (miniList.get(0).equals("registration")){
                PreparedStatement preparedStatement_oneMore = connection.prepareStatement("SELECT name from users where name = ?");
                preparedStatement_oneMore.setString(1, miniList.get(1));
                ResultSet resultSet = preparedStatement_oneMore.executeQuery();
                if (resultSet.next()){
                    stringBuilder.append("Пользователь с таким именем уже существует. Проявите фантазию...");
                    return stringBuilder.toString();
                }
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users(name, password) VALUES(?,?)");
                preparedStatement.setString(1, miniList.get(1));
                preparedStatement.setString(2, miniList.get(2));
                preparedStatement.executeUpdate();
                stringBuilder.append("Новый пользователь создан. Приятной вам работы!");
            }

            else if (miniList.get(0).equals("authorization")){
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT name from users where users.name = ? AND users.password = ?");
                preparedStatement.setString(1, miniList.get(1));
                preparedStatement.setString(2, miniList.get(2));
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()){
                    stringBuilder.append("Добро пожаловать на сервер!");
                } else {
                    stringBuilder.append("Неправильный логин или пароль...");
                }
            }

            else if (miniList.size() == 3 && miniList.get(2).equals("help")) {
                  stringBuilder.append("Была исполнена команда help.");
            }

            else if (miniList.size() == 3 && miniList.get(2).equals("info")) {
                stringBuilder.append("Тип коллекции: " + set.getClass() + "\n"
                        + "Размер коллекции: " + set.size());
            }

            else if (miniList.size() > 3 && miniList.get(2).equals("add")) {

                int index = PersonIndex.personIndex(connection, miniList);

                System.out.println(PersonIndex.personIndex(connection, miniList));
                Movie movie = new Movie();
                movie.setId();
                movie.setName(miniList.get(3));
                movie.setCoordinates(new Coordinates(Integer.parseInt(miniList.get(4)), Double.parseDouble(miniList.get(5))));
                movie.setOscarsCount(Long.parseLong(miniList.get(6)));
                movie.setGenre(MovieGenre.valueOf(miniList.get(7)));
                movie.setMpaaRating(miniList.get(8));
                movie.setOperator(new Person(miniList.get(9), Integer.parseInt(miniList.get(10)), Color.valueOf(miniList.get(11)), Country.valueOf(miniList.get(12))));
                movie.setUser_id(index);

                Lock lock = new ReentrantLock();

                lock.lock();
                set.add(movie);
                lock.unlock();

                stringBuilder.append( "Фильм " + miniList.get(3) + " был добавлен в коллекцию.");

                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO movies(name, x, y, add_time, count_of_oscars, genre, mpaa_rating, operator, weight, hair_color, nationality, user_id ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                preparedStatement.setString(1, miniList.get(3));
                preparedStatement.setInt(2, Integer.parseInt(miniList.get(4)));
                preparedStatement.setFloat(3, Float.parseFloat(miniList.get(5)));
                String date  = LocalDateTime.now().format(formatter).toString();
                preparedStatement.setString(4, date);
                preparedStatement.setInt(5, Integer.parseInt(miniList.get(6)));
                preparedStatement.setString(6, miniList.get(7));
                preparedStatement.setString(7, miniList.get(8));
                preparedStatement.setString(8, miniList.get(9));
                preparedStatement.setFloat(9, Integer.parseInt(miniList.get(10)));
                preparedStatement.setString(10, miniList.get(11));
                preparedStatement.setString(11, miniList.get(12));
                preparedStatement.setInt(12, index);
                preparedStatement.executeUpdate();
            }

            else if (miniList.size() == 3 && miniList.get(2).equals("show")){
                if (set.size() == 0){stringBuilder.append("Коллекция пуста.");}
                else{
                    StringBuilder s = new StringBuilder();
                    for (Movie movie : set) {
                        s.append(movie.toString());
                    }
                    stringBuilder.append(s.substring(0, s.toString().length() - 1));
                }
            }

            else if (miniList.size() == 3 && miniList.get(2).equals("print field ascending genre")) {
                if (set.size() == 0) {
                    stringBuilder.append("Коллекция пуста.");
                }
                else {
                    StringBuilder answer = new StringBuilder();
                    set.stream().sorted(Comparator.comparing(Movie::getGenre)).forEach(movie -> answer.append(movie.getGenre() + "\n"));
                    String str = answer.toString().substring(0, answer.toString().length() - 1);
                    stringBuilder.append(str);

                }
            }

            else if (miniList.size() == 4 && miniList.get(2).equals("remove by")){
                int index = PersonIndex.personIndex(connection, miniList);
                if (set.size() == 0){stringBuilder.append("Коллекция пуста.");}
                Lock lock = new ReentrantLock();
                Iterator<Movie> movies = set.iterator();
                TreeSet<Movie> treeSet1 = new TreeSet<>();
                while (movies.hasNext()){
                    Movie movie = movies.next();
                    if (movie.getUser_id() == index && movie.getId() == Integer.parseInt(miniList.get(3))){
                        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM movies where user_id = ? and  name = ?");
                        preparedStatement.setInt(1, index);
                        preparedStatement.setString(2, movie.getName());
                        preparedStatement.executeUpdate();
                        stringBuilder.append("Фильм " + movie.getName() + " был удален.");
                    }
                    else {
                        treeSet1.add(movie);
                    }
                }
                lock.lock();
                set.clear();
                set.addAll(treeSet1);
                lock.unlock();

            }

            else if (miniList.size() == 3 && miniList.get(2).equals("clear")) {
                int index = PersonIndex.personIndex(connection, miniList);
                Lock lock = new ReentrantLock();
                Iterator<Movie> movies = set.iterator();
                TreeSet<Movie> treeSet1 = new TreeSet<>();
                while (movies.hasNext()){
                    Movie movie = movies.next();
                    if (movie.getUser_id() != index){
                        treeSet1.add(movie);
                    }
                }
                lock.lock();
                set.clear();
                set.addAll(treeSet1);
                lock.unlock();
                PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM movies where user_id = ?");
                preparedStatement.setInt(1, index);
                preparedStatement.executeUpdate();
                stringBuilder.append("Коллекция отчищена от ваших фильмов.");
            }

            else if (miniList.size() == 3 && miniList.get(2).equals("min by oscars count")){
                if (treeSet.size() == 0) { stringBuilder.append("Коллекция пуста"); }
                else {
                    List<Movie> copyOfTreeSet = new ArrayList<>(treeSet);
                    Collections.sort(copyOfTreeSet, new Comparator<Movie>() {
                        @Override
                        public int compare(Movie m1, Movie m2) {
                            return (int) (m1.getOscarsCount() - m2.getOscarsCount());
                        }
                    });
                    stringBuilder.append(copyOfTreeSet.get(0).toString());
                }
            }

            else if (miniList.size() == 4 && miniList.get(2).equals("remove lower")) {
                int index = PersonIndex.personIndex(connection, miniList);
                Lock lock = new ReentrantLock();
                Long oscars = Long.parseLong(miniList.get(3));
                final int treeSetSize = set.size();
                if (set.size() == 0) {stringBuilder.append("Коллекция пуста");}
                else {
                    Iterator<Movie> movies = set.iterator();
                    TreeSet<Movie> treeSet1 = new TreeSet<>();
                    while (movies.hasNext()) {
                        Movie movie = movies.next();
                        if (movie.getOscarsCount() < oscars && movie.getUser_id() == index) {
                            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM movies where user_id = ? and  name = ?");
                            preparedStatement.setInt(1, index);
                            preparedStatement.setString(2, movie.getName());
                            preparedStatement.executeUpdate();
                        } else {
                            treeSet1.add(movie);
                        }
                    }
                    lock.lock();
                    set.clear();
                    set.addAll(treeSet1);
                    lock.unlock();
                    stringBuilder.append(treeSetSize - set.size() + " фильм(а) был(о) удален(о)");
                }
            }

            else  if (miniList.size() == 3 && miniList.get(2).equals("average of oscars count")){
                if (set.size() == 0) { stringBuilder.append("Коллекция пуста");}
                else {
                    long counter = 0;
                    for (Movie movie : set) {
                        counter = counter + movie.getOscarsCount();
                    }
                    stringBuilder.append("Среднее значение оскаров: " + Math.round(counter / treeSet.size()));
                }
            }

            else if (miniList.size() >= 4 && miniList.get(2).equals("update")) {
                int index = PersonIndex.personIndex(connection, miniList);
                if (set.size() == 0) {stringBuilder.append("Коллекция пуста");}
                else {
                    Iterator<Movie> movies = set.iterator();
                    TreeSet<Movie> treeSet1 = new TreeSet<>();
                    while (movies.hasNext()){
                        Movie movie = movies.next();
                        if (movie.getName().toLowerCase().equals(miniList.get(3)) && movie.getUser_id() == index){
                            movie.setName(miniList.get(3));
                            movie.setCoordinates(new Coordinates(Integer.parseInt(miniList.get(4)), Double.parseDouble(miniList.get(5))));
                            movie.setOscarsCount(Long.parseLong(miniList.get(6)));
                            movie.setGenre(MovieGenre.valueOf(miniList.get(7)));
                            movie.setMpaaRating(miniList.get(8));
                            movie.setOperator(new Person(miniList.get(9), Integer.parseInt(miniList.get(10)), Color.valueOf(miniList.get(11)), Country.valueOf(miniList.get(12))));
                            movie.setUser_id(index);
                            treeSet1.add(movie);
                            PreparedStatement prepared = connection.prepareStatement("DELETE FROM movies WHERE name = ?");
                            prepared.setString(1, miniList.get(3));
                            prepared.executeUpdate();
                            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO movies(name, x, y, add_time, count_of_oscars, genre, mpaa_rating, operator, weight, hair_color, nationality, user_id ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                            preparedStatement.setString(1, miniList.get(3));
                            preparedStatement.setInt(2, Integer.parseInt(miniList.get(4)));
                            preparedStatement.setFloat(3, Float.parseFloat(miniList.get(5)));
                            String date  = LocalDateTime.now().format(formatter).toString();
                            preparedStatement.setString(4, date);
                            preparedStatement.setInt(5, Integer.parseInt(miniList.get(6)));
                            preparedStatement.setString(6, miniList.get(7));
                            preparedStatement.setString(7, miniList.get(8));
                            preparedStatement.setString(8, miniList.get(9));
                            preparedStatement.setFloat(9, Integer.parseInt(miniList.get(10)));
                            preparedStatement.setString(10, miniList.get(11));
                            preparedStatement.setString(11, miniList.get(12));
                            preparedStatement.setInt(12, index);
                            preparedStatement.executeUpdate();
                        }
                        else {
                            treeSet1.add(movie);
                        }
                    }
                    Lock lock = new ReentrantLock();
                    lock.lock();
                    set.clear();
                    set.addAll(treeSet1);
                    lock.unlock();
                    stringBuilder.append("Фильм " + miniList.get(3) + " обновлён.");
                }

            }
        }
        return stringBuilder.toString();
    }
}
