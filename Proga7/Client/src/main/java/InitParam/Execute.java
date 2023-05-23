package InitParam;

import Authorization.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Execute {
    public static ArrayList<ArrayList<String>>execute(String path, User user){
        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            System.out.println("Привет");
        }
        String lines[] = content.split("\\r?\\n");
        ArrayList<String> startList = new ArrayList<>(Arrays.asList(lines));
        ArrayList<ArrayList<String>> mainList = new ArrayList<>();
        String[] array = new String[1024];
        int counter = 0;
        for (String string : startList){
            if (string.contains("execute script")){
                string = string.substring(16, string.length()-1);
                mainList.addAll(execute(string, user));
                if (mainList.size() >=33){
                    break;
                }
                continue;
            }
            else if (string.equals("show") || string.equals("info") || string.equals("add") || string.equals("print field ascending genre")
                    || string.equals("clear") || string.contains("remove by id") || string.contains("update") || string.equals("remove lower")
                    || string.equals("history") || string.equals("average of oscars count") || string.equals("min by oscars count") || string.equals("help")){

                if (array.length >= 1){
                    ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(array));
                    arrayList.removeAll(Collections.singleton(null));
                    mainList.add(arrayList);
                    if (mainList.size() >= 128){
                        break;
                    }
                    array = new String[1024 * 16];
                }
                array[counter] = user.getName();
                counter+=1;
                array[counter] = user.getPassword();
                counter+=1;
                array[counter] = string;
                counter += 1;
            }
            else{
                array[counter] = string;
                counter += 1;
            }
        }
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(array));
        arrayList.removeAll(Collections.singleton(null));
        mainList.add(arrayList);
        mainList.remove(0);
        mainList.remove(mainList.size() - 1);
        return mainList;
    }


}
