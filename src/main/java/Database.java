import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Database {

    private int numberOfStudents;
    private List<Student> students;
    private List<String> courses;
    private int costOfCourse = 600;

    private Database() {
        System.out.println("How many students?");
        Scanner in = new Scanner(System.in);
        try {
            numberOfStudents = in.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Students must be a number: ");
            numberOfStudents = in.nextInt();
        }
        for (int i = 0; i < numberOfStudents; i++) {

        }
    }

    private static class DatabaseHolder {
        public static final Database instance = new Database();
    }

    public static Database getInstance() {
        return DatabaseHolder.instance;
    }
    // constructor: ask the user how many new students will be added to the database
    // prompt the user to enter name and year for each student

}
