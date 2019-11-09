package css.com.datastructureandalgorithms;

/**
 * 表：能存放n个大小的相同元素的抽象数据类型
 */
public class CssList {
    private int[] content;
    private int size;

    public int size() {
        return size;
    }

    public void printList() {
        if (content != null) {
            for (int i : content) {
                System.out.println(i);
            }
        }
    }

    public void makeEmpty() {
        content = null;
        size = 0;
    }

    /**
     * @param element 查找元素
     * @return 元素第一次出现的位置
     */
    public int find(int element) {
        if (content != null) {
            for (int i = 0; i < content.length; i++) {
                if (element == content[i]) return i;
            }
        }
        return -1;
    }

    public void add(int element) {
        int[] temp = new int[size + 1];
        if (content != null) {
            for (int i = 0; i < size; i++) {
                temp[i] = content[i];
            }
        }
        temp[size] = element;
        content = temp;
        size++;
    }

    /**
     *
     * @param index 新数组下标
     * @param element 新元素
     */
    public void insert(int index, int element) {
        if (index > size || index < 0) {
            throw new RuntimeException("index out of size");
        }
        if (size == 0) {
            content = new int[]{element};
        } else {
            int[] temp = new int[size + 1];
            if (index == 0) {
                temp[0] = element;
                for (int i = 0; i < size; i++) {
                    temp[i + 1] = content[i];
                }
            } else if (index == size) {
                for (int i = 0; i < size; i++) {
                    temp[i] = content[i];
                }
                temp[size] = element;
            } else {
                for (int i = 0; i < index; i++) {
                    temp[i] = content[i];
                }
                temp[index] = element;
                for (int i = index + 1; i < size; i++) {
                    temp[i] = content[i - 1];
                }
            }
            content = temp;
        }
        size++;
    }

    /**
     *
     * @param index 数组下标
     */
    public void remove(int index) {
        if (index > size-1 || index < 0) {
            throw new RuntimeException("index out of size");
        }
        int[] temp = new int[size - 1];
        int preIndex = index - 1;
        int suffixIndex = index + 1;
        if (preIndex > 0) {
            for (int i = 0; i <= preIndex; i++) {
                temp[i] = content[i];
            }
        }
        if (suffixIndex < size) {
            for (int i = suffixIndex; i < size; i++) {
                temp[i - 1] = content[i];
            }
        }
        content = temp;
        size--;
    }

    public static void main(String[] args) {

    }

    private void testRemove(){
        //这么测试一看，其实insert比remove要多出一个索引
        CssList cssList = new CssList();
        for (int i = 0; i < 10; i++) {
            cssList.add(i);
        }
        cssList.remove(0);
        cssList.printList();
        System.out.println("----");
        cssList.remove(5);
        cssList.printList();
        System.out.println("----");
        cssList.remove(10 - 2-1);
        cssList.printList();
        System.out.println("----");
    }


}
