import java.util.*;
import java.util.stream.Collectors;

  public class UserProcessor{
    public static void main(String[] args) {
        // Создаем список пользователей
        List<User> users = Arrays.asList(
                new User(1, "Anna", "anna@mail.com", "USER", 30),
                new User(2, "Bob", "bob@mail.com", "ADMIN", 22),
                new User(3, "Charlie", "charlie@mail.com", "USER", 35),
                new User(4, "Diana", "diana@mail.com", "ADMIN", 28),
                new User(5, "Eve", "eve@mail.com", "MANAGER", 19)
        );

// ЗАДАЧА 1
        System.out.println("Email пользователей старше 25 лет");
        //Создаем переменную, которая будет хранить список строк (email'ов)
        //.stream() — превращает список в поток (Stream).
        List<String> emails = users.stream()
                // .filter() - метод,который фильтрует элементы потока
                .filter(u -> u.getAge() > 25) //Проверяем услови через лямб-выражание,что возраст пользователя больше 25
                //.map() - метод,который преобразует каждый элемент в другой объект
                //ссылка на метод
                .map(u -> u.getEmail())
                // .sorted() - метод,который сортирует элементы потока
                .sorted()
                //.collect() - метод,который собирает элементы потока в коллекцию
                //Collectors.toList() указывает,что мы хотим собрать в список (List)
                .collect(Collectors.toList());
        System.out.println(emails);

        //ЗАДАЧА 2
        System.out.println("\n Пользователь с максимальным возрастом");
        users.stream()
                //Ищем пользователя с максимальным возрастом.
                //Comparator.comparing(User::getAge) говорим:"Сравнивай пользователей по их возрасту".
                .max(Comparator.comparing(User::getAge))
                //u -> System.out.println(...) — лямбда, которая принимает
                //найденного пользователя,ничего не возращает
                //.ifPresent() выполняет код ТОЛЬКО если пользователь найден.
                .ifPresent(u -> System.out.println(u.getName() + " (" + u.getAge() + " лет)"));

        //ЗАДАЧА 3
        System.out.println("\n Есть ли ADMIN?");
        //Создаем переменную hasAdmin типа boolean
        boolean hasAdmin = users.stream()
                //Метод anyMatch() проверяет,есть ли ХОТЯ БЫ ОДИН пользователь,
                //который подходит под условие через сравнение equals.
                //u -> u.getRole().equals("ADMIN") — лямбда,которая проверяет роль пользователя
                .anyMatch(u -> u.getRole().equals("ADMIN"));
        System.out.println(hasAdmin);

        //Задача 4
        System.out.println("\n Группировка по ролям");
        //Создаем переменную usersByRole типа Map<String, List<User>>.
        //Из списка users создаем поток.
        Map<String, List<User>> usersByRole = users.stream()
                //collect() собирает элементы потока в коллекцию.
                //Collectors.groupingBy(User::getRole) группирует пользователей по их роли.
                //User::getRole говорим:"Группируй по тому,что вернет этот метод"
                .collect(Collectors.groupingBy(User::getRole));
        //Проходим по всем записям в карте usersByRole.
        //forEach - для каждой пары(ключ, значение) и выполняем код.
        usersByRole.forEach((role, list) -> {
            System.out.println(role + ":");
            //Для каждого пользователя в списке (list) выводим его имя через ляммд-выражение
            list.forEach(u -> System.out.println("  - " + u.getName()));
        });//Закрываем forEach для карты и заканчиваем метод main().

        //Задача 5
        System.out.println("\n Имена через запятую");
        //Создаем переменную names типа String.
        //Также из списка users создаем поток.
        String names = users.stream()
                //Преобразуем каждого пользователя в его имя.
                // Было: [Anna(USER), Bob(ADMIN), Charlie(USER), Diana(ADMIN), Eve(MANAGER)]
                // Стало: ["Anna", "Bob", "Charlie", "Diana", "Eve"]
                .map(User::getName)
                // Собираем все строки в одну, соединяя их через запятую с пробелом.
                // Collectors.joining(", ") — создает соединитель:
                .collect(Collectors.joining(", "));
        System.out.println(names);
    }
}







