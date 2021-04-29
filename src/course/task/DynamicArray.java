package course.task;

import java.util.Arrays;

/**
 * Динамический массив
 */
public class DynamicArray extends course.task.StaticArray implements Dynamic {

    private static final int DEFAULT_CAPACITY = 10;
    private static final float GROW_FACTOR = 1.5f;

    /**
     * текущая длина массива
     */
    private int size;

    public DynamicArray() {
        super(new int[DEFAULT_CAPACITY]);
        size = 0;
    }

    public DynamicArray(int[] array) {
        super(array);
        size = array.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(int value) {
        // TODO: добавить элемент в конец массива
            int[] b = new int[array.length+1];
            b[array.length] = value;
            for (int i = 0; i < array.length; i++) {
                b[i] = array[i];
            }
            array = b;
    }

    @Override
    public void add(int index, int value) {
        // TODO: добавить элемент в указанный индекс (остальные сдвинуть вправо)
        int[] b = new int[array.length + 1];
        System.arraycopy(array, 0, b, 0, index);
        System.arraycopy(array, index, b, index + 1, array.length - index);
        b[index] = value;
        array = b;
    }

    @Override
    public void addAll(Array array) {
        // TODO: конкатенация с переданным массивом
        int[] concatArray = new int[this.array.length + array.size()];
        int count = 0;
        for (int i = 0; i < this.array.length; i++) {
            concatArray[i] = this.array[i];
            count++;
        }
        for (int j = 0; j < array.size(); j++) {
            concatArray[j + count] = array.get(j);
        }
        this.array = concatArray;
    }

    @Override
    public boolean remove(int value) {
        // TODO: удалить элемент из массива

        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                int[] copy = new int[array.length - 1];
                System.arraycopy(array, 0, copy, 0, i);
                System.arraycopy(array, i + 1, copy, i, array.length - i - 1);
                array=copy;
            }
        }
        return true;
    }


    @Override
    public boolean removeAll(int[] values) {
        // TODO: удалить все указанные элементы из массива
        int count = 0;
        for (int j = 0; j < values.length; j++) {
            remove(values[j]);
            count++;
        }
        if (count > 0) return true;
        return false;
    }

    @Override
    public int removeOf(int index) {
        // удалить элемент по индексу
        int[] copy = new int[array.length - 1];
        System.arraycopy(array, 0, copy, 0, index);
        System.arraycopy(array, index + 1, copy, index, array.length - index - 1);
        array=copy;
        return 1;
    }
}