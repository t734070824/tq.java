package _arithmetic;

/**
 * 中位数
 * @author 734070824@qq.com
 * @date 2019/1/7 19:40
 */
public class Median {

    /**
     * 给定一个未排序的整数数组，找到其中位数。

     中位数是排序后数组的中间值，如果数组的个数是偶数个，则返回排序后数组的第N/2个数。

     样例
     给出数组[4, 5, 1, 2, 3]， 返回 3

     给出数组[7, 9, 4, 5]，返回 5

     挑战
     时间复杂度为O(n)
     * @param nums: A list of integers
     * @return: An integer denotes the middle number of the array
     */
    public int median(int[] nums) {

        return nums[nums.length/2];
    }
}
