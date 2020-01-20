import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Database {

    private List<Student> students;
    private List<Course> courses;

    private Database() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
    }

    // add //

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    // remove //

    public boolean removeStudent(String studentID) {
        for (Student student : students) {
            if (student.getStudentID().equals(studentID)) {
                students.remove(student);
                return true;
            }
        }
        return false;
    }

    public boolean removeCourse(String courseID) {
        for (Course course : courses) {
            if (course.getCourseID().equals(courseID)) {
                courses.remove(course);
                return true;
            }
        }
        return false;
    }

    public int getStudentsSize() { return students.size(); }

    public int getCoursesSize() { return courses.size(); }

    // ??????????????
    // only for test, pls don't sue me for bad code
    public List<Course> getCourses() { return courses; }

    // only for test, pls don't sue me for bad code
    public List<Student> getStudents() { return students; }

    private static class DatabaseHolder {
        public static final Database instance = new Database();
    }

    public static Database getInstance() {
        return DatabaseHolder.instance;
    }
    // constructor: ask the user how many new students will be added to the database
    // prompt the user to enter name and year for each student

}
