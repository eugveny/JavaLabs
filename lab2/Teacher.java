package JavaLabs.lab2;

public class Teacher extends Person {

    private String subject;
    private String department;
    private int experience;

    public Teacher() {
        super();
        subject = "Не указан";
        department = "Не указана";
        experience = 0;
    }

    public Teacher(String name, int age, String gender,
                   String subject, String department, int experience) {

        super(name, age, gender);
        this.subject = subject;
        this.department = department;
        this.experience = experience;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public void work() {
        System.out.println(getName() + " преподает предмет " + subject);
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Предмет: " + subject);
        System.out.println("Кафедра: " + department);
        System.out.println("Стаж: " + experience + " лет");
    }
}