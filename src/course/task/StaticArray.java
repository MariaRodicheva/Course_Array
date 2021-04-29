package course.task;

import java.util.Arrays;

/**
 * Обертка над статическим массивом
 */
public class StaticArray implements Array {

    protected int[] array;

    public StaticArray(int[] a) {
        this.array = new int[a.length];
        System.arraycopy(a, 0, this.array, 0, a.length);
    }

    @Override
    public int size() {
        // TODO: вернуть длину массива
        return array.length;
    }

    @Override
    public boolean contains(int value) {
        // TODO: проверить, что элемент есть в массиве
        for (int i=0;i>size()-1; i++){
            if (array[i]==i) return true;
        }
        return false;
    }

    @Override
    public int get(int index) {
        // TODO: получить элемент по индексу
        return array[index];
    }

    @Override
    public int set(int index, int value) {
        // TODO: присвоить значение по индексу. Вернуть значение элемента, которое заменили
        int result = array[index];
        array[index]=value;
        return result;
    }

    @Override
    public int indexOf(int value) {
        // TODO: получить индекс первого подходящего элемента
        for (int i=0;i<size()-1;i++){
            if (array[i]==value) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(int value) {
        // TODO: получить индекс последнего подходящего элемента
        for (int i=array.length-1; i>=0; i--){
            if (array[i]==value) return i;
        }
        return -1;
    }

    @Override
    public void reverse() {
        // TODO: перевернуть массив
        int[] array2 = new int[array.length];
        for (int i = array.length-1; i > 0;) {
            for (int j = 0; j < array.length; j++) {
                array2[j] = array[i];
                i--;
            }
        }
        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i]+" ");
        }
        System.out.println();
    }

    @Override
    public Array subArray(int fromIndex, int toIndex) {
        // TODO: вернуть подмассив, начиная с индекса fromIndex включительно и заканчивая индексом toIndex невкоючительно
        Array[] array2 = new Array[toIndex-fromIndex-1];
        //Array staticArray = new course.task.StaticArray(array2);

        System.arraycopy(array, fromIndex, array2, 0, toIndex-fromIndex);
        if (array!=null) {
            System.out.print(array2+" ");
        }
        return null;
    }

    @Override
    public void sort() {
        insertionSort();
    }

    @Override
    public void sort(ArraySort sort) {
        switch (sort) {
            case BUBBLE:
                bubbleSort();
                break;
            case INSERTION:
            case SELECTION:
            case MERGE:
            case QUICK:
            default:
                sort();
        }
    }

    @Override
    public String toString() {
        // TODO: вернуть массив в виде строки. Например, [3, 4, 6, -2]
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    private void bubbleSort() {
        // TODO: сортировка пузырьком (по возрастанию)
        boolean sorted = false;
        int temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    sorted = false;
                }
            }
        }
    }

    private void insertionSort() {
        //TODO*: сортировка вставками (по возрастанию)
        int n = array.length;

        for (int i = 1; i < n; i++)
        {
            int key = array[i];
            int j = i-1;

            while ( (j > -1)&&( array [j] > key ) )
            {
                array [j+1] = array [j];
                j--;
            }
            array[j+1] = key;
        }
    }

    private void selectionSort() {
        //TODO*: сортировка выбором (по возрастанию)
        for (int i = 0; i < array.length; i++) {

            int min = array[i];
            int min_i = i;

            for (int j = i+1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    min_i = j;
                }
            }

            if (i != min_i) {
                int tmp = array[i];
                array[i] = array[min_i];
                array[min_i] = tmp;
            }
        }
    }

    private void mergeSort(int lo, int hi) {
        //TODO**: сортировка слиянием (по возрастанию)

        if (hi <= lo)
            return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(lo, mid);
        mergeSort(mid + 1, hi);

        int[] buf = Arrays.copyOf(array, array.length);

        for (int k = lo; k <= hi; k++)
            buf[k] = array[k];

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {

            if (i > mid) {
                array[k] = buf[j];
                j++;
            } else if (j > hi) {
                array[k] = buf[i];
                i++;
            } else if (buf[j] < buf[i]) {
                array[k] = buf[j];
                j++;
            } else {
                array[k] = buf[i];
                i++;
            }
        }
    }


        //TODO**: быстрая сортировка (по возрастанию)
        public static void quickSort(int[] array, int low, int high) {
            if (array.length == 0)
                return;//завершить выполнение если длина массива равна 0

            if (low >= high)
                return;//завершить выполнение если уже нечего делить

            // выбрать опорный элемент
            int middle = low + (high - low) / 2;
            int op = array[middle];

            // разделить на подмассивы, который больше и меньше опорного элемента
            int i = low, j = high;
            while (i <= j) {
                while (array[i] < op) {
                    i++;
                }

                while (array[j] > op) {
                    j--;
                }

                if (i <= j) {//меняем местами
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    i++;
                    j--;
                }
            }

            // вызов рекурсии для сортировки левой и правой части
            if (low < j)
                quickSort(array, low, j);

            if (high > i)
                quickSort(array, i, high);
        }

    public boolean isAscSorted() {
        // TODO: проверить, что массив отсортирован по возрастанию
        for (int i=0; i< array.length-1; i++){
            if (array[i] < array[i+1]) i++;
            else return false;
        }
            return true;
    }
}
