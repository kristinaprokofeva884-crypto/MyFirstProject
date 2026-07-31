@FunctionalInterface
interface NumberGenerator<T extends Number> {
    boolean cond(T num);  // ← метод, который нужно реализовать
}
//Создаю класс отдельный класс,которому через implements переадаю класс(где лежит метод,который нужен
//для реализации проверки)
    class Generattor implements NumberGenerator<Number> {
    @Override
    public boolean cond(Number n) {
        return n.intValue() > 0;
    }
}
    class MyGenerator4 {
    public static NumberGenerator<? super Number> getGenerator() {
        return new Generattor();  //  создаю объект отдельного класса
    }
        public static void main(String[] args) {
            System.out.println("ТЕСТИРУЕМ РАЗНЫЕ ЧИСЛА");
            NumberGenerator<? super Number> generator = getGenerator();
            System.out.println("Число 5 > 0? " + generator.cond(5));       // true
            System.out.println("Число -3 > 0? " + generator.cond(-3));     // false
            System.out.println("Число 0 > 0? " + generator.cond(0));       // false
        }
    }

