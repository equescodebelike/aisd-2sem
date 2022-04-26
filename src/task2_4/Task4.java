package task2_4;

import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        final Student[] studentsArr = new Student[10];
        studentsArr[0] = new Student(1, 2, "Petrov");
        studentsArr[1] = new Student(2, 1, "Vasechkin");
        studentsArr[2] = new Student(1, 3, "Ivanov");
        studentsArr[3] = new Student(2, 2, "Leskov");
        studentsArr[4] = new Student(1, 1, "Astman");
        studentsArr[5] = new Student(3, 10, "Sidorkin");
        studentsArr[6] = new Student(3, 2, "Vlasenkov");
        studentsArr[7] = new Student(3, 1, "Shihman");
        studentsArr[8] = new Student(1, 1, "Detkov");
        studentsArr[9] = new Student(2, 7, "Orlov");

        System.out.println("---------Unsorted array--------");

        for (Student currStudent : studentsArr) {
            System.out.println(currStudent);
        }

        System.out.println("---------Sorted array--------");
        Arrays.sort(studentsArr);

        for (Student currStudent : studentsArr) {
            System.out.println(currStudent);
        }
    }
}
