package task2_3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Task3 {
    public static void main(String[] args) throws Exception {
        String[] s = new String[]{"3", "4234", "fsdfsdfgsdfg", "rrr"};
        CustomPQ.Node pq = setCustomPQueue(s);

        /* while (PriorityQueue.isEmpty(pq) == 0) {
            System.out.println(PriorityQueue.peek(pq));
            pq = PriorityQueue.pop(pq);
        } */
        String[] s2 = customConvert(pq);
        for (int i = 0; i < s2.length; i++) {
            System.out.println(s2[i]);
        }

        String[] s4 = new String[]{};
        PriorityQueue<String> javaPQ = setJavaPQueue(s4);
        String[] s3 = javaConvert(javaPQ);
        for (int i = 0; i < s3.length; i++) {
            System.out.println(s3[i]);
        }


    }

    public static CustomPQ.Node setCustomPQueue(String[] entry) throws Exception { // на основе связного списка
        sort(entry);
        if (entry.length == 0) {
            throw new Exception("Empty array");
        }
        CustomPQ.Node pq = CustomPQ.newNode(entry[0], 0);
        for (int i = 1; i < entry.length; i++) { // т.к. массив уже отсортирован, то приоритет задается порядком слов
            pq = CustomPQ.push(pq, entry[i], i);
        }
        return pq;
    }

    public static PriorityQueue<String> setJavaPQueue(String[] entry) { // реализация стандартной библиотеки
        Comparator<String> comparator = new LengthComparator();
        PriorityQueue<String> pq = new PriorityQueue<>(comparator); // для сравнения длины используем компаратор
        pq.addAll(Arrays.asList(entry));
        return pq;
    }

    public static String[] customConvert(CustomPQ.Node pq) { // конвертация кастомной очереди обратно в массив
        String[] s = new String[CustomPQ.getSize()];
        for (int i = 0; i < s.length; i++) {
            s[i] = CustomPQ.peek(pq);
            pq = CustomPQ.pop(pq);
        }
        return s;
    }

    public static String[] javaConvert(PriorityQueue<String> pq) { // конвертация джава очереди обратно в массив
        String[] s = new String[pq.size()];
        for (int i = 0; i < s.length; i++) {
            s[i] = pq.poll();
        }
        return s;
    }

    public static void sort(String[] data) { // сортировка массива для кастомной очереди методом пузырька
        int size = data.length;
        for (int i = 1; i < size - 1; i++) {
            for (int j = size - 1; j >= i; j--) {
                if (data[j - 1].length() > data[j].length()) {
                    String temp = data[j - 1];
                    data[j - 1] = data[j];
                    data[j] = temp;
                }
            }
        }
    }

}
