import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * builder design pattern (?)
 */
public class Student implements UniversityMember {

    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Date enrolmentDate;
    private String studentID;
    private int balance;
    private List<Course> enrolledCourses;

    public Student(
            String firstName,
            String lastName,
            Date dateOfBirth,
            Date enrolmentDate,
            int balance
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.enrolmentDate = enrolmentDate;
        this.balance = balance;
        this.enrolledCourses = new ArrayList<>();
    }

    // student should have 5-digit unique ID, with first number being their
    // grade level
    /**
     * generate random ID string
     * @return
     */
    @Override
    public String generateID() {
        return null;
    }

    // student can enroll in the following courses: History 101,
    // Mathematics 101, English 101, Chemistry 101,
    // Computer Science 101
    @Override
    public void enroll(Course course) {
        this.enrolledCourses.add(course);
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
        return null;
    }

    // getters //

    public String getFirstName() { return this.firstName; }

    public String getLastName() { return this.lastName; }

    public Date getDateOfBirth() { return this.dateOfBirth; }

    public Date getEnrolmentDate() { return this.enrolmentDate; }

    public int getBalance() { return this.balance; }

    public List<Course> getEnrolledCourses() { return enrolledCourses; }
}
