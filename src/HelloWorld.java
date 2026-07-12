public class HelloWorld {
    public static void main(String[] args) {
        // Robot- - тип переменной нашего класса Робота.
        // robot - имя переменной (ссылка на объект - робота,который создаетс я с помощью new)
        // Мы присваеваем = и вызывем конструктор,который также с помощью new призывется и
        // и передаем ему координаты(нашему конструктору):Robot(0, 0, Direction.UP) - вызов конструктора
        // Изначально у констурктора по умолчания все значения 0 - (у всех функций - влево,вправа,вверх)
        Robot robot = new Robot(0, 0, Direction.UP);
        // moveRobot - метод для робота,как он будет двигаться с помощью функций и координатов
        // robot - передаем нашу ссылку с маленькой буквы(к имение перемнной)
        // передаем в X координату 3 по условиям задачи куда надо прийти.
        // передаем также в Y значение 0 по условиям задачи,куда нужно прийти(то.есть направдение робота
        // через X и Y
        moveRobot(robot, 3, 0);
        // Выводим на экран,где мы говорим изначально,что Робот находиться:
        // (" + robot.getX() + "," + robot.getY() + ")");
        // ( - скобка означается,что нужно ввести аргументы "- а ковычках будет наш текст
        // + - склеивание строк
        // robot - объект робота(ссылка)
        // . - оператор доступа
        // getX() - метод, возвращающий координату X.Гет - это означает получить
        // + - склеивание строк
        // "," - текст (запятая)
        // + - склеивание строк
        // robot - объект робота
        // . - оператор доступа
        // getY() - метод, возвращающий координату Y.Гет-означает полчить
        // + - склеивание строк
        // ")" - текст (закрывающая скобка)
        // ) - конец аргументов
        // ; - конец инструкции
        System.out.println("Робот находится: (" + robot.getX() + "," + robot.getY() + ")");
    } // } - закрывающая скобка метода main

    // МЕТОД moveRobot
    // moveRobot - имя метода
    // Robot robot - параметр: объект робота(тип переменной и ссылка)
    // int toX - параметр: куда прийти по X
    // int toY - параметр: куда прийти по Y
    public static void moveRobot(Robot robot, int toX, int toY) {

        // ЧАСТЬ 1: ДВИЖЕНИЕ ПО ОСИ X
        // int - тип переменной (целое число)
        // x - имя переменной (текущая координата X)
        // = - оператор присваивания
        // robot - объект робота
        // . - оператор доступа
        // getX() - вызываем метод, возвращающий X
        // ; - конец инструкции
        int x = robot.getX();

        // Прверяем условие,где находится робот СЛЕВА от цели?
        //Если ДА (x меньше toX) → робот идёт ВПРАВО.
        //Если НЕТ (x больше или равен toX) → робот либо уже на месте, либо идёт ВЛЕВО.
        if (x < toX) {
            // Нужно идти ВПРАВО, т.к. X нужно увеличить(потому что у нас X- 3)
            // while - выполняем цикл,пока условие верно
            // объкт нашего робота и методgetDirection(по умолчанию)
            // != - оператор "не равно"
            // Direction.RIGHT - нужное направление (вправо)
            // ) - конец условия
            // { - начало тела цикла
            while (robot.getDirection() != Direction.RIGHT) {
                // где мы дошли и разварчиваем робота
                // turnRight() - метод, поворачивающий направо
                // ; - конец инструкции
                robot.turnRight();
            }  // } - закрывающая скобка while
            // while - цикл, выполняется, пока X не равен toX
            // ( - начало условия
            // robot.getX() - текущая координата X
            // != - не равно
            // toX - целевая координата X
            // ) - конец условия
            while (robot.getX() != toX) {
                // robot.stepForward() - делаем шаг вперёд
                // ; - конец инструкции
                robot.stepForward();
            } // } - закрывающая скобка while
        }  // } - закрывающая скобка if (x < toX)
        // else if - иначе если
        // ( - начало условия
        // x > toX - условие: текущий X больше целевого?
        // ) - конец условия
        else if (x > toX) {
            // Нужно идти ВЛЕВО, т.к. X нужно уменьшить
            // while - цикл, пока робот не посмотрит LEFT
            while (robot.getDirection() != Direction.LEFT) {
                // robot.turnLeft() - поворачиваем налево
                // ; - конец инструкции
                robot.turnLeft();
            }// } - закрывающая скобка while
            // while - цикл, пока X не станет равен toX
            while (robot.getX() != toX) {
                // robot.stepForward() - шагаем вперёд
                // ; - конец инструкции
                robot.stepForward();
            }  // } - закрывающая скобка while
        } // } - закрывающая скобка else if

        // ЧАСТЬ 2: ДВИЖЕНИЕ ПО ОСИ Y
        // int - тип переменной (целое число)
        // y - имя переменной (текущая координата Y)
        // = - оператор присваивания
        // robot - объект робота
        // . - оператор доступа
        // getY() - метод, возвращающий Y
        // ; - конец инструкции
        int y = robot.getY();
        // if - проверяем, нужно ли двигаться по Y
        if (y < toY) {
            // Нужно идти ВВЕРХ (Y нужно увеличить)
            // while - пока не посмотрит UP
            while (robot.getDirection() != Direction.UP) {
                // robot.turnRight() - поворачиваем направо
                // ; - конец инструкции
                robot.turnRight();
            } // } - закрывающая скобка while
            // while - пока Y не станет равен toY
            while (robot.getY() != toY) {
                // robot.stepForward() - шагаем вперёд
                // ; - конец инструкции
                robot.stepForward();
            } // } - закрывающая скобка while
        } // } - закрывающая скобка if (y < toY)
        // else if - иначе если Y больше целевого
        else if (y > toY) {
            // Нужно идти ВНИЗ (Y нужно уменьшить)
            // while - пока не посмотрит DOWN
            while (robot.getDirection() != Direction.DOWN) {
                // robot.turnRight() - поворачиваем направо
                // ; - конец инструкции
                robot.turnRight();
            } // } - закрывающая скобка while
            // while - пока Y не станет равен toY
            while (robot.getY() != toY) {
                // robot.stepForward() - шагаем вперёд
                // ; - конец инструкции
                robot.stepForward();
            }  // } - закрывающая скобка while
        }  // } - закрывающая скобка else if (y > toY)
    }// } - закрывающая скобка метода moveRobot
}// } - закрывающая скобка класса HelloWorld

