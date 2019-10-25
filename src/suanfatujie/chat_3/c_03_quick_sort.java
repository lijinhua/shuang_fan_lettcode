package suanfatujie.chat_3;

/**
 * 快速排序
 *
 * 快速排序的原理：
 * 快速排序是一种常用的排序算法，比选择排序快得多。例如，C语言标准库中的函数qsort 实现的就是快速排序
 *
 * 选择一个关键值作为基准值。比基准值小的都在左边序列（一般是无序的），
 * 比基准值大的都在右边（一般是无序的）。一般选择序列的第一个元素
 *
 * https://blog.csdn.net/u014241071/article/details/81565148
 *
 * 快速排序之所比较快，因为相比冒泡排序，每次交换是跳跃式的。每次排序的时候设置一个基准点，将小于等于基准点的数全部放到基准点的左边，
 * 将大于等于基准点的数全部放到基准点的右边。这样在每次交换的时候就不会像冒泡排序一样每次只能在相邻的数之间进行交换，交换的距离就大的多了。
 * 因此总的比较和交换次数就少了，速度自然就提高了。当然在最坏的情况下，仍可能是相邻的两个数进行了交换。
 * 因此快速排序的最差时间复杂度和冒泡排序是一样的都是O(N2)，它的平均时间复杂度为O(NlogN)。
 * 其实快速排序是基于一种叫做“二分”的思想。我们后面还会遇到“二分”思想，到时候再聊
 */
public class c_03_quick_sort {

    /**
     *
     * @param arr 需要排序的数组
     * @param low 开始时最左边的索引=0
     * @param high 开始时最右边的索引=arr.length-1
     */
    public static void quickSort(int[] arr,int low,int high){
        if(low>high){
            return;
        }
        int i,j,temp,t;
        i=low;//左边哨兵的索引
        j=high;//右边哨兵的索引
        //temp就是基准位
        temp = arr[low];//以最左边为  基准位

        while (i<j)
        {
            // 先看右边，依次往左递减
            // 先从右往左找一个小于 基准位的数
            // 当右边的哨兵位置所在的数>基准位的数 时继续从右往左找（同时 j 索引-1）找到后会跳出 while循环

            while (temp<=arr[j] && i<j){
                j--;
            }

            //再看左边，依次往右递增,步骤和上面类似
            while (temp>=arr[i]&&i<j) {
                i++;
            }

            //如果满足条件则交换
            if (i<j)
            {
                //z、y 都是临时参数，用于存放 左右哨兵 所在位置的数据
                 int z = arr[i];
               int  y = arr[j];

                // 左右哨兵 交换数据（互相持有对方的数据）
                arr[i] = y;
                arr[j] = z;
            }
        }

        //这时 跳出了 “while (i<j) {}” 循环 说明 i=j 左右在同一位置
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];// #或 arr[low] = arr[j];
        arr[i] = temp;// #或 arr[j] = temp;

        //i=j
        //这时  左半数组<(i或j所在索引的数)<右半数组
        //也就是说(i或j所在索引的数)已经确定排序位置， 所以就不用再排序了，
        // 只要用相同的方法 分别处理  左右数组就可以了

        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);
    }


    public static void main(String[] args){
        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        quickSort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
