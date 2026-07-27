// Импортируем классы для работы с множествами
import java.util.HashSet;   // Реализация Set (хранит уникальные элементы)
import java.util.Set;// Интерфейс Set (тип возвращаемого значения)
import java.util.Iterator;

public class HelloWorld {
    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        //1.Создаём новое множество result на основе set1
        //Чтобы НЕ изменять входные множества (set1 и set2)
        //new HashSet<>(set1) - копирует все элементы из set1 в новое множество
        Set<T> result = new HashSet<>(set1);
        //Создаём итератор для множества set2.
        //Итератор - это специальный объект, который позволяет перебирать элементы коллекции
        //по одному, безопасно и с контролем
        Iterator<? extends T> iterator = set2.iterator();
        // Запускаем цикл while, который будет выполняться, пока в итераторе есть элементы.
        // iterator.hasNext() - возвращает true, если есть ещё непройденные элементы.
        while (iterator.hasNext()) {
            //Получаем следующий элемент из итератора и сохраняем его в переменную element.
            //iterator.next() - возвращает текущий элемент и переводит итератор на следующий.
            //Важно:мы не изменяем set2, только читаем из него.
            T element = iterator.next();
            //Проверяем условие: есть ли этот элемент в множестве result.
            //result.contains(element) - возвращает если элемент уже есть.
            //Если есть это значит,что элемент есть в обоих множествах (пересечение).
            if (result.contains(element)) {
                //Если элемент найден в result, значит он есть и в set2 и в result.
                //В симметрической разности пересечения не нужны, поэтому удаляем его из result.
                //result.remove(element) - удаляет элемент из result.
                result.remove(element);
            } else {
                //Если элемента нет в result,значит он уникален для set2,
                //мы добавляем его в result, чтобы включить в симметрическую разность.
                // result.add(element) - добавляет новый элемент в result.
                result.add(element);
            }
        }
        //Возвращаем итоговое множество result.
        //Теперь оно содержит элементы, которые есть только в set1 или только в set2.
        return result;
    }

    public static void main(String[] args) {
        //1.Создаём первое множество
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        //2.Создаём второе множество
        Set<Integer> set2 = new HashSet<>();
        set2.add(0);
        set2.add(1);
        set2.add(2);

        //3.Вызываем метод symmetricDifference
        Set<Integer> result = symmetricDifference(set1, set2);
        //4.Выводим результат
        System.out.println("set1: " + set1);
        System.out.println("set2: " + set2);
        System.out.println("Симметрическая разность: " + result);
    }
}


