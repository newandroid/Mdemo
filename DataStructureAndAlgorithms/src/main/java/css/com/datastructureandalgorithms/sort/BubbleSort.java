package css.com.datastructureandalgorithms.sort;

/**
 * Created by Administrator on 2018/2/7.
 */

public class BubbleSort {

    public void sort(int[] dataSource) {
        for (int j = 0; j < dataSource.length - 1; j++) {
            for (int i = 0; i < dataSource.length - 1 - j; i++) {
                if (dataSource[i] > dataSource[i + 1]) {
                    int tmp;
                    tmp = dataSource[i + 1];
                    dataSource[i + 1] = dataSource[i];
                    dataSource[i] = tmp;
                }
            }
        }


    }
}
