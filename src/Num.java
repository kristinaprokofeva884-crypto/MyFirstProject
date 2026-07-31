//Задача с ссылкой на метод
// СОЗДАЁМ ФУНКЦИОНАЛЬНЫЙ ИНТЕРФЕЙС
@FunctionalInterface
interface Number2Generator<T extends Number> {
    boolean cond(T num);
}
// ГЛАВНЫЙ КЛАСС
    class MyGenerator3 {
    // Статический метод для проверки(Нужен для передачи ссылки)
    public static boolean cond(Number n) {
        return n.intValue() > 0;
    }
    public static NumberGenerator<? super Number> getGenerator() {
        //Синтаксис если используеи ::(ссылку)
        //MyGenerator3 - класс
        //cond - ссылка на метод в этом классе
        return MyGenerator3 ::cond;
    }
    // ТЕСТИРОВАНИЕ
    public static void main(String[] args) {
        System.out.println("ТЕСТИРУЕМ РАЗНЫЕ ЧИСЛА");
        NumberGenerator<? super Number> generator = getGenerator();
        System.out.println("Число 5 > 0? " + generator.cond(5));       // true
        System.out.println("Число -3 > 0? " + generator.cond(-3));     // false
        System.out.println("Число 0 > 0? " + generator.cond(0));       // false
    }
}