// ENUM Direction (перечисление направлений)
// enum - ключевое слово для создания перечисления
// Direction - имя перечисления
enum Direction {
    // UP - константа "вверх"
    // , - разделитель
    UP,
    // DOWN - константа "вниз"
    DOWN,
    // LEFT - константа "влево"
    LEFT,
    // RIGHT - константа "вправо"
    // ; - точка с запятой после последней константы
    RIGHT;
}// } - закрывающая скобка enum Direction


// КЛАСС Robot
// class - ключевое слово для создания класса
// Robot - имя класса
class Robot {
    // private - поле доступно ТОЛЬКО внутри этого класса
    // int - тип (целое число)
    // x - координата X
    // ; - конец инструкции
    private int x;
    // private - поле доступно ТОЛЬКО внутри этого класса
    // int - тип (целое число)
    // y - координата Y
    // ; - конец инструкции
    private int y;
    // private - поле доступно ТОЛЬКО внутри этого класса
    // Direction - тип (направление)
    // direction - текущее направление робота
    // ; - конец инструкции
    private Direction direction;

    // КОНСТРУКТОР Robot
    // public - доступен из любого места
    // Robot - имя конструктора (совпадает с именем класса)
    // (int x, int y, Direction direction) - параметры
    public Robot(int x, int y, Direction direction) {
        // this - ссылка на текущий объект
        // . - оператор доступа
        // x - поле класса
        // = - присваивание
        // x - параметр конструктора
        // ; - конец инструкции
        this.x = x;
        // this.y = y - сохраняем Y
        // ; - конец инструкции
        this.y = y;
        // this.direction = direction - сохраняем направление
        // ; - конец инструкции
        this.direction = direction;
    } // } - закрывающая скобка конструктора

