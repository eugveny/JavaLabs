// main, вариант 2
package JavaLabs.lab2;

public class Main {

    public static void main(String[] args) {

        Student student = new Student(
                "Евгений",
                23,
                "Мужской",
                "МТУСИ",
                2,
                3.7
        );

        Teacher teacher = new Teacher(
                "Егор",
                52,
                "Мужской",
                "Программирование",
                "ИТ",
                32
        );

        TeacherAssistant assistant = new TeacherAssistant(
                "Анна",
                21,
                "Женский",
                "МТУСИ",
                4,
                4.9,
                "Java",
                20,
                17000
        );

        System.out.println("СТУДЕНТ");
        student.showInfo();
        student.work();
        student.study();
        student.study("Java");

        System.out.println();

        System.out.println("ПРЕПОДАВАТЕЛЬ");
        teacher.showInfo();
        teacher.work();

        System.out.println();

        System.out.println("АССИСТЕНТ");
        assistant.showInfo();
        assistant.work();

        System.out.println();

        Person p = assistant; // upcasting
        p.work();

        if (p instanceof TeacherAssistant) {
            TeacherAssistant ta = (TeacherAssistant) p; // downcasting
            System.out.println("Downcasting выполнен успешно.");
            ta.work();
        }

        System.out.println();
        System.out.println("Всего создано объектов Person: "
                + Person.getPersonCount());
    }
}