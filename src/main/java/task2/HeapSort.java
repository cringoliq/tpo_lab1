package task2;

import java.util.Arrays;

public class HeapSort {

    /**
     * Сортирует массив с использованием алгоритма HeapSort с логированием ключевых шагов.
     *
     * @param arr исходный массив для сортировки
     */
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // 1. Построение кучи
        System.out.println("Построение кучи:");
        for (int i = n / 2 - 1; i >= 0; i--) {
            System.out.println("  Вызываем heapify для индекса " + i + " (значение " + arr[i] + ")");
            heapify(arr, n, i);
            System.out.println("  Текущее состояние массива: " + Arrays.toString(arr));
        }
        System.out.println("Куча построена: " + Arrays.toString(arr));
        System.out.println("--------------------------------------------------");

        // 2. Извлечение элементов из кучи и сортировка
        System.out.println("Сортировка массива (извлечение элементов):");
        for (int i = n - 1; i > 0; i--) {
            System.out.println("  Обмен элементов: " + arr[0] + " и " + arr[i]);
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            System.out.println("  Массив после обмена: " + Arrays.toString(arr));

            System.out.println("  Вызов heapify для корня с размером кучи = " + i);
            heapify(arr, i, 0);
            System.out.println("  Состояние кучи: " + Arrays.toString(Arrays.copyOf(arr, i)));
            System.out.println("  Отсортированная часть: " + Arrays.toString(Arrays.copyOfRange(arr, i, n)));
            System.out.println("--------------------------------------------------");
        }
    }

    /**
     * Метод для восстановления свойства максимальной кучи.
     *
     * @param arr массив, для которого выполняется heapify
     * @param n   размер неотсортированной части массива (кучи)
     * @param i   индекс текущего элемента
     */
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;       // Изначально считаем, что корень является наибольшим
        int left = 2 * i + 1;    // Левый дочерний элемент
        int right = 2 * i + 2;   // Правый дочерний элемент

        // Если левый дочерний элемент больше корня
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        // Если правый дочерний элемент больше текущего наибольшего
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        // Если наибольший не корень, меняем их местами и рекурсивно вызываем heapify
        if (largest != i) {
            System.out.println("    Обмен элементов: " + arr[i] + " и " + arr[largest] +
                    " для восстановления кучи.");
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }
}
