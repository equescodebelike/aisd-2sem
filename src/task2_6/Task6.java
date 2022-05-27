package task2_6;

import util.hash.SimpleHashMap;

import java.util.HashMap;

public class Task6 {

    public static void main(String[] args) {
        String file = "C:\\Users\\hahuibala\\Desktop\\Coding\\vsu\\aisd-2sem\\src\\task2_6\\example.txt"; // ! укажите собственный путь к файлу
        HashMap<String, Integer> map = new HashMap<>(); // Java HashMap
        SimpleHashMap<String, Integer> map2 = new SimpleHashMap<>(file.length()); // собственная реализация
        System.out.println("HashMap Java");
        System.out.println(JavaMapAbbrev.jSearch(map, file));
        System.out.println("-----------------------------------------");
        System.out.println("HashMap Custom");
        System.out.println(CustomMapAbbrev.cSearch(map2, file));
    }

}
