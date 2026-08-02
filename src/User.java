//User.java - класс, описывающий пользователя
//В этом файле только 1 класс - User

public class User {
    // Поля (состояние объекта)
    private int id;
    private String name;
    private String email;
    private String role;
    private int age;

    // Конструктор для создания объекта
    public User(int id, String name, String email, String role, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.age = age;
    }

    // Геттеры (для доступа к полям из других классов)
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public int getAge() {
        return age;
    }
}

