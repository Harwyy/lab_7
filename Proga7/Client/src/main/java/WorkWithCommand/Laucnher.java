package WorkWithCommand;

import Authorization.User;
import InitParam.*;

import java.util.ArrayList;

public class Laucnher {
    public static ArrayList<ArrayList<String>> launcher(String command, User user){
        ArrayList<ArrayList<String>> mainList = new ArrayList<>();
        ArrayList<String> helperList = new ArrayList<>();

        helperList.add(user.getName());
        helperList.add(user.getPassword());

        if (command.equalsIgnoreCase("help")){
            System.out.println(" 1) info:  вывести в стандартный поток вывода информацию о коллекции." + "\n"
                    + " 2) show: вывести в стандартный поток вывода все элементы коллекции в строковом представлении." + "\n"
                    + " 3) add : добавить новый элемент в коллекцию." + "\n"
                    + " 4) print field ascending genre: вывести значения поля genre всех элементов в порядке возрастания." + "\n"
                    + " 5) remove by id {\"id\"}: удалить элемент из коллекции по его id." + "\n"
                    + " 6) clear: очистить коллекцию." + "\n"
                    + " 7) exit: завершить программу." + "\n"
                    + " 8) execute script {\"file name\"}: считать и исполнить скрипт из указанного файла." + "\n"
                    + " 9) update id {name}: обновить значение элемента коллекции, name которого равен заданному." + "\n"
                    + "10) remove lower {\"oscars count\"}: удалить из коллекции все элементы, у которые количество полученных оскоров меньше заданного количества." + "\n"
                    + "11) history: вывести последние 10 команд." + "\n"
                    + "12) average of oscars count: вывести среднее значение поля oscarsCount для всех элементов коллекции." + "\n"
                    + "13) min by oscars count: вывести любой объект из коллекции, значение поля oscarsCount которого является минимальным.");
            Hisory.push("help");
            helperList.add("help");
            mainList.add(helperList);
            return mainList;
        }

        else if (command.equalsIgnoreCase("exit")) {
            System.out.println("Всего хорошего!");
            System.exit(1);
        }

        else if (command.toLowerCase().equals("print field ascending genre")){
            helperList.add("print field ascending genre");
            mainList.add(helperList);
            Hisory.push("print field ascending genre");
            return mainList;
        }

        else if (command.contains("remove by")) {
            helperList.add("remove by");
            helperList.add(command.substring(11, command.length() - 1));
            mainList.add(helperList);
            Hisory.push("remove by");
            return mainList;
        }

        else if (command.equalsIgnoreCase("info")){
            Hisory.push("info");
            helperList.add("info");
            mainList.add(helperList);
            return mainList;
        }

        else if (command.equalsIgnoreCase("show")) {
            Hisory.push("show");
            helperList.add("show");
            mainList.add(helperList);
            return mainList;
        }

        else if (command.equalsIgnoreCase("clear")){
            Hisory.push("clear");
            helperList.add("clear");
            mainList.add(helperList);
            return mainList;
        }

        else if (command.equalsIgnoreCase("add")){
            helperList.add("add");
            helperList.add(InitMovieName.initializeNameOfMovie());
            helperList.add(InitMovieCoordinates.initializeCoordinateX().toString());
            helperList.add(InitMovieCoordinates.initializeCoordinateY().toString());
            helperList.add(InitMovieCountOfOscars.initializeOscarsCount().toString());
            helperList.add(InitMovieGenre.initializeMovieGenre());
            helperList.add(InitRating.initializeMpaaRating());
            helperList.add(InitOperator.initializeName());
            helperList.add(InitOperator.initializeWeight().toString());
            helperList.add(InitOperator.initializeHairColor());
            helperList.add(InitOperator.initializeCountry());
            mainList.add(helperList);
            Hisory.push("add");
            return mainList;
        }

        else if (command.contains("remove lower")) {
            helperList.add("remove lower");
            helperList.add(command.substring(14, command.length() - 1));
            mainList.add(helperList);
            Hisory.push("remove lower");
            return mainList;
        }

        else if (command.toLowerCase().equals("history")){
            Hisory.push("history");
            Hisory.showHistory();
            return mainList;
        }

        else if (command.toLowerCase().equals("average of oscars count")){
            helperList.add("average of oscars count");
            mainList.add(helperList);
            Hisory.push("average of oscars count");
            return mainList;
        }

        else if (command.toLowerCase().equals("min by oscars count")){
            helperList.add("min by oscars count");
            mainList.add(helperList);
            Hisory.push("min by oscars count");
            return mainList;
        }

        else if (command.contains("update")){
            helperList.add("update");
            helperList.add(command.substring(8, command.length() - 1));
            helperList.add(InitMovieCoordinates.initializeCoordinateX().toString());
            helperList.add(InitMovieCoordinates.initializeCoordinateY().toString());
            helperList.add(InitMovieCountOfOscars.initializeOscarsCount().toString());
            helperList.add(InitMovieGenre.initializeMovieGenre());
            helperList.add(InitRating.initializeMpaaRating());
            helperList.add(InitOperator.initializeName());
            helperList.add(InitOperator.initializeWeight().toString());
            helperList.add(InitOperator.initializeHairColor());
            helperList.add(InitOperator.initializeCountry());
            mainList.add(helperList);
            Hisory.push("update");
            return mainList;
        }

        if (command.toLowerCase().contains("execute script")){
            Hisory.push("execute script");
            return Execute.execute(command.substring(16, command.length()-1), user);
        }


        return mainList;
    }
}
