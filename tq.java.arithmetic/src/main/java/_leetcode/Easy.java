package _leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author 734070824@qq.com
 * @date 2019/1/7 19:50
 */
public class Easy {

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

     你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

     示例:

     给定 nums = [2, 7, 11, 15], target = 9

     因为 nums[0] + nums[1] = 2 + 7 = 9
     所以返回 [0, 1]
     方法
        1. 暴力
        2. 借用Hashmap
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return nums;
    }

    @Test
    public void twoSum_test(){
        int[] nums = {2, 7, 11, 15};
        Easy easy = new Easy();
        int[] ints = easy.twoSum(nums, 9);
        int[] ints1 = {0, 1};
        for (int i = 0; i < ints.length; i++) {
            Assert.assertEquals(ints1[i], ints[i]);
        }

    }
}