    // МЕТОД turnLeft (поворот налево)
    // public - доступен из любого места
    // void - ничего не возвращает
    // turnLeft - имя метода
    // () - без параметров
    public void turnLeft() {
        // switch - оператор множественного выбора
        // ( - начало
        // direction - проверяем текущее направление
        // ) - конец
        switch (direction) {

            // case - проверяем, если direction = UP
            // UP - значение для проверки
            // : - двоеточие
            case UP:
                // direction = Direction.LEFT - меняем направление на LEFT
                // ; - конец инструкции
                // break - выходим из switch
                direction = Direction.LEFT;
                break;

            // case LEFT:
            case LEFT:
                // direction = Direction.DOWN - меняем на DOWN
                // ; - конец инструкции
                direction = Direction.DOWN;
                break;

            // case DOWN:
            case DOWN:
                // direction = Direction.RIGHT - меняем на RIGHT
                // ; - конец инструкции
                direction = Direction.RIGHT;
                break;

            // case RIGHT:
            case RIGHT:
                // direction = Direction.UP - меняем на UP
                // ; - конец инструкции
                direction = Direction.UP;
                break;
        }// } - закрывающая скобка switch
    } // } - закрывающая скобка метода turnLeft

    // МЕТОД turnRight (поворот направо)
    // public - доступен из любого места
    // void - ничего не возвращает
    // turnRight - имя метода
    public void turnRight() {

        // switch - проверяем направление
        switch (direction) {

            // case UP:
            case UP:
                // direction = Direction.RIGHT - меняем на RIGHT
                direction = Direction.RIGHT;
                break;

            // case RIGHT:
            case RIGHT:
                // direction = Direction.DOWN - меняем на DOWN
                direction = Direction.DOWN;
                break;

            // case DOWN:
            case DOWN:
                // direction = Direction.LEFT - меняем на LEFT
                direction = Direction.LEFT;
                break;

            // case LEFT:
            case LEFT:
                // direction = Direction.UP - меняем на UP
                direction = Direction.UP;
                break;
        }// } - закрывающая скобка switch
    }  // } - закрывающая скобка метода turnRight


    // МЕТОД stepForward (шаг вперёд)
    // public - доступен из любого места
    // void - ничего не возвращает
    // stepForward - имя метода
    public void stepForward() {

        // switch - проверяем направление
        switch (direction) {

            // case UP:
            case UP:
                // y++ - увеличиваем Y на 1 (идём вверх)
                // ; - конец инструкции
                // break - выходим из switch
                y++;
                break;

            // case DOWN:
            case DOWN:
                // y-- - уменьшаем Y на 1 (идём вниз)
                // ; - конец инструкции
                y--;
                break;

            // case LEFT:
            case LEFT:
                // x-- - уменьшаем X на 1 (идём влево)
                // ; - конец инструкции
                x--;
                break;

            // case RIGHT:
            case RIGHT:
                // x++ - увеличиваем X на 1 (идём вправо)
                // ; - конец инструкции
                x++;
                break;
        }// } - закрывающая скобка switch
    } // } - закрывающая скобка метода stepForward

// ГЕТТЕРЫ (для получения значений)

// public - доступен из любого места
// int - возвращает целое число
// getX - имя метода
// () - без параметров
// return x - возвращаем координату X
public int getX() {
    return x;
    // } - закрывающая скобка getX
}

// public - доступен из любого места
// int - возвращает целое число
// getY - имя метода
// return y - возвращаем координату Y
public int getY() {
    return y;
    // } - закрывающая скобка getY
}

// public - доступен из любого места
// Direction - возвращает направление
// getDirection - имя метода
// return direction - возвращаем направление
public Direction getDirection() {
    return direction;
}// } - закрывающая скобка getDirection
}
