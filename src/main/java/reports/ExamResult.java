package reports;

public class ExamResult {


    private String lastName;


    private String subjectName;


    private int grade;

    public ExamResult(String lastName, String subjectName, int grade) {
        this.lastName = lastName;
        this.subjectName = subjectName;
        this.grade = grade;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "ExamResult{" +
                "lastName='" + lastName + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", grade=" + grade +
                "}\n";
    }
}
