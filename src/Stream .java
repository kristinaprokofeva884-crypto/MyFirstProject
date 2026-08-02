import java.math.BigInteger;
import java.util.stream.LongStream;

class Factorial {

    // Метод для вычисления факториала через Stream API
    public static BigInteger factorial(int value) {
        // Проверяем особый случай: 0! = 1 по определению
        if (value == 0) {
            return BigInteger.ONE;
        }

        // Создаем поток чисел от 1 до value включительно
        // .mapToObj() преобразует каждое long в BigInteger
        // .reduce() перемножает все числа между собой
        return LongStream.rangeClosed(1, value) //  1, 2, 3, 4, 5
                .mapToObj(BigInteger::valueOf) // BigInteger(1), BigInteger(2)...
                .reduce(BigInteger.ONE, BigInteger::multiply); //начинаем с 1//Затем перемножаем: 1×1×2×3×4×5 = 120
    }

    //Главный метод для тестирования
    public static void main(String[] args) {
        // Тестируем факториал разных чисел

        System.out.println("ФАКТОРИАЛЫ ЧИСЕЛ:");
        System.out.println("0! = " + factorial(0));   // 1
        System.out.println("1! = " + factorial(1));   // 1
        System.out.println("3! = " + factorial(3));   // 6  (1×2×3=6)
        System.out.println("5! = " + factorial(5));   // 120 (1×2×3×4×5=120)
    }
}