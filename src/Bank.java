// ЧАСТЬ 1.КЛАССЫ ИСКЛЮЧЕНИЙ
// СТРОКА 1: Объявляем класс BadCreditHistoryException
// Создаем свое исключение для проблем с кредитной историей
// extends Exception — унасделываем и делаем проверяемым исключением (компилятор заставит обрабатывать)
class BadCreditHistoryException extends Exception {
    // СТРОКА 2: Конструктор с параметром message
    // ЗЧтобы можно было передать текст ошибки
    // String message — текст сообщения
    public BadCreditHistoryException(String message) {
        // СТРОКА 3: Передаем сообщение родительскому классу Exception
        //Чтобы сообщение сохранилось в исключении
        //super(message) — вызов конструктора родителя
        super(message);
    } // СТРОКА 4: Закрываем конструктор
} // СТРОКА 5: Закрываем класс BadCreditHistoryException


// СТРОКА 6: Объявляем класс ProblemWithLawException
// Создаем свое исключение для проблем с законом
// extends Exception — делаем проверяемым исключением
class ProblemWithLawException extends Exception {
    // СТРОКА 7: Конструктор с параметром message
    //Чтобы можно было передать текст ошибки
    public ProblemWithLawException(String message) {
        // СТРОКА 8: Передаем сообщение родительскому классу Exception
        // Чтобы сообщение сохранилось в исключении
        super(message);
    } // СТРОКА 9: Закрываем конструктор
} // СТРОКА 10: Закрываем класс ProblemWithLawException



// ЧАСТЬ 2: КЛАСС BANKCLIENT (клиент банка)
// СТРОКА 11: Объявляем класс BankClient
// Создаем модель клиента банка
class BankClient {
    // СТРОКА 12: Поле name (имя клиента)
    private String name;
    // СТРОКА 13: Конструктор класса BankClient
    // Создаем клиента с именем
    public BankClient(String name) {
        // СТРОКА 14: Сохраняем имя в поле класса
        // Запоминаем имя клиента в объекте
        // this.name — поле класса, name — параметр конструктора
        this.name = name;
    } // СТРОКА 15: Закрываем конструктор
    // СТРОКА 16: Метод getName() — геттер для имени
    // Чтобы получить имя клиента извне
    public String getName() {
        // СТРОКА 17: Возвращаем имя клиента
        return name;
    } // СТРОКА 18: Закрываем метод getName()
} // СТРОКА 19: Закрываем класс BankClient



// ЧАСТЬ 3: ИНТЕРФЕЙС BANKWORKER (работник банка)
// СТРОКА 20: Объявляем интерфейс BankWorker
// Описываем контракт для всех работников банка
// interface — создаем интерфейс
// Все классы, реализующие интерфейс, должны иметь этот метод
interface BankWorker {
    // СТРОКА 21: Метод checkClientForCredit
    // ЗПроверяет, может ли клиент получить кредит
    // boolean — возвращает true (одобрено) или false (отказано)
    // throws — метод может выбросить проверяемые исключения
    boolean checkClientForCredit(BankClient client)
    // СТРОКА 22: Исключения, которые может выбросить метод
    // Указываем, что метод выбрасывает эти исключения
    // throws — обязательное указание для проверяемых исключений
            throws BadCreditHistoryException, ProblemWithLawException;
} // СТРОКА 23: Закрываем интерфейс BankWorker




// ЧАСТЬ 4: РЕАЛИЗАЦИЯ BANKWORKER (конкретный работник)
class SimpleBankWorker implements BankWorker {
    // private — скрываем, boolean — true/false
    private boolean hasBadHistory;
    // СТРОКА 26: Поле hasProblemWithLaw (есть ли проблемы с законом)
    // Храним состояние — есть ли проблемы с законом
    private boolean hasProblemWithLaw;
    // СТРОКА 27: Конструктор с параметрами
    // Задаем, какие проблемы будут у клиента при проверке
    public SimpleBankWorker(boolean hasBadHistory, boolean hasProblemWithLaw) {
        // СТРОКА 28: Сохраняем значение hasBadHistory
        this.hasBadHistory = hasBadHistory;
        // СТРОКА 29: Сохраняем значение hasProblemWithLaw
        this.hasProblemWithLaw = hasProblemWithLaw;
    } // СТРОКА 30: Закрываем конструктор

    // СТРОКА 31: Переопределяем метод checkClientForCredit

