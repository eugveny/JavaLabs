// вариант 2
package JavaLabs.lab2;

public abstract class Person {

    private String name;
    private int age;
    private String gender;

    protected static int personCount = 0;

    public Person() {
        this("Неизвестно", 0, "Неизвестно");
    }

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        personCount++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public static int getPersonCount() {
        return personCount;
    }

    public abstract void work();

    public void showInfo() {
        System.out.println("Имя: " + name);
        System.out.println("Возраст: " + age);
        System.out.println("Пол: " + gender);
    }
}