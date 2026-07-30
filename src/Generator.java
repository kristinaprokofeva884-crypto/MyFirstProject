// В этой задаче импорты не нужны так как мы не используем готовые интерфейсы
//СОЗДАЕМ ФУНКЦИОНАЛЬНЫЙ ИНТЕРФЕЙС
//@FunctionalInterface - аннотация, которая проверяет, то интерфейс имеет только один абстрактный метод
//NumberGenerator - название интерфейса
//<T extends Number> - дженерик, T должен быть Number или его наследником
@FunctionalInterface
interface NumberGenerator<T extends Number>{
    //Пишем метод boolean cond(T arg) - абстрактный метод
    //Который принимает число типа T и через boolean возвращает true или false
    // cond -  метод мы будем переопределять через лямбду
    boolean cond(T num);
}
//СОЗДАЕМ ГЛАВНЫЙ КЛАСС
    class MyGenerator {
    //Пишем нашу сигнатуру из задачи
    //NumberGenerator<? super Number> - возвращаемый тип
    //? super Number - wildcard: "любой родитель Number"
    public static NumberGenerator<? super Number> getGenerator() {
        //Создаем НОВЫЙ объект анонимного класса
        //Он сразу реализует интерфейс NumberGenerator и возращает нам метод
        return new NumberGenerator<Number>() {
            // ВОЗВРАЩАЕМ ЛЯМБДУ С ПЕРЕОПРЕДЕЛЕНИЕМ
            @Override
            //Реализуем метод cond из интерфейса
            //Принимаем число(Number n)
            //Возвращаем boolean (true или false)
            public boolean cond(Number n) {
                //Возвращаем результат проверки
                //n.intValue() - берем число и превращаем в int
                return n.intValue() > 0;
            }
        }; // Закрываем анонимный класс и заканчиваем return
    }//Закрываем наш обработанный метод

    public class Generator {
        //Теперь в main проверяем метод и его результаты
        public static void main(String[] args) {
            //Получаем реализацию NumberGenerator
            //Вызываем метод getGenerator()
            //Получаем объект,который умеет проверять числа
            NumberGenerator<? super Number> generator = getGenerator();
            //Тестируем с разными числами
            // generator.cond(число) - вызываем метод cond
            // Внутри выполняется наша лямбда: n -> n.intValue() > 0
            System.out.println("ТЕСТИРУЕМ РАЗНЫЕ ЧИСЛА");
            System.out.println("Число 5 > 0? " + generator.cond(5));         // 5 > 0 = true
            System.out.println("Число -3 > 0? " + generator.cond(-3));       // -3 > 0 = false
            System.out.println("Число 0 > 0? " + generator.cond(0));         // 0 > 0 = false
        }
    }
}