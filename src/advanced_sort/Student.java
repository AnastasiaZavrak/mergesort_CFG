package advanced_sort;

public class Student implements Comparable<Student>{
    private final String name;
    private final int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.grade, o.grade);
    }
}
