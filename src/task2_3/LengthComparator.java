package task2_3;

import java.util.Comparator;

public class LengthComparator implements Comparator<String> {
    @Override
    public int compare(String x, String y) {
        return Integer.compare(x.length(), y.length());
    }
}