public class HelloWorld {
public static void printArray(int[] numbers) {
    if(numbers.length == 0) {
        System.out.print("{}");
        return;
        }
        System.out.print("{");
    for(int i = 0; i < numbers.length; i++) {
        if (i == numbers.length - 1) {
            System.out.print(numbers[i]);
        } else {
            System.out.print(numbers[i] + ",");
        }
    }
    System.out.print("}");
    }