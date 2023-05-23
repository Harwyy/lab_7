package WorkWithCommand;

import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeSet;

public class Hisory {
    public static Stack<String> stack = new Stack<>();
    public static void push(String str){
        if (stack.size() == 10){
            stack.remove(0);
        }
        stack.push(str);
    }
    public static void showHistory(){
        int counter = 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : stack){
            stringBuilder.append(counter + ") " + string + "\n");
            counter += 1;
        }
        String str = stringBuilder.toString();
        System.out.print(str.substring(0, str.length()-1));
    }
}
