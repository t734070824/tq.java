package _leetcode._easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * @author 734070824@qq.com
 * @date 2019/2/27 14:36
 */
public class Two_Sum {

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

    /**
     * 一遍哈希表
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum_2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int com = target - nums[i];
            if(map.containsKey(com)){
                return new int[]{map.get(com), i};
            }
            map.put(nums[i], com);
        }
        return nums;
    }

    @Test
    public void test(){
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        Two_Sum  sum = new Two_Sum();
        int[] ints = sum.twoSum(arr, target);
        Assert.assertEquals(0, ints[0]);
        Assert.assertEquals(1, ints[1]);
    }


}
