package task2_4;

public class Student implements Comparable<Student> {
    private final int course;
    private final int group;
    private final String surname;

    public Student(int course, int group, String surname) {
        this.course = course;
        this.group = group;
        this.surname = surname;
    }

    public int getCourse() {
        return course;
    }

    public int getGroup() {
        return group;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "course=" + course +
                ", group=" + group +
                ", surname='" + surname + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        if (course < o.getCourse()) {
            return -1;
        }

        if (course > o.getCourse()) {
            return 1;
        }

        if (group < o.getGroup()) {
            return -1;
        }

        if (group > o.getGroup()) {
            return 1;
        }

        return surname.compareTo(o.getSurname());
    }
}