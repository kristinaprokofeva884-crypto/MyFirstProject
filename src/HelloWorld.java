//Подключаем класс ObjectMapper - главный инструмент для работы с JSON
//Он умеет превращать JSON в объекты Java и обратно
import com.fasterxml.jackson.databind.ObjectMapper;
//Подключаем настройку DeserializationFeature - она управляет поведением при чтении JSON
//Нужна,чтобы отключить ошибку на неизвестные поля
import com.fasterxml.jackson.databind.DeserializationFeature;
//Класс Email (внутренний)
//Объявляем класс Email - он соответствует вложенному объекту "email" в JSON
class Email {
    //Приватное поле email - будет хранить сам адрес электронной почты
    private String email;
    //Конструктор по умолчанию(без параметров)
    //Нужен для Jackson -ьон создаёт объект через пустой конструктор
    public Email() {
    }
    //Вызываем Геттер для поля email - Jackson использует его, чтобы прочитать значение
    public String getEmail() {
        return email;// возвращаем значение поля email обратно,мы посмотрели все что нужно.
    }
    //Вызываем Сеттер для поля email - Jackson использует его,чтобы записать значение.Он ничего не вовращает void
    public void setEmail (String email){
        this.email = email;// присваиваем переданное значение полю email
    }
}

//Класс User(внутренний)
//Объявляем класс User - он соответствует главному объекту в JSON
class User {
    //Приватное поле id - идентификатор пользователя (число)
    private int id;
    // Приватное поле name - имя пользователя (строка)
    private String name;
    // Приватное поле email - вложенный объект Email
//В JSON поле email - это не строка,а целый объект.
//Поэтому в Java мы создаём два класса:один для пользователя (User),
//а внутри него - отдельный класс для почты (Email).
//Просто так совпало,что оба поля называются email.
    private Email email;
    //Также создаем конструктор по умолчанию(без параметров) для Jackson - он создаёт объект через пустой конструктор
    public User() {
    }

    //1.Получем с помощью Геттера поля id чтобы прочитать значение
    public int getId() {
        return id;// возвращаем значение поля id
    }
    //Обращаемся к Сеттеру к полю id,чтобы записать значение.Ничего не возвращает void
    public void setId(int id) {
        this.id = id;// присваиваем переданное значение полю id
    }

    //2.Дальше переходим к след.полю name
    public String getName() {
        return name;// возвращаем значение поля name
    }
    //Обращаемся к Сеттеру к полю name,чтобы записать значение.Ничего не возвращает void
    public void setName(String name) {
        this.name = name;// присваиваем переданное значение полю name
    }

    //3.Дальше переходим к след.полю email
    public Email getEmail() {
        return email;
    }
    //Обращаемся к Сеттеру к полю email,чтобы записать значение.Ничего не возвращает void
    public void setEmail(Email email) {
        this.email = email;// присваиваем переданное значение полю email
    }
}

//Главный класс с точкой входа
public class HelloWorld {
    public static void main(String[] args) throws Exception {
        String json = """
                    {"id": 2, "name": "feye", "email": {"email": "faye@reqres.in"}}
                    """;
//Создаём объект ObjectMapper - это инструмент для работы с JSON
//mapper - имя переменной, через которую будем работать
        ObjectMapper mapper = new ObjectMapper();
//Настраиваем ObjectMapper
//configure() - метод для настройки
//DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES - настройка "падать на неизвестные поля"
//false - отключаем эту настройку (не падать, игнорировать лишние поля)
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // Превращаем JSON в объект User
        //mapper.readValue() - метод читает JSON и создаёт объект
        //json - наша JSON строка
        //User.class - говорим, что хотим получить объект типа User
        //user - переменная, куда сохраняем результат
        User user = mapper.readValue(json, User.class);
        //Печатаем id пользователя
        //вызываем геттер, чтобы получить id
        System.out.println("id: " + user.getId());
        //Также печатаем name пользователя
        System.out.println("name: " + user.getName());
        //Также печатаем email пользователя
        System.out.println("email: " + user.getEmail().getEmail());
    }
}