    @Override
    // СТРОКА 32: Метод проверки клиента
    public boolean checkClientForCredit(BankClient client)
        // СТРОКА 33: Метод может выбросить оба исключения
            throws BadCreditHistoryException, ProblemWithLawException {

        // СТРОКА 34: Проверяем, есть ли проблемы с кредитной историей
        // Если есть — выбрасываем исключение
        // if — условный оператор
        if (hasBadHistory) {
            // СТРОКА 35: Выбрасываем исключение BadCreditHistoryException
            // Сообщаем, что у клиента плохая история
            // throw — ключевое слово для выбрасывания исключения
            // new — создаем объект исключения с сообщением
            throw new BadCreditHistoryException("Плохая кредитная история у " + client.getName());
        } // СТРОКА 36: Закрываем if

        // СТРОКА 37: Проверяем, есть ли проблемы с законом
        if (hasProblemWithLaw) {
            // СТРОКА 38: Выбрасываем исключение ProblemWithLawException
            // Сообщаем, что у клиента проблемы с законом
            throw new ProblemWithLawException("Проблемы с законом у " + client.getName());
        } // СТРОКА 39: Закрываем if

        // СТРОКА 40: Если проблем нет — возвращаем true
        return true;
    } // СТРОКА 41: Закрываем метод checkClientForCredit
} // СТРОКА 42: Закрываем класс SimpleBankWorker



// ЧАСТЬ 5: МЕТОД getCreditForClient (основной метод задачи)


// СТРОКА 43: Класс CreditService для работы с кредитами
// Содержит метод getCreditForClient
class CreditService {
    // СТРОКА 44: Метод getCreditForClient
    public static boolean getCreditForClient(BankWorker worker, BankClient client) {

        // СТРОКА 45: Блок try — пытаемся выполнить проверку
        // Метод может выбросить исключения, их нужно перехватить
        try {
            // СТРОКА 46: Вызываем метод проверки у работника
            // Если проблем нет — возвращаем true
            return worker.checkClientForCredit(client);

            // СТРОКА 47: Перехватываем BadCreditHistoryException
            // Если клиенту отказали из-за плохой истории
            // catch — перехват исключения
            // BadCreditHistoryException e — переменная с объектом исключения
        } catch (BadCreditHistoryException e) {
            // СТРОКА 48: Выводим сообщение о проблемах с историей
            // По условию задачи нужно вывести это сообщение
            System.out.println("Проблемы с банковской историей");
            // СТРОКА 49: Возвращаем false (кредит не одобрен)
            return false;

            // СТРОКА 50: Перехватываем ProblemWithLawException
            // ЗАЧЕМ: Если клиенту отказали из-за проблем с законом
        } catch (ProblemWithLawException e) {
            // СТРОКА 51: Возвращаем false (кредит не одобрен)
            return false;

        } // СТРОКА 52: Закрываем catch
    } // СТРОКА 53: Закрываем метод getCreditForClient
} // СТРОКА 54: Закрываем класс CreditService


// СТРОКА 55: Главный класс HelloWorld

public class Bank {
    public static void main(String[] args) {
        // СТРОКА 57: Создаем клиента с именем "Иван"
        // Для теста хорошего клиента
        BankClient client1 = new BankClient("Иван");
        // СТРОКА 58: Создаем клиента с именем "Петр"
        // Для теста с плохой историей
        BankClient client2 = new BankClient("Петр");
        // СТРОКА 59: Создаем клиента с именем "Сидор"
        // Для теста с проблемами с законом
        BankClient client3 = new BankClient("Сидор");

        // СТРОКА 60: Выводим заголовок первого теста
        System.out.println("ТЕСТ 1: Хороший клиент");

        // СТРОКА 61: Создаем работника без проблем (false, false)
        // Работник, который одобряет кредит
        BankWorker workerGood = new SimpleBankWorker(false, false);
        // СТРОКА 62: Проверяем кредит для клиента 1
        // Получаем результат проверки
        boolean result1 = CreditService.getCreditForClient(workerGood, client1);
        // СТРОКА 63: Выводим результат
        System.out.println("Кредит одобрен: " + result1);

        // СТРОКА 64: Выводим заголовок второго теста
        System.out.println("\n ТЕСТ 2: Плохая кредитная история ");
        // СТРОКА 65: Создаем работника с проблемами истории (true, false)
        // ЗАЧЕМ: Работник, который откажет из-за истории
        BankWorker workerBadHistory = new SimpleBankWorker(true, false);
        // СТРОКА 66: Проверяем кредит для клиента 2
        boolean result2 = CreditService.getCreditForClient(workerBadHistory, client2);
        // СТРОКА 67: Выводим результат
        System.out.println("Кредит одобрен: " + result2);

        // СТРОКА 68: Выводим заголовок третьего теста
        System.out.println("\n=== ТЕСТ 3: Проблемы с законом ===");

        // СТРОКА 69: Создаем работника с проблемами с законом (false, true)
        // ЗАЧЕМ: Работник, который откажет из-за закона
        BankWorker workerLawProblem = new SimpleBankWorker(false, true);

        // СТРОКА 70: Проверяем кредит для клиента 3
        boolean result3 = CreditService.getCreditForClient(workerLawProblem, client3);
        // СТРОКА 71: Выводим результат
        System.out.println("Кредит одобрен: " + result3);
    } // СТРОКА 72: Закрываем метод main
} // СТРОКА 73: Закрываем класс HelloWorld


