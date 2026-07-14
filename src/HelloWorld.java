import java.util.Objects;
public class HelloWorld {
    public static void main(String[] args) {
        //СОЗДАЁМ ОБЪЕКТЫ ComplexNumber
        // new — создаём объект в памяти
        // ComplexNumber(2.0, 3.0) — вызываем конструктор
        // num1 — переменная, ссылается на объект
        ComplexNumber num1 = new ComplexNumber(2.0, 3.0);
        // Создаём второй объект с ТАКИМИ ЖЕ значениями
        // num2 — ссылается на ДРУГОЙ объект, но с теми же числами
        ComplexNumber num2 = new ComplexNumber(2.0, 3.0);
        // Создаём третий объект с ДРУГИМИ значениями (im = 4.0 вместо 3.0)
        ComplexNumber num3 = new ComplexNumber(2.0, 4.0);

        // ПРОВЕРКА equals()
        // System.out.println — выводим в консоль
        // " Проверка equals() " — заголовок
        System.out.println("Проверка equals()");
        // num1.equals(num2) — сравниваем num1 и num2
        // Поля: 2.0 == 2.0 и 3.0 == 3.0 → true
        // Вывод: num1.equals(num2) = true
        System.out.println("num1.equals(num2) = " + num1.equals(num2));
        // num1.equals(num3) — сравниваем num1 и num3
        // Поля: 2.0 == 2.0, но 3.0 != 4.0 → false
        // Вывод: num1.equals(num3) = false
        System.out.println("num1.equals(num3) = " + num1.equals(num3));

        //ПРОВЕРКА hashCode()
        // \n — символ перевода строки (отступ)
        System.out.println("\n Проверка hashCode()");

        // num1.hashCode() — вычисляем хэш-код объекта num1
        System.out.println("num1.hashCode() = " + num1.hashCode());

        // num2.hashCode() — хэш-код должен быть ТАКОЙ ЖЕ, как у num1
        // (потому что объекты равны по содержимому)
        System.out.println("num2.hashCode() = " + num2.hashCode());

        // num3.hashCode() — хэш-код должен быть ДРУГОЙ (потому что im = 4.0)
        System.out.println("num3.hashCode() = " + num3.hashCode());

        //ПРОВЕРКА КОНТРАКТА equals() И hashCode()
        System.out.println("\n Проверка контракта");

        // Проверяем: num1 и num2 РАВНЫ
        System.out.println("num1.equals(num2) = " + num1.equals(num2));
        // Проверяем: их хэш-коды РАВНЫ (контракт соблюдён)
        System.out.println("num1.hashCode() == num2.hashCode() = " + (num1.hashCode() == num2.hashCode()));
        // Проверяем: num1 и num3 НЕ РАВНЫ
        System.out.println("num1.equals(num3) = " + num1.equals(num3));
        // Проверяем: их хэш-коды могут быть разными (желательно)
        System.out.println("num1.hashCode() == num3.hashCode() = " + (num1.hashCode() == num3.hashCode()));

        // ИСПОЛЬЗОВАНИЕ В HashSet
        System.out.println("\n=== Использование в HashSet ===");

        // HashSet — коллекция, которая хранит только УНИКАЛЬНЫЕ объекты
        // <ComplexNumber> — тип элементов
        // set — имя переменной
        java.util.HashSet<ComplexNumber> set = new java.util.HashSet<>();

        // set.add(num1) — добавляем num1 в коллекцию
        set.add(num1);

        // set.add(num2) — пытаемся добавить num2
        // num2 РАВЕН num1 → дубликат → НЕ ДОБАВИТСЯ!
        set.add(num2);

        // set.add(num3) — добавляем num3
        // num3 НЕ РАВЕН num1 → ДОБАВЛЯЕТСЯ!
        set.add(num3);

        // set.size() — возвращает количество элементов в коллекции
        // Должно быть 2 (num1 и num3, num2 — дубликат)
        System.out.println("Размер множества: " + set.size());

        // Выводим все элементы множества
        System.out.println("Элементы множества:");
        for (ComplexNumber num : set) {
            // num.re — реальная часть
            // num.im — мнимая часть
            System.out.println("  (" + num.re + ", " + num.im + ")");
        }// } — конец метода main
    }// } — конец класса HelloWorld

// КЛАСС ComplexNumber (комплексное число)
    // class — создаём новый класс
    // ComplexNumber — имя класса (комплексное число, например: 2 + 3i)
    // { — начало класса
    static class ComplexNumber {
        // ПОЛЯ КЛАССА (re — реальная часть, im — мнимая часть)
        // private — поле видно ТОЛЬКО внутри этого класса (никто снаружи не трогает)
        // final — поле нельзя изменить после создания (константа)
        // double — тип данных (число с плавающей точкой, например: 2.5)
        // re — реальная часть комплексногочисла (real part)
        private final double re;
        // im — мнимая часть комплексного числа (imaginary part)
        private final double im;

