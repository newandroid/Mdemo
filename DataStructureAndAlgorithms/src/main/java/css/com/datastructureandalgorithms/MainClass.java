package css.com.datastructureandalgorithms;

import java.util.Random;

import css.com.datastructureandalgorithms.sort.BubbleSort;

public class MainClass {
    int[] dataSource = new int[10];

    public MainClass() {
        Random random = new Random();
        for (int i = 0; i < dataSource.length; i++) {
            dataSource[i] = random.nextInt(dataSource.length);
        }
    }

    public void sort() {
        printData();
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(dataSource);
        System.out.println("");
        printData();

    }

    void printData() {
        for (int src : dataSource) {
            System.out.print(" " + src);
        }
    }
}
