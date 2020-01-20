import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * design pattern (?)
 */
public class Student implements UniversityMember {

    private String firstName;
    private String lastName;
    private int yearOfBirth;
    private int enrolmentYear;
    private String studentID;
    private int balance;
    private List<Course> enrolledCourses;

    public Student(
            String firstName,
            String lastName,
            String yearOfBirth,
            String enrolmentYear
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = Integer.parseInt(yearOfBirth);
        this.enrolmentYear = Integer.parseInt(enrolmentYear);
        this.balance = 0;
        this.enrolledCourses = new ArrayList<>();
        this.studentID = generateID();
    }

    // student should have 5-digit unique ID, with first number being their
    // grade level
    /**
     * generate random ID string
     * @return
     */
    @Override
    public String generateID() {
        final int ID_LENGTH = 7;
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int gradeLevel = currentYear - enrolmentYear + 1;
        String numericString = "0123456789";
        StringBuilder sb = new StringBuilder(ID_LENGTH);
        sb.append(gradeLevel);
        sb.append("-");
        for (int i = 1; i < ID_LENGTH; i++) {
            sb.append(numericString.charAt((int) Math.floor(Math.random() * numericString.length())));
        }
        return sb.toString();
    }

    @Override
    public void enroll(Course course) {
        this.enrolledCourses.add(course);
        addToBalance(course.getEnrolmentCost());
    }

    /**
     * @param amount
     * @return true if payment successful, false otherwise
     */
    @Override
    public void addToBalance(int amount) {
        this.balance += amount;
    }

    // to see status of student, we should see their name, ID, courses
    // enrolled, and balance
    @Override
    public String viewStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(this.firstName).append(" ").append(this.lastName).append("\n");
        sb.append("ID: ").append(this.studentID).append("\n");
        sb.append("Courses: ").append("\n");
        for (Course course : enrolledCourses) {
            sb.append(course.getCourseName());
            sb.append("\n");
        }
        sb.append("Balance: ").append(this.balance);
        return sb.toString();
    }

    // getters //

    public String getFirstName() { return this.firstName; }

    public String getLastName() { return this.lastName; }

    public int getDateOfBirth() { return this.yearOfBirth; }

    public int getEnrolmentDate() { return this.enrolmentYear; }

    public int getBalance() { return this.balance; }

    public String getStudentID() { return this.studentID; }

    public List<Course> getEnrolledCourses() { return enrolledCourses; }
}
