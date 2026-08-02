import java.util.*;
import java.util.stream.Collectors;

public class ApiStatistic {
    public static void main(String[] args) {
        //Мы создаём список в котором будут храниться целые числа (Integer).
        List<Integer> statusCodes = Arrays.asList(
                200, 201, 203,
                400, 401, 403,
                500, 501, 504
        );

        int total_cods = statusCodes.size(); //Считаем сколько элементов в списке и кладем в переменную
        System.out.println("СТАТИСТИКА ОТВЕТОВ API\n");
        System.out.println("Всего запросов: " + total_cods);//Печаем общее кол-во кодов

        //Задача 1
        System.out.println("\n ЗАДАЧА 1: Успешные запросы(2xx)");
        // Мы создаём поток из нашего списка статус-кодов.
        long success = statusCodes.stream()
                //Мы фильтруем числа:оставляем только те,которые больше или равны 200 И одновременно меньше 300.
                .filter(code -> code >= 200 && code < 300)
                // Мы считаем количество успешных чисел,которые прошли через фильтр.
                .count();
        System.out.println("Успешных запросов: " + success);

        //Задача 2
        System.out.println("\n ЗАДАЧА 2: Ошибки клиента(4xx)");
        //Мы снова создаём поток из списка статус-кодов.
        long clientErrors = statusCodes.stream()
                //Мы оставляем только те числа,которые больше или равны 400 И одновременно меньше 500.
                .filter(code -> code >= 400 && code < 500)
                .count();
        System.out.println("Ошибок клиента (4xx): " + clientErrors);

        //Задача 3
        System.out.println("\n ЗАДАЧА 3: Ошибки сервера(5xx)");
        //Мы создаём поток и переменную hasServerError типа boolean
        boolean ServerErrors = statusCodes.stream()
                //Мы спрашиваем у потока: "Есть ли хоть одно число,
                //которое больше или равно 500 И одновременно меньше 600?"
                //anyMatch() проверяет по очереди и как только находит подходящее - сразу говорит true и отстанвливается
                .anyMatch(code -> code >= 500 && code < 600);
        System.out.println("Есть ошибка сервера(5xx): " + ServerErrors);

        //Задача 5
        System.out.println("\n ЗАДАЧА 4: Самый частый статус-код");
        //Мы создаём поток и переменную,которая будет хранить самый частый код.
        Integer offtencod = statusCodes.stream()
                //groupingBy() группcollect(ирует одинаковые числа вместе.
                .collect(Collectors.groupingBy(
                        //Мы говорим:"Группируй числа по их значению".
                        code -> code,
                        //"Считай количество в каждой группе"
                        Collectors.counting()
                ))
                //Мы закрываем groupingBy.Теперь каждое число соответствует его количеству.
                // Мы берём все записи из этой карты.Каждая запись - это пара:число и сколько раз оно встретилось.
                .entrySet()
                // Мы создаём новый поток из этих записей.
                .stream()
                //Мы ищем запись с самым большим значением(количеством).
                .max(Map.Entry.comparingByValue())
                //Мы берём только ключ(само число)из этой записи.
                .map(Map.Entry::getKey)
                // Если список был пустым,мы вернём null(ничего).
                .orElse(null);
        System.out.println("Самый частый код: " + offtencod);

        //Задача 5
        System.out.println("\n ЗАДАЧА 5: Процент успешных запросов");
        //Мы вычисляем процент.Превращаем количество успешных запросов в дробное число (double),
        //делим на общее количество,умножаем на 100.
        double successfulrequest = ((double) success / offtencod) * 100;
        //Мы печатаем результат с двумя знаками после запятой: "Процент успешных запросов:
        System.out.printf("Процент успешных запросов: %.2f%%\n", successfulrequest);
    }
}
