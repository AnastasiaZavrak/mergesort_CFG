package advanced_sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) {
        Comparator<Student> gradeComparator = Comparator.comparingInt(Student::getGrade);
        List<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        // Add initial students to the list
        students.add(new Student("Alice Grey", 97));
        students.add(new Student("Tim Brady", 50));
        students.add(new Student("Meredith Loon", 72));
        students.add(new Student("Emma Johnson", 81));
        students.add(new Student("Benjamin Patel", 43));
        students.add(new Student("Olivia Williams", 90));
        students.add(new Student("Liam Smith", 82));

        while (isRunning) {
            System.out.println("""
                    Menu:
                    1. Add student
                    2. Print students by grade (ascending)
                    3. Print students by grade (descending)
                    4. Exit""");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // to consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student grade: ");
                    int grade = scanner.nextInt();
                    students.add(new Student(name, grade));
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    MergeSortAscending.mergeSort(students, gradeComparator);
                    printStudents(students, "ascending order");
                    break;

                case 3:
                    MergeSortDescending.mergeSort(students, gradeComparator);
                    printStudents(students, "descending order");
                    break;

                case 4:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    isRunning = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
            System.out.println();
        }
    }

    public static void printStudents(List<Student> students, String order) {
        System.out.println("Students sorted in " + order + " by grade:");
        for (Student student : students) {
            System.out.println("Name: " + student.getName() + ", Grade: " + student.getGrade());
        }
    }
}
