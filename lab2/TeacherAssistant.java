package JavaLabs.lab2;

public class TeacherAssistant extends Student {

    private String discipline;
    private int workHours;
    private double salary;

    public TeacherAssistant() {
        super();
        discipline = "Не указана";
        workHours = 0;
        salary = 0;
    }

    public TeacherAssistant(String name, int age, String gender,
                             String university, int course, double averageGrade,
                             String discipline, int workHours, double salary) {

        super(name, age, gender, university, course, averageGrade);

        this.discipline = discipline;
        this.workHours = workHours;
        this.salary = salary;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public void work() {
        System.out.println(getName() +
                " помогает преподавателю по дисциплине " + discipline);
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Дисциплина: " + discipline);
        System.out.println("Часы работы: " + workHours);
        System.out.println("Зарплата: " + salary);
    }
}
