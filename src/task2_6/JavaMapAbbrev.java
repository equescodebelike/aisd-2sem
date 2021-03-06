package task2_6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaMapAbbrev {
    public static String jSearch(HashMap<String, Integer> map, String file) {
        String result = "";

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                String regEx = "\\b[\\p{Lu}.]{2,5}\\b";
                Pattern pattern = Pattern.compile(regEx);
                Matcher matcher = pattern.matcher(line);
                List<String> abbrevs = new ArrayList<>();
                while (matcher.find()) {
                    abbrevs.add(matcher.group());
                }
                for (String abb : abbrevs) {
                    if (map.containsKey(abb)) {
                        map.put(abb, (map.get(abb)) + 1);
                    } else {
                        map.put(abb, 1);
                    }
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String abb : map.keySet()) {
            result += abb + " " + map.get(abb) + " time(s) ; ";
        }
        return result;
    }
}
