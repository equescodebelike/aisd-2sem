package task2_1;

public class Task1 {

    public static void main(String[] args) {
        Student student = new Student("Ivan", "Ivanov");

        student = randomizeMarks(student);
        System.out.println(student);

        for (int sem = 1; sem <= 10; sem++) {
            System.out.println("Average for semester " + sem + ": " + student.getMediumForSem(sem));
        }
        System.out.println();
        System.out.println("Average for all period: " + student.getMediumForAll());
    }

    public static Student randomizeMarks(Student student) {
        if (student != null) {
            for (int sem = 1; sem <= 10; sem++) {
                for (int countsubjects = 1; countsubjects <= 4; countsubjects++) { // количество предметов в семестре
                    student.addMark(sem, getRandomMark());
                }
            }
        }
        return student;
    }

    public static int getRandomMark() {
        int min = 1;
        int max = 10;
        return min + (int) (Math.random() * max);
    }
}
