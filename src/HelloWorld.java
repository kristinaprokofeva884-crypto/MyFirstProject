
// Создаем проверяемое исключение
// extends Exception - наследуем от Exception (делаем проверяемым)
class MyNewException extends Exception {
    // Создаем конструктор с сообщением
    // String message - параметр для текста ошибки
    // super(message) - передаем сообщение родительскому классу Exception
    // Это позволяет выводить понятное сообщение при ошибке
    public MyNewException(String message) {
        super(message);  // Передаем сообщение в класс Exception
    }
}
// Создаем класс для демонстрации работы исключения
class TestClass {
    // Создаем метод testExp(), который выбрасывает исключение
    // throws MyNewException - объявляем, что метод может выбросить исключение
    public void testExp() throws MyNewException {
        // Выбрасываем наше исключение - throw
        // new MyNewException("Это проверяемое исключение!") - создаем объект исключения
        // с сообщением, которое будет видно при ошибке
        // метод testExp() сразу завершится при выбросе исключения
        throw new MyNewException("Это проверяемое исключение!");
        // Код после throw НЕ ВЫПОЛНИТСЯ!
        //Выведиться через System.out.println("Это не будет напечатано");
    }
}
// ПРОВЕРЯЕМ РАБОТУ В МЕТОДЕ main()
public class HelloWorld {
    public static void main(String[] args) {
        // Создаем объект класса TestClass,чтобы вызвать метод testExp()
        TestClass test = new TestClass();
        // Вызываем метод testExp() в блоке try-catch
        // Это ОБЯЗАТЕЛЬНО для проверяемых исключений!
        // try - пробуем выполнить код, который может выбросить исключение
        // catch - перехватываем исключение, если оно произошло
        try {
            // Вызываем метод testExp()
            // Этот метод выбрасывает MyNewException
            // Если исключение выброшено, выполнение перейдет в catch
            test.testExp();
            // Перехватываем наше исключение
            // catch (MyNewException e) - ловим именно наше исключение
            // e - переменная с объектом исключения
        } catch (MyNewException e) {
            // e.getMessage() - получаем сообщение, которое передали в конструктор
            System.out.println("Перехвачено исключение: " + e.getMessage());
        } finally {
            // Код после try-catch выполнится в любом случае
            // Показывает, что программа продолжает работу после обработки ошибки
            System.out.println("Программа завершена успешно!");
        }
    }
}