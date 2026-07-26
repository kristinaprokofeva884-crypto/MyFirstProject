// Подключаем класс ObjectMapper - это главный инструмент, который умеет превращать JSON в Java-объекты и обратно.
import com.fasterxml.jackson.databind.ObjectMapper;
// Подключаем класс JsonNode - это класс, который представляет один узел в дереве JSON.
// Он позволяет удобно извлекать данные из вложенных объектов.
import com.fasterxml.jackson.databind.JsonNode;

//Объвляем наш главный класс
public class Nested{
    //Объявляем метод main - точку входа в программу.
    //throws Exception - если внутри метода произойдёт ошибка, мы выбросим исключение
    public static void main(String[] args) throws Exception {
//1.Объявляем переменную json типа String (строка).
//Кладём в неё JSON-ответ API в виде текста.
//Текстовый блок """ ... """ (появился в Java 15) позволяет писать
//многострочный текст без экранирования кавычек.
        String json = """
                {
                "data": {
                "id": 2,
                "email": "a@b.com"
                },
                "support": {
                "url": "https://reqres.in/#support-heading",
                "text": "To keep ReqRes free..."
                }
                }
                """;

//2.Создаём объект ObjectMapper.
//Этот объект содержит все методы для работы с JSON:
//Нам нужен этот readTree() - читает JSON и строит дерево узлов
        ObjectMapper mapper = new ObjectMapper();
//3.Превращаем JSON-строку в JsonNode (дерево узлов).
//mapper.readTree(json) - читает JSON и строит иерархическое дерево.
//rootNode - это корневой узел, он представляет весь JSON.
//От него можно "спускаться" к вложенным объектам через .get().
        JsonNode rootNode = mapper.readTree(json);
        //4.Извлекаем data.id как целое число (int).
        //rootNode.get("data") - берём узел "data" из корня.
        // .get("id") - внутри "data" берём поле "id".
        // .asInt() - превращаем значение этого поля в целое число.
        //Полученное число сохраняем в переменную id (тип int).
        //Если значение отсутствует или не число, asInt() вернёт 0.
        int id = rootNode.get("data").get("id").asInt();
        //5.Также извлекаем data.email как строку (String)
        String email = rootNode.get("data").get("email").asText();
        //6.Также извлекаем support.url как строку (String).
        String supportUrl = rootNode.get("support").get("url").asText();
        //7.Выводим все извлечённые значения в консоль.
        //Знак + склеивает текст и значения переменных в одну строку.
        System.out.println("data.id: " + id);
        System.out.println("data.email: " + email);
        System.out.println("support.url: " + supportUrl);
    }
}