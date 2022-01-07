package LA2Q2;

//creating class and implementing the Comparable interface
public class StudentGrade implements Comparable<StudentGrade>{
    //creating three private variables
    private String firstName;
    private String lastName;
    private Integer grades;
    //constructor for the three variables
    public StudentGrade(String firstName, String lastName, Integer grades) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grades = grades;
    }
    //setters and getters for the three variables
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setGrades(Integer grades) {
        this.grades = grades;
    }
    public Integer getGrades() {
        return grades;
    }
    //toString method to print the three variables in a proper format
    @Override
    public String toString() {
        return String.format("%10s %-6s\t:\t%d%n", firstName, lastName, grades);
    }
    //compareTo method that compares the grades of 2 students
    @Override
    public int compareTo(StudentGrade studentGrade) {
        return this.grades.compareTo(studentGrade.grades);
    }
}