package task2_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {

    private final Map<Integer, List<Integer>> marks; // key - семестр, value list - оценки за семестр
    private final String name;
    private final String surname;

    public Student(String name, String surname) {
        this.marks = new HashMap<>();
        this.name = name;
        this.surname = surname;
    }

    public void addMark(int sem, int mark) { // добавить оценку за семестр
        if (marks.get(sem) == null) {
            List<Integer> list = new ArrayList<>();
            list.add(mark);
            marks.put(sem, list);
            return;
        }
        marks.get(sem).add(mark);
    }

    public double getMediumForSem(int sem) { // среднее значение за семестр
        double sum = 0;
        for (int c : marks.get(sem)) {
            sum += c;
        }
        return sum / marks.get(sem).size();
    }

    public double getMediumForAll() { // среднее значение за все семестры
        double sum = 0;
        double countMark = 0;
        for (List<Integer> list : marks.values()) {
            for (int c : list) {
                sum += c;
            }
            countMark += list.size();
        }
        return sum / countMark;
    }

    public String toString() {
        String s = "";
        s += "Name: " + this.name + "\n";
        s += "Surname: " + this.surname + "\n";
        for (Map.Entry<Integer, List<Integer>> sem : this.marks.entrySet()) {
            s += "Semester: " + sem.getKey() + "\n";
            if (!sem.getValue().isEmpty()) {
                for (int marks : sem.getValue()) {
                    s += "Mark: " + marks + "\n";
                }
            }
        }
        return s;
    }
}
