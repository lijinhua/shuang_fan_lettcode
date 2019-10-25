package suanfatujie.chat_2;

/**
 * 选择排序
 * 链表
 * 链表的每个元素都存储了下一个元素的地址，从而使一系列随机的内存地址串在一起
 * 链表的优势在插入元素方面，
 *
 * 数组
 * 地址连续，获取元素数组的效率很高
 *
 * 原理：每一趟从待排序的记录中选出最小的元素，顺序放在已排好序的序列最后，直到全部记录排序完毕。
 *     也就是：每一趟在n-i+1(i=1，2，…n-1)个记录中选取关键字最小的记录作为有序序列中第i个记
 *
 * 简单排序的时间复杂度为 O(N2)
 */
public class c_02_selectSort {

    public static void main(String[] args){
        int[] arr={1,3,2,45,65,33,12};
        System.out.println("交换之前：");
        for(int num:arr){
            System.out.print(num+" ");
        }
        for(int i=0;i<arr.length-1;i++){
            int k = i;// 记录最小的下标值
            for(int j=k+1;j<arr.length;j++){

                if(arr[j]<arr[k]){
                    // 后面的值，比那个值还要小，就记录下标
                    k = j;
                }
            }
            //在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
            if(i!=k){
                int value = arr[i];
                arr[i] = arr[k];
                arr[k] = value;
            }


        }

        System.out.println();
        System.out.println("交换后：");
        for(int num:arr){
            System.out.print(num+" ");
        }
    }

}
