package croc.task1;

import java.util.Arrays;

/**
 * Задача 1.
 * Перестановка в массиве
 * <p>
 * Задан массив целых чисел.
 * Необходимо переставить наименьшее из этих чисел в начало массива,
 * а наибольшее - в конец.
 */
public class Main {

    public static void main(String[] args) {

        int[] v = new int[]{0, 6, 28, 1, 2, 4, 6, 8, 3, 5};
        System.out.println("До правки: " + Arrays.toString(v));
        changeOrder(v);
        System.out.println("После    : " + Arrays.toString(v));
    }


    /**
     * Меняет порядок в массиве.
     */
    public static void changeOrder(int[] array) {
        if (array.length == 0) {
            System.out.println("Массив пустой.");
            return;
        }


        int minElemIndex = getMinElemIndex(array);
        int firstElem = array[0];
        array[0] = array[minElemIndex];
        array[minElemIndex] = firstElem;

        int maxElemIndex = getMaxElemIndex(array);
        int lastElem = array[array.length - 1];
        array[array.length - 1] = array[maxElemIndex];
        array[maxElemIndex] = lastElem;
    }

    /**
     * Найдем номер максимального элемента.
     */
    public static int getMaxElemIndex(int[] array) {
        int maxElemIndex = 0;
        int maxElem = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxElem) {
                maxElem = array[i];
                maxElemIndex = i;
            }
        }
        return maxElemIndex;
    }

    /**
     * Найдем номер минимального элемента.
     */
    public static int getMinElemIndex(int[] array) {
        int minElemIndex = 0;
        int minElem = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < minElem) {
                minElem = array[i];
                minElemIndex = i;
            }
        }
        return minElemIndex;
    }

}
