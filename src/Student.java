public class Student extends Person{
    // Instance variable
    private int grade;
    // Constructor
    public Student(String firstName, String lastName, String phoneNumber, int grade) {
        super(firstName, lastName, phoneNumber);
        this.grade = grade;
    }
    // Methods
    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String toString() {
        return super.toString() + " Grade: " + grade;
    }
}
