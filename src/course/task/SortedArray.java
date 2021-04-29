package course.task;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Сортированный статический массив (по возрастанию).
 *
 * Любая операция должна гарантировать, что массив, по ее окончании, отстортирован
 */
public class SortedArray extends course.task.StaticArray {

    public SortedArray(int[] array) {
        super(array);
        if (!isAscSorted()) {
            sort();
        }
    }



    @Override
    public boolean contains(int value) {
        return binarySearch(value, 0, array.length) != -1;
    }

    @Override
    public int set(int index, int value) {
        // TODO: присовить значение по индексу
        array[index] = value;
        return 0;
    }

    @Override
    public int indexOf(int value) {
        return binarySearch(value, 0, array.length - 1);
    }

    @Override
    public int lastIndexOf(int value) {
        // TODO: получить индекс последнего подходящего элемента
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == value) return i;
        }
        return -1;
    }

    @Override
    public void sort() {
        int sorted = 0;
        int temp = 0;
        while (sorted == 0) {
            sorted = 1;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    sorted = 0;
                }
            }
        }
    }

    @Override
    public void sort(ArraySort sort) {
    }

    private int binarySearch(int value, int left, int right) {
        // TODO: реализовать бинарный поиск
        int position;
        int comparisonCount = 1;    // для подсчета количества сравнений

        // для начала найдем индекс среднего элемента массива
        position = (left + right) / 2;

        while ((array[position] != value) && (left <= value)) {
            comparisonCount++;
            if (array[position] > value) {  // если число заданного для поиска
                right = position - 1; // уменьшаем позицию на 1.
            } else {
                left = position + 1;    // иначе увеличиваем на 1
            }
            position = (value + right) / 2;
        }
        if (left <= right) return ++position;
        else return -1;
    }

    public SortedArray merge(int[] a, int[] b) {
        // TODO: произвести слиянеие двух сортированных массивов

        int[] result = new int[a.length + b.length];
        //var sortedArray = new SortedArray(result);

        int i = 0, j = 0;
        while (i < a.length && j < b.length){
            if (a[i] < b[j]) {
                result[i + j] = a[i];
                i++;
            } else {
                result[i + j] = b[j];
                j++;
            }
        }

        for (int k = i; k < a.length; k++) {
            result[j + k] = a[k];
        }
        for (int k = j; k < b.length; k++) {
            result[i + k] = b[k];
        }
        array=result;
        return this;

    }

        // TODO: произвести слиянеие N + 1 сортированных массивов, используя Collections.sort
        public static ArrayList mergeAll2(ArrayList<int[]> list) {
        {
            ArrayList<Integer> sortList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                int[] l = list.get(i);
                for (int j = 0; j < l.length; j++) {
                    sortList.add(l[j]);
                }
            }
            Collections.sort(sortList);

            return sortList;
        }
    }

    // TODO: произвести слиянеие N + 1 сортированных массивов
    public SortedArray mergeAll(SortedArray... others) {

        int cout = 0;
        int length = 0;
        int[] arrayMarge = new int[length];

        for (int i = 0; i < others.length; i++) {
            length += others[i].size();
        }
        for (int i = 0; i < others.length; i++) {
            for (int j = 0; j < others[i].size(); j++) {
                arrayMarge[cout + j] = others[i].get(j);
            }
            cout+=others[i].size();
        }
        array = arrayMarge;
        return this;
    }
}