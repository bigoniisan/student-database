public interface UniversityMember {

    String generateID();

    void enroll(Course course);

    /**
     *
     * @param amount
     * @return true if payment successful, false otherwise
     */
    void addToBalance(int amount);

    String viewStatus();

}
