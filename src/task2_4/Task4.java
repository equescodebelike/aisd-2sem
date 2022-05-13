package task2_4;

import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        final Student[] studentsArr = new Student[9];
        studentsArr[0] = new Student(1, 2, "Petrov");
        studentsArr[1] = new Student(1, 3, "Ivanov");
        studentsArr[2] = new Student(2, 2, "Vodkin");
        studentsArr[3] = new Student(2, 2, "Leskov");
        studentsArr[4] = new Student(3, 10, "Sidorkin");
        studentsArr[5] = new Student(3, 2, "Vlasenkov");
        studentsArr[6] = new Student(1, 1, "Detkov");
        studentsArr[7] = new Student(1, 1, "Shishkov");
        studentsArr[8] = new Student(2, 7, "Orlov");

        System.out.println("---------Unsorted--------");

        for (Student currStudent : studentsArr) {
            System.out.println(currStudent);
        }

        System.out.println("---------Sorted--------");
        Arrays.sort(studentsArr);

        for (Student currStudent : studentsArr) {
            System.out.println(currStudent);
        }
    }
}
