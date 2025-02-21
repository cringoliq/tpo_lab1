package task2;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class HeapSortTest {

    @Test
    public void testStandardArray() {
        int[] arr = {4, 10, 3, 5, 1};
        int[] expected = {1, 3, 4, 5, 10}; // эталонное значение
        HeapSort.heapSort(arr);
        // Проверяем, что итоговый массив совпадает с ожидаемым
        assertArrayEquals("Стандартный массив должен быть отсортирован", expected, arr);
    }

    @Test
    public void testEmptyArray() {
        int[] arr = {};
        int[] expected = {}; // эталонное значение для пустого массива
        HeapSort.heapSort(arr);
        assertArrayEquals("Пустой массив должен оставаться пустым", expected, arr);
    }

    @Test
    public void testSingleElement() {
        int[] arr = {42};
        int[] expected = {42}; // эталонное значение для массива с одним элементом
        HeapSort.heapSort(arr);
        assertArrayEquals("Массив с одним элементом должен остаться неизменным", expected, arr);
    }

    @Test
    public void testDuplicateElements() {
        int[] arr = {7, 7, 7, 7};
        int[] expected = {7, 7, 7, 7}; // эталонное значение для массива с повторяющимися элементами
        HeapSort.heapSort(arr);
        assertArrayEquals("Массив с повторяющимися элементами должен остаться неизменным", expected, arr);
    }
}
