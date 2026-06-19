public class HelloWorld {
    public static void main(String[] args) {
        // Проверка метода charExpression
        char result = charExpression(5);
        System.out.println("Символ после 'а' на расстоянии 5: " + result);

        char result2 = charExpression(0);
        System.out.println("Символ после 'а' на расстоянии 0: " + result2);

        char result3 = charExpression(25);
        System.out.println("Символ после 'а' на расстоянии 25: " + result3);

        // Проверка задачи 2: Разница в возрасте
        byte diff1 = getAgeDiff((byte)2, (byte)5);
        System.out.println("Разница между 2 и 5: " + diff1);

        byte diff2 = getAgeDiff((byte)4, (byte)1);
        System.out.println("Разница между 4 и 1: " + diff2);

        byte diff3 = getAgeDiff((byte)10, (byte)10);
        System.out.println("Разница между 10 и 10: " + diff3);
    }

    // ЗАДАЧА 1: Символ Unicode
    public static char charExpression(int a) {
        return (char) ('a' + a);
    }

    // ЗАДАЧА 2: Разница в возрасте
    public static byte getAgeDiff(byte age1, byte age2) {
        if (age1 > age2) {
            return (byte) (age1 - age2);
        } else {
            return (byte) (age2 - age1);
        }
    }
}