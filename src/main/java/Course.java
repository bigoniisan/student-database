public class Course {

    private String courseName;
    private String courseID;
    private int enrolmentCost;

    public Course(String courseName, int enrolmentCost) {
        this.courseName = courseName;
        this.enrolmentCost = enrolmentCost;
        this.courseID = generateCourseID();
    }

    public String getCourseName() {
        return this.courseName;
    }

    // generates IDs length 6 with first 2 and last 1 letters of word, and number
    // Chemistry 101
    public String generateCourseID() {
        StringBuilder sb = new StringBuilder(6);
        String courseTitle = courseName.split(" ")[0].toUpperCase();
        String courseNumberCode = courseName.split(" ")[1];
        sb.append(courseName.charAt(0));
        sb.append(courseName.charAt(1));
        sb.append(courseTitle.charAt(courseTitle.length() - 1)); // get end of courseTitle
        sb.append(courseNumberCode);
        return sb.toString();
    }

    public int getEnrolmentCost() { return this.enrolmentCost; }

    public String getCourseID() { return this.courseID; }
}
