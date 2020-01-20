import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StudentDatabaseApp {

    public static void main(String[] args) {
        Database db = Database.getInstance();

        // student can enroll in the following courses: History 101,
        // Mathematics 101, English 101, Chemistry 101,
        // Computer Science 101
        db.addCourse(new Course("History 101", 500));
        db.addCourse(new Course("Mathematics 101", 200));
        db.addCourse(new Course("English 101", 1100));
        db.addCourse(new Course("Chemistry 101", 1500));
        db.addCourse(new Course("Computer Science 101", 100));

        System.out.println("How many students?");

        Scanner in = new Scanner(System.in);
        int numberOfStudents;
        try {
            numberOfStudents = in.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Students must be a number: ");
            numberOfStudents = in.nextInt();
        }
        for (int i = 1; i <= numberOfStudents; i++) {
            Student student = new Student(
                    "Emilia-tan ",
                    Integer.toString(i),
                    "199" + (4 + i),
                    "201" + (5 + i)
            );
            for (Course course : db.getCourses()) {
                if (Math.random() > 0.5) {
                    student.enroll(course);
                }
            }
            db.addStudent(student);
        }
        for (Student student : db.getStudents()) {
            System.out.println(student.viewStatus());
        }
    }
}
