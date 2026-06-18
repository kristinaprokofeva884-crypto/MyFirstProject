public class HelloWorld {
    public static void main(String[] args) {
        // Проверка метода charExpression
        char result = charExpression(5);
        System.out.println("Символ после 'a' на расстоянии 5: " + result); // 'f'

        char result2 = charExpression(0);
        System.out.println("Символ после 'a' на расстоянии 0: " + result2);

        char result3 = charExpression(25);
        System.out.println("Символ после 'a' на расстоянии 25: " + result3);
    }

    //ЗАДАЧА 1.3.3: Символ Unicod
    public static char charExpression(int a) {
return(char)('a'+ a);
}
}


