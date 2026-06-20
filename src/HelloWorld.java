import java.math.BigInteger;

public class HelloWorld {

    // ЗАДАЧА 1: switch (строки)
    public static boolean isWeekend(String weekday) {
        switch (weekday) {
            case "Saturday":
            case "Sunday":
                return true;
            default:
                return false;
        }
    }

    // ЗАДАЧА 2: if/else (числа)
    public static boolean isWeekend(int weekDayNumber) {
        if (weekDayNumber == 6 || weekDayNumber == 7) {
            return true;
        } else {
            return false;
        }
    }

    // ЗАДАЧА 3: тернарный оператор
    public static String checkWeekend(String weekday) {
        return weekday.equals("Saturday") || weekday.equals("Sunday")
                ? "Ура, выходной!"
                : "Надо ещё поработать";
    }

    // ЗАДАЧА 4: определение группы
    public static int determineGroup(int age) {
        if (age < 7 || age > 65) return -1;
        if (age >= 7 && age <= 13) return 1;
        if (age >= 14 && age <= 17) return 2;
        if (age >= 18 && age <= 65) return 3;
        return -1;
    }

    // ЗАДАЧА 5: факториал
    public static BigInteger factorial(int value) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= value; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("=== Задача 1: switch ===");
        System.out.println(isWeekend("Saturday"));
        System.out.println(isWeekend("Sunday"));
        System.out.println(isWeekend("Monday"));

        System.out.println("\n=== Задача 2: if/else ===");
        System.out.println(isWeekend(6));
        System.out.println(isWeekend(7));
        System.out.println(isWeekend(1));

        System.out.println("\n=== Задача 3: тернарный ===");
        System.out.println(checkWeekend("Saturday"));
        System.out.println(checkWeekend("Sunday"));
        System.out.println(checkWeekend("Monday"));

        System.out.println("\n=== Задача 4: группа ===");
        System.out.println(determineGroup(10));
        System.out.println(determineGroup(15));
        System.out.println(determineGroup(20));
        System.out.println(determineGroup(5));

        System.out.println("\n=== Задача 5: факториал ===");
        System.out.println(factorial(1));
        System.out.println(factorial(3));
        System.out.println(factorial(5));
    }
}