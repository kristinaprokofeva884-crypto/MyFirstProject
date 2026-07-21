public class HelloWorld {
    public static void main(String[] args) {

        // try-with-resources — автоматически закрывает ресурсы
        // Car создается в скобках try — значит, он будет закрыт автоматически
        // ПОЧЕМУ: после выхода из блока вызовется car.close()
        try (Car car = new Car()) {
            car.drive();
            // Ловим все RuntimeException
            // По условию задачи нужно игнорировать исключения
        } catch (RuntimeException e) {
            // Пустой catch — игнорируем исключение
        }
    } // Конец метода main

    // ВНУТРЕННИЙ КЛАСС CAR
    // ЗАЧЕМ: implements AutoCloseable — чтобы использовать в try-with-resources
    static class Car implements AutoCloseable {
        public void drive() {
            System.out.println("Машина поехала.");
        }
        @Override
        public void close() {
            System.out.println("Машина закрывается.");
        }

} // Конец класса Car
} // Конец класса HelloWorld


