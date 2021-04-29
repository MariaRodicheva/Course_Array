package course.task;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 7, 8, 5, 6, 9, 8};
        int[] b = new int[]{10, 13, 17, 18, 15, 16, 19, 18};


        var staticArray = new course.task.StaticArray(a);
        System.out.println(staticArray);

        System.out.println(staticArray.toString());
        staticArray.sort();
        System.out.println(staticArray);
        staticArray.reverse();
        System.out.println(staticArray.lastIndexOf(5));
        System.out.println();

        var sortedArray = new SortedArray(a);
        System.out.println(sortedArray);
        System.out.println(sortedArray.isAscSorted());
        System.out.println(sortedArray.lastIndexOf(6));
        System.out.println();

        int k = sortedArray.lastIndexOf(8);
        System.out.println(k);

        System.out.println(sortedArray.merge(a, b));


        var dynamicArray = new DynamicArray(a);
        dynamicArray.add(5);
        dynamicArray.add(10);
        System.out.println(dynamicArray);
        dynamicArray.add(2, 10);
        System.out.println(dynamicArray);


        int[] x = {1, 3, 4, 5};
        dynamicArray.removeAll(x);
        System.out.println(dynamicArray);

        dynamicArray.removeOf(2);

        System.out.println(dynamicArray);
        System.out.println();


        int[] m = {19, 1, 3, 4};
        int[] y = {5, 4, 6, 16, 7, 7, 9};
        int[] z = {8, 10, 1, 12, 11};
        int[] w = {14, 13, 2, 17, 18, 1};


        // Сортировка, используя Collections.sort
        ArrayList<int[]> list = new ArrayList<>();
        ArrayList<Integer> sortList;
        list.add(m);
        list.add(y);
        list.add(z);
        list.add(w);

        sortList = SortedArray.mergeAll2(list); //, true);

        int[] finish = new int[sortList.size()];
        for (int i = 0; i < finish.length; i++) {
            finish[i] = sortList.get(i);
            System.out.print(finish[i] + " ");
        }


    }
}
