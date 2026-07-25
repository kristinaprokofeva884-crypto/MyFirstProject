// Импортируем классы для работы с множествами
import java.util.HashSet;   // Реализация Set (хранит уникальные элементы)
import java.util.Set;       // Интерфейс Set (тип возвращаемого значения)

public class HelloWorld {
    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        //1.Создаём новое множество result на основе set1
        //Чтобы НЕ изменять входные множества (set1 и set2)
        //new HashSet<>(set1) - копирует все элементы из set1 в новое множество
        Set<T> result = new HashSet<>(set1);
        //2.Проходим по каждому элементу из set2 по индексу
        //set2.size() - возвращает количество элементов в множестве.
        for(T element : set2) {
            //3.Проверяем,есть ли этот элемент в result (копии set1)
            //result.contains(element) - возвращает true,если элемент уже есть
            if (result.contains(element)) {
                result.remove(element);
                //4.Если элемент есть в result - это пересечение
                //Нам это не нужно
                //Поэтому удаляем этот элемент из result
            } else {
                //5.Если элемента нет в result - это элемент только из set2
                //Добавляем его в result(симметрическая разность)
                result.add(element);
            }
        }
        //6.Возвращаем результат в которм элементы,которые есть только в set1 или только в set2
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