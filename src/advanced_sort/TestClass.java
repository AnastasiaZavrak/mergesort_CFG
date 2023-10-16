package advanced_sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestClass {
    public static void main(String[] args) {
        Comparator<Student> gradeComparator = Comparator.comparingInt(Student::getGrade);

        List<Student> studentList = new ArrayList<>();;
        studentList.add(new Student("Alice Grey", 97));
        studentList.add(new Student("Tim Brady", 50));
        studentList.add(new Student("Meredith Loon", 72));
        studentList.add(new Student("Emma Johnson", 81));
        studentList.add(new Student("Benjamin Patel", 43));
        studentList.add(new Student("Olivia Williams", 90));
        studentList.add(new Student("Liam Smith", 82));

        MergeSortIncreasing.mergeSort(studentList, gradeComparator);
        System.out.println("Students' grades in increasing order:");
        for (Student student : studentList) {
            System.out.println(student.getName() + ": " + student.getGrade());
        }
    }
}
