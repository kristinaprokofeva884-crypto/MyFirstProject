import java.util.function.UnaryOperator; // Импортируем интерфейс UnaryOperator
//Сощдаем наш класс с которым будем работать
class MyOperator {
    //Пишем нашу сигнатуру из здачи,где будеи понятно с каким методом и параметроммы будем работать.
    public UnaryOperator<Integer> sqrt() {
        //Затем мы создаем лямбу и возращаем ее (береv один объект и умножает его на себя)
        //параметр один x с типом Integer ,а тело функции x * x
        //Java уже автоматически определяет,что это UnaryOperator<Integer>
        return x -> x * x;
    }
}
    public class Main {
        //Дальше в классе main мы используем это метод
        public static void main(String[] args) {
            // Создаем объект,чтобы вызвать наш метод
            MyOperator operator = new MyOperator();
            // Получаем реализацию UnaryOperator
            UnaryOperator<Integer> squareOperator = operator.sqrt();
            // apply - метод который существует у калькулятора squareOperator,
            // он помогает нам ВЫЧИСЛИТЬ (не сложить) результат
            int result = squareOperator.apply(5);
            //Выводим результаты проверки в консоль
            System.out.println("Квадрат числа: " + result);

        }
    }