        // КОНСТРУКТОР (создаёт объект и записывает значения в поля)
        // public — конструктор доступен из любого места
        // ComplexNumber — имя конструктора = имя класса
        // (double re, double im) — конструктор принимает два числа
        // { — начало конструктора
        public ComplexNumber(double re, double im) {
            // this — ссылка на ТЕКУЩИЙ объект (этот объект, который сейчас создаётся)
            // this.re — поле re ЭТОГО объекта
            // re — параметр, который пришёл в конструктор
            // = — присваиваем значение параметра в поле
            this.re = re;
            // this.im = im — сохраняем мнимую часть
            this.im = im;
        } // } — конец конструктора


        // МЕТОД equals() — СРАВНИВАЕТ ОБЪЕКТЫ ПО СОДЕРЖИМОМУ
        // @Override — говорим компилятору: "Я переопределяю метод из класса Object"
        @Override
        // public — метод виден всем
        // boolean — метод возвращает true (равны) или false (не равны)
        // equals — имя метода
        // (Object obj) — принимает ЛЮБОЙ объект (тип Object — родитель всех классов)
        // { — начало метода
        public boolean equals(Object obj) {

            // ШАГ 1: СРАВНИВАЕМ ССЫЛКИ
            // if — проверяем условие
            // this — текущий объект (у которого вызвали equals)
            // == — сравниваем ссылки (адреса в памяти)
            // obj — объект, с которым сравниваем
            // Если это один и тот же объект в памяти → они точно равны
            if (this == obj) {
                // return true — сразу возвращаем true и выходим из метода
                return true;
            } // } — конец if

            // ШАГ 2: ПРОВЕРКА НА NULL
            // if — проверяем условие
            // obj == null — проверяем, не равен ли переданный объект null
            // Если null, то объекты не могут быть равны
            if (obj == null) {
                // return false — возвращаем false
                return false;
            }   // } — конец if

            // ШАГ 3: ПРОВЕРКА КЛАССА
            // getClass() — возвращает класс текущего объекта (ComplexNumber)
            // obj.getClass() — возвращает класс переданного объекта
            // != — не равно
            // Если классы разные (например, ComplexNumber и String) → объекты НЕ равны
            if (getClass() != obj.getClass()) {
                // return false — возвращаем false
                return false;
            }// } — конец if

            // ШАГ 4: ПРИВОДИМ К ТИПУ ComplexNumber
            // (ComplexNumber) obj — явное приведение типа (кастинг)
            // Мы знаем, что obj — это ComplexNumber (проверили в шаге 3)
            // other — новая переменная для приведённого объекта
            ComplexNumber other = (ComplexNumber) obj;

            // ШАГ 5: СРАВНИВАЕМ ПОЛЯ re И im
            // return — оператор возврата значения
            // Double.compare(this.re, other.re) — сравниваем re
            // Double.compare(a, b) возвращает 0, если a == b
            // == 0 — проверяем, что результат сравнения равен 0 (числа равны)
            // && — логическое И (оба условия должны быть true)
            // Double.compare(this.im, other.im) == 0 — сравниваем im

            // Почему используем Double.compare(), а не == ?
            // Потому что double может иметь погрешности (0.1 + 0.2 != 0.3)
            // Double.compare() корректно сравнивает числа с плавающей точкой
            return Double.compare(this.re, other.re) == 0
                    && Double.compare(this.im, other.im) == 0;
        }// } — конец метода equals

        // МЕТОД hashCode() — ВОЗВРАЩАЕТ ЧИСЛОВОЙ КОД ОБЪЕКТА
        // @Override — переопределяем метод из класса Object
        @Override
        // public — метод виден всем
        // int — возвращает целое число (хэш-код)
        // hashCode — имя метода
        // () — метод без параметров
        public int hashCode() {

            // ВЫЧИСЛЯЕМ ХЭШ-КОД С ПОМОЩЬЮ Objects.hash()
            // return — оператор возврата значения
            // Objects.hash(re, im) — вычисляет хэш-код на основе re и im
            // Objects — класс из java.util (мы импортировали его в начале)
            // hash — статический метод, принимает любое количество аргументов
            // re — реальная часть (учитываем в хэше)
            // im — мнимая часть (учитываем в хэше)

            // ПОЧЕМУ ЭТО ПРАВИЛЬНО:
            // 1) Учитываются ОБА поля (re и im) — хэш зависит от значений
            // 2) Учитывается дробная часть (Double.hashCode учитывает всё)
            // 3) Не возвращает константу (хэш разный для разных значений)
            // 4) Согласовано с equals() — равные объекты → равные хэши
            return Objects.hash(re, im);
        } // } — конец метода hashCode
    }// } — конец класса ComplexNumber
    }