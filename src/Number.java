//Задача с лямд-выражением
@FunctionalInterface
interface Number1Generator<T extends Number> {
    boolean cond(T num);
}

class MyGenerator2 {
    public static NumberGenerator<? super Number> getGenerator() {
        return n -> n.intValue() > 0;
    }

    public static void main(String[] args) {
        NumberGenerator<? super Number> generator = getGenerator();
        System.out.println("ТЕСТИРУЕМ РАЗНЫЕ ЧИСЛА");
        System.out.println("Число 5 > 0? " + generator.cond(5));
        System.out.println("Число -3 > 0? " + generator.cond(-3));
        System.out.println("Число 0 > 0? " + generator.cond(0));
    }
}
