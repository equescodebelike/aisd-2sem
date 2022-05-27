package task2_6;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class Task6 {

    public static void main(String[] args) throws FileNotFoundException {
        HashMap<String, Integer> map = new HashMap<>();
        String file = "C:\\Users\\hahuibala\\Desktop\\Coding\\vsu\\aisd-2sem\\src\\task2_6\\example.txt";
        System.out.println(JavaMapAbbrev.jSearch(map, file));
    }

}
