import java.util.Arrays;

public class HelloWorld {

    // Задача 1: Вывод массива в консоль без Arrays
    public static void printArray(int[] numbers) {
        if (numbers.length == 0) {
            System.out.print("{}");
            return;
        }
        System.out.print("{");
        for (int i = 0; i < numbers.length; i++) {
            if (i == numbers.length - 1) {
                System.out.print(numbers[i]);
            } else {
                System.out.print(numbers[i] + ",");
            }
        }
        System.out.print("}");
    }

    // Задача 2: Взятие части массива (метод getSubArrayBetween)
    public static int[] getSubArrayBetween(int[] numbers, int start, int end) {
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] >= start && numbers[i] <= end) {
                count++;
            }
        }
        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] >= start && numbers[i] <= end) {
                result[index] = numbers[i];
                index++;
            }
        }
        return result;
    }

    // Задача 3: Получение средних элементов массива (метод getMiddle)
    public static int[] getMiddle(int[] numbers) {
        int length = numbers.length;
        if (length % 2 == 0) {
            int left = length / 2 - 1;
            int right = length / 2;
            int[] result = {numbers[left], numbers[right]};
            return result;
        } else {
            int mid = length / 2;
            int[] result = {numbers[mid]};
            return result;
        }
    }

    // Задача 4: Слияние и сортировка двух массивов
    public static int[] mergeAndSort(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];

        for (int i = 0; i < first.length; i++) {
            result[i] = first[i];
        }

        for (int i = 0; i < second.length; i++) {
            result[first.length + i] = second[i];
        }

        // Пузырьковая сортировка
        for (int i = 0; i < result.length - 1; i++) {
            for (int j = 0; j < result.length - 1 - i; j++) {
                if (result[j] > result[j + 1]) {
                    int temp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = temp;
                }
            }
        }
        return result;
    }

    // Задача 5: Вывод только нечётных чисел
    public static void printOddNumbers(int[] arr) {
        boolean first = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                if (first) {
                    System.out.print(arr[i]);
                    first = false;
                } else {
                    System.out.print(", " + arr[i]);
                }
            }
        }
        System.out.println(); // Добавил перевод строки
    }

    // Главный метод main для тестирования всех задач
    public static void main(String[] args) {
        System.out.println("=== Задача 1: Вывод массива ===");
        int[] testArray1 = {1, 2, 3, 4, 5};
        System.out.print("Массив: ");
        printArray(testArray1);
        System.out.println();

        int[] testArray2 = {};
        System.out.print("Пустой массив: ");
        printArray(testArray2);
        System.out.println();
        System.out.println();

        System.out.println("=== Задача 2: Взятие части массива ===");
        int[] arr = {1, 3, 5, 6, 9, 11, 24};
        int[] result = getSubArrayBetween(arr, 4, 10);
        System.out.print("Исходный массив: ");
        printArray(arr);
        System.out.println();
        System.out.print("Подмассив от 4 до 10: ");
        printArray(result); // Использовал printArray для единообразия
        System.out.println();
        System.out.println();

        System.out.println("=== Задача 3: Получение средних элементов ===");
        int[] arr1 = {1, 5, 2, 17};
        int[] result1 = getMiddle(arr1);
        System.out.println("Массив: " + Arrays.toString(arr1) + " → " + Arrays.toString(result1));

        int[] arr2 = {14, 16, 3};
        int[] result2 = getMiddle(arr2);
        System.out.println("Массив: " + Arrays.toString(arr2) + " → " + Arrays.toString(result2));
        System.out.println();

        System.out.println("=== Задача 4: Слияние и сортировка ===");
        int[] first = {1, 3, 7, 5};
        int[] second = {8, 4, 2, 4};
        int[] mergedResult = mergeAndSort(first, second);
        System.out.println("Первый массив: " + Arrays.toString(first));
        System.out.println("Второй массив: " + Arrays.toString(second));
        System.out.println("Результат слияния и сортировки: " + Arrays.toString(mergedResult));
        System.out.println();

        System.out.println("=== Задача 5: Вывод нечётных чисел ===");
        int[] oddArray = {3, 5, 20, 8, 7, 3, 100};
        System.out.print("Массив: " + Arrays.toString(oddArray) + " → ");
        printOddNumbers(oddArray);
    }
}