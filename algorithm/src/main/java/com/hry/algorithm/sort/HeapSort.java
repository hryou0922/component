package com.hry.algorithm.sort;

/**
 *
 *  堆排序是一种树形选择排序，在排序过程中可以把元素看成是一颗完全二叉树，每个节点都大（小）于它的两个子节点，当每个节点都大于等于它的两个子节点时，就称为大顶堆，也叫堆有序； 当每个节点都小于等于它的两个子节点时，就称为小顶堆
 *  将待排序的序列构造成一个大顶堆。此时，整个序列的最大值就是堆顶的根节点。将它移走(其实就是将其与堆数组的末尾元素交换，此时末尾元素就是最大值)，然后将剩余的n-1个序列重新构造成一个堆，这样就会得到n个元素中的次最大值。如此反复执行，就能得到一个有序序列了
 *
 *  https://blog.csdn.net/as02446418/article/details/47699547
 *  https://blog.csdn.net/zdp072/article/details/44227317
 *  https://blog.csdn.net/MoreWindows/article/details/6709644 重点
 *
 *  由于每次重新恢复堆的时间复杂度为O(logN)，共N - 1次重新恢复堆操作，再加上前面建立堆时N / 2次向下调整，每次调整时间复杂度也为O(logN)。二次操作时间相加还是O(N * logN)。故堆排序的时间复杂度为O(N * logN)。
 *
 *  堆排序
 *  a. 堆的存储：一般都用数组来表示堆，i结点(i从0开始)，i结点的父结点下标就为(i–1)/2, 它的左右子结点下标分别为 2*i+1 和 2*i+2 。如第0个结点左右子结点下标分别为1和2。
 *  b. 堆的生成：根据初始队列生成堆，从下向上调整
 *  c. 堆的删除：将第0个节点和数组最后一个值交互，重新生成堆，开始进行一次从上向下的调整
 *
 *  堆化数组：
 *  a. 可以对以上操作简化
 *
 *
 *
 * @author: huangrongyou@yixin.im
 * @date: 2019/8/23 9:32
 */
public class HeapSort implements ISort{

    @Override
    public int[] sortArray(int[] intArray) {
        if(intArray == null || intArray.length == 0){
            return intArray;
        }

        // 生成第一个打堆: 堆化数据，从倒数第一个非叶子节点开始，由 i结点的它的左右子结点下标分别为 2*i+1 和 2*i+2，得知其值为 (i-1)/2
        for(int i = (intArray.length-1)/2; i >=0; i-- ){
            minHeapFix(intArray, i, intArray.length);
        }

        // 循环 length-1 次
        for(int i = intArray.length-1 ; i > 0; i-- ){
            swap(intArray, 0, i);
            // 最后一个元素不参与排序
            minHeapFix(intArray, 0, i);
        }
        return intArray;
    }

    /**
     * 对数组中指定节点开始做为大堆的头，并进行排序
     *  这是从上向下的调整
     * @param intArray
     * @param treeRootIndex
     * @param length 排序数组的长度
     */
    private void minHeapFix(int[] intArray, int treeRootIndex, int length){
        // 当前判断节点
        int currentIndex = treeRootIndex;

        // 比 (length-1)/2 都是叶子节点，不需要执行比较
        while(currentIndex <= (length-1)/2 ){
            // 左节点
            int leftIndex = 2 * currentIndex + 1;
            // 右节点
            int rightIndex = leftIndex + 1;
            // 两个节点中大的值
            int childMaxIndex = leftIndex;
            if(leftIndex >= length){
                break;
            }
            // 先比较左右两个取最大值，然后和父节点比较取最大值，保证父节点为最大值
            if (rightIndex < length) {
                if (intArray[rightIndex] > intArray[leftIndex]) {
                    childMaxIndex = rightIndex;
                }
            }
            // 和 父节点 比较
            if (intArray[currentIndex] < intArray[childMaxIndex]) {
                swap(intArray, currentIndex, childMaxIndex);
                // 判断下一个节点是否为大堆
                currentIndex = childMaxIndex;
            }else {
                // 如果不需要交互，则标识堆已经完成，结束循环
                break;
            }
        }
    }

    private void swap(int[] intArray, int currentIndex, int childMaxIndex) {
        int tmp = intArray[currentIndex];
        intArray[currentIndex] = intArray[childMaxIndex];
        intArray[childMaxIndex] = tmp;
    }
}
