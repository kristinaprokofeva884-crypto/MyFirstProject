public class HelloWorld {

    // Задача 2: Парсинг числа и деление
    public static void parseAndPrintNumber(String number) {
        try {
            int num = Integer.parseInt(number);
            System.out.println(num / 2);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: неверный формат числа");
        }
    }

    // Задача 3: Палиндром
    public static boolean isPalindrome(String text) {
        // Очищаем строку: оставляем только буквы и цифры, приводим к нижнему регистру
        String cleaned = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Проверяем, является ли очищенная строка палиндромом
        int left = 0;
        int right = cleaned.length() - 1;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Задача 4: Проверка электронной почты
    public static boolean isGmailOrOutlook(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }

        // Проверяем, что email содержит @ и не начинается с @
        int atIndex = email.indexOf('@');
        if (atIndex <= 0 || atIndex >= email.length() - 1) {
            return false;
        }

        // Проверяем, что до @ только буквы и цифры
        String localPart = email.substring(0, atIndex);
        if (!localPart.matches("[a-zA-Z0-9]+")) {
            return false;
        }

        // Проверяем домен
        String domain = email.substring(atIndex + 1);
        return domain.equalsIgnoreCase("gmail.com") ||
                domain.equalsIgnoreCase("outlook.com");
    }

    public static void main(String[] args) {
        // Задача 1: Объявление строки
        System.out.println("=== Задача 1: Объявление строки ===");
        String name = "Анна"; // замените на свое имя
        System.out.println(name);
        System.out.println();

        // Задача 2: Парсинг числа и деление
        System.out.println("=== Задача 2: Парсинг числа и деление ===");
        parseAndPrintNumber("64");  // Вывод: 32
        parseAndPrintNumber("111"); // Вывод: 55
        System.out.println();

        // Задача 3: Палиндром
        System.out.println("=== Задача 3: Палиндром ===");
        System.out.println(isPalindrome("Это был кот, которого я видел?")); // true
        System.out.println(isPalindrome("hello")); // false
        System.out.println(isPalindrome("А роза упала на лапу Азора")); // true
        System.out.println();

        // Задача 4: Проверка электронной почты
        System.out.println("=== Задача 4: Проверка электронной почты ===");
        System.out.println(isGmailOrOutlook("kata12@gmail.com")); // true
        System.out.println(isGmailOrOutlook("@outlook.com")); // false
        System.out.println(isGmailOrOutlook("user@outlook.com")); // true
        System.out.println(isGmailOrOutlook("user@yahoo.com")); // false
        System.out.println(isGmailOrOutlook("user!@gmail.com")); // false
    }
}