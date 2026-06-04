package Java.lab2;

public class Student extends Person {

    private String university;
    private int course;
    private double averageGrade;

    public Student() {
        super();
        university = "Не указан";
        course = 1;
        averageGrade = 0.0;
    }

    public Student(String name, int age, String gender,
                   String university, int course, double averageGrade) {

        super(name, age, gender);
        this.university = university;
        this.course = course;
        this.averageGrade = averageGrade;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Override
    public void work() {
        System.out.println(getName() + " учится в университете.");
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Университет: " + university);
        System.out.println("Курс: " + course);
        System.out.println("Средний балл: " + averageGrade);
    }

    // Перегрузка метода
    public void study() {
        System.out.println(getName() + " изучает предметы.");
    }

    public void study(String subject) {
        System.out.println(getName() + " изучает предмет: " + subject);
    }
}