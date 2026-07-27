//Подключаем класс ObjectMapper - главный инструмент для работы с JSON
//Он умеет превращать JSON в объекты Java и обратно

import com.fasterxml.jackson.databind.ObjectMapper;

//Создаем внутринний класс CreateUserRequest с полями по суловию задачи
class CreateUserRequest {
    //Создаем классу приватное поле name в тип String
    private String name;
    //Создаем классу приватное поле job в тип String
    private String job;

    //Обращаемся к онструктору без параметров,он нужен Джексону,чтобы создать пустой объект.
    //После
    public CreateUserRequest() {
    }

    //Обращаемся теперь к конструктору с параметрами,он нужен нам,чтобы сразу создать объект с данными
    //через сеттеры заполнить его полями из JSON.
    public CreateUserRequest(String name, String job) {
        //Мы берём ссылку this на поле name текущего объекта и присваиваем
        //ему значение параметра name, который пришёл в конструктор.
        this.name = name;
        //Также делаем с полем job
        this.job = job;
    }//Закрваем конструктор с парметрами

    //Далее вход выдвигаются Геттеры и Сеттеры
//Геттер помогает прочитать поле(которое есть в классе CreateUserRequest.Он приоткрыввется пиватное поле,
//для чтения кто использует гет и возращает его на место.
    public String getName() {
        return name;
    }

    //Сеттер ничего не возращает,но он может изменить и присвоить ноевое значение для поля name
    public void setName(String name) {
        this.name = name;
    }

    //Также дл другого поля мы используем Геттер и Сеттер
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;

    }
}

class UserService {
    //Внутри передаем метод buildRequestBody-который создает JSON-строку из параметров объекта
    //buildRequestBody - имя метода: "построить тело запроса".
    //throws Exception - метод может выбросить исключение (если что-то пойдёт не так).
    public String buildRequestBody(String name, String job) throws Exception {
        //1.Создаём объект CreateUserRequest с переданными данными(его конструктором)
        // Передаём в него имя (name) и должность (job),которые пришли в метод.
        CreateUserRequest request = new CreateUserRequest(name, job);
        //2.Создаём ObjectMapper - объект умеет превращать Java-объекты в JSON и обратно
        //mapper - просто переменная
        ObjectMapper mapper = new ObjectMapper();
        //3.Превращаем объект в JSON-строку
        // .writeValueAsString() — это метод, который превращает Java-объект в JSON-строку и возвращаем
        //через return метод для request
        return mapper.writeValueAsString(request);
    }
}

public class Main {
    // Точка входа в программу.Выполнение программы и вывод в консоль
    public static void main(String[] args) throws Exception {
        // 1. Создаём объект UserService
        UserService userService = new UserService();
        // 2. Вызываем метод через объект
        String json = userService.buildRequestBody("Анна", "QA Engineer");
        //Теперь выводим значения на экран переменной,в которой лежат все конкретные значения
        System.out.println(json);
    }
}

