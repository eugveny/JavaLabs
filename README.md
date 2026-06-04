# КРОСПЛАТФОРМЕННЫЕ ТЕХНОЛОГИИ ПРОГРАММИРОВАНИЯ
## Язык программирования Java
Лабораторные работы за семестр IV (II-й курс, 2026 г.)

**Студент:** Удальцов Евгений Григорьевич  
**Группа:** БСТ2403  

---

## Список работ

| № | Название | Описание | Папка |
|---|----------|----------|-------|
| 1 | Базовый синтаксис | Простые числа, проверка слов на палиндром | [lab1/](lab1/) |
| 2 | Объектно-ориентированное программирование| Иерархия классов "Person" (Student, Teacher, Assistant) (в. 3) | [lab2/](lab2/) |
| 3 | Хэш-таблицы | Своя HashTable (метод цепочек), модель электронного склада (в. 5) | [lab3/](lab3/) |
| 4 | Обработка исключений | Расчет среднего арифметического, FileCopy (в. 2), кастомный Exception (в. 6) | [lab4/](lab4/) |
| 5 | Регулярные выражения | Валидация IP и паролей, поиск чисел и слов, camelCase замена | [lab5/](lab5/) |
| 6 | Коллекции | Топ-10 слов в файле, кастомный Stack, учёт продаж в магазине | [lab6/](lab6/) |
| 7 | Многопоточность | Сумма массива (в. 2), поиск максимума в матрице (в. 2), барьер грузчиков (в. 2) | [lab7/](lab7/) |
| 8 | Аннотации и рефлексия | Конвейер обработки данных через Reflection API и Stream API | [lab8/](lab8/) |

---

## Как запустить любую работу

Запуск всех программ выполняется из **корневой папки** репозитория (`JavaLabs`), так как в файлах прописаны пакеты `package JavaLabs.labX`.

1. Скомпилируйте нужную лабораторную (например, первую):
   ```bash
   javac lab1/*.java

2. Запустите целевой класс через имя пакета:
    ```bash
    java JavaLabs.lab1.Primes

## Структура репозитория

```text
JavaLabs/
├── README.md
├── .gitignore
├── lab1/
│   ├── Primes.java
│   ├── Palindrome.java
│   └── README.md
├── lab2/
│   ├── Person.java
│   ├── Student.java
│   ├── Teacher.java
│   ├── TeacherAssistant.java
│   ├── Main.java
│   └── README.md
├── lab3/
│   ├── Entry.java
│   ├── HashTable.java
│   ├── Product.java
│   ├── Warehouse.java
│   ├── Main.java
│   └── README.md
├── lab4/
│   ├── ArrayAverage.java
│   ├── FileCopy.java
│   ├── CustomInputMismatchException.java
│   ├── CustomExceptionLab.java
│   ├── input.txt
│   ├── error_log.txt
│   └── README.md
├── lab5/
│   ├── NumberFinder.java
│   ├── PasswordCheck.java
│   ├── CaseHighlighter.java
│   ├── IPValidator.java
│   ├── StartingLetterFinder.java
│   └── README.md
├── lab6/
│   ├── TopWords.java
│   ├── Stack.java
│   ├── StoreSales.java
│   ├── Main.java
│   ├── text.txt
│   └── README.md
├── lab7/
│   ├── ArraySumCalculator.java
│   ├── MatrixMaxFinder.java
│   ├── WarehouseTransfer.java
│   └── README.md
└── lab8/
    ├── DataProcessor.java
    ├── FilterProcessor.java
    ├── TransformProcessor.java
    ├── SortProcessor.java
    ├── DataManager.java
    ├── Main.java
    ├── input.txt
    └── README.md
