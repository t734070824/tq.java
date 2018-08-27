package _arithmetic;

import java.util.Arrays;
import java.util.Stack;

/**
 * LintCode 简单
 * @author 734070824@qq.com
 * @date 2018/8/18 16:51
 */
public class Solution {



    /**
     * @param character: a character
     * @return: a character
     */
    public char lowercaseToUppercase(char character) {
        // write your code here
        return (char)(character-32);
    }


    /**
     * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
     * 可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
     * 例:
     * 定 nums = [2, 7, 11, 15], target = 9
     * 为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     * O(n^2)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return  result;
    }



    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

     示例 1:

     输入: 121
     输出: true
     示例 2:

     输入: -121
     输出: false
     解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     示例 3:

     输入: 10
     输出: false
     解释: 从右向左读, 为 01 。因此它不是一个回文数。
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        /*if(x < 0 ) return false;
        if(x == 0) return true;
        int len = 0;
        int[] arr = new int[100];
        while (x > 0){
            int pop = x % 10;
            x = x/10;
            arr[len] = pop;
            len ++;
        }
        int mid = len / 2;
        for (int i = 0; i <= mid; i++) {
            if(arr[i] != arr[len - i - 1]){
                return false;
            }
        }
        return true;*/

        //###################################
        /**
         * 反转一半
         */
        if(x < 0 || (x % 10 ==0 && x != 0)){
            return false;
        }
        int num = 0;
        while (x > num){
            num = num * 10 + x % 10;
            x = x/ 10;
        }
        //数字个数为奇数的,不用关心最后一位
        return x == num || x == num % 10;
    }

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。

     如果不存在公共前缀，返回空字符串 ""。

     示例 1:

     输入: ["flower","flow","flight"]
     输出: "fl"
     示例 2:

     输入: ["dog","racecar","car"]
     输出: ""
     解释: 输入不存在公共前缀。
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        /*String prx = "";
        int num = 0;
        if(strs.length == 0) return "";
        String first = strs[0];
        while (true){
            boolean needBreak = false;
            if(first.length() == num) return first;
            for (int i = 1; i < strs.length; i++) {
                String str = strs[i];
                if(str.length() <= num){
                    needBreak = true;
                    break;
                }
                if(str.charAt(num) != first.charAt(num)){
                    needBreak = true;
                    break;
                }
            }
            if(needBreak) {
                prx = first.substring(0, num);
                break;
            }
            num++;


        }

        return prx;*/

        //######################
        /**
         * 纵向扫描：从下标0开始，判断每一个字符串的下标0，判断是否全部相同。直到遇到不全部相同的下标。时间性能为O(n*m)
         */
            if(strs.length <= 0)
                return "";
            int num = strs.length;
            int len = strs[0].length();
            for(int i=0;i<len;i++)
                for(int j=1;j<num;j++)
                {
                    if(i > strs[j].length()-1 || strs[j].charAt(i) != strs[0].charAt(i))
                        return strs[0].substring(0, i);
                }
            return strs[0];
    }


    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

     有效字符串需满足：

     左括号必须用相同类型的右括号闭合。
     左括号必须以正确的顺序闭合。
     注意空字符串可被认为是有效字符串。
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if("".equals(s)) return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c){
                case ')':
                    if(stack.isEmpty() || !stack.pop().equals('(')){
                        return false;
                    }
                    break;
                case '}':
                    if(stack.isEmpty() || !stack.pop().equals('{')){
                        return false;
                    }
                    break;
                case ']':
                    if(stack.isEmpty() || !stack.pop().equals('[')){
                        return false;
                    }
                    break;
                default:
                    stack.push(c);
                    break;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

     示例：

     输入：1->2->4, 1->3->4
     输出：1->1->2->3->4->4
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val > l2.val){
            head = l2;
            l2 = l2.next;
        }else {
            head = l1;
            l1 = l1.next;
        }
        ListNode next = head;
        while (l1 != null || l2 != null){
            if((l1 == null && l2 != null)
                    || ((l1 != null && l2 != null && l1.val > l2.val))){
                next.next= l2;
                l2 = l2.next;
                next = next.next;
            }
            if((l1 != null && l2 == null)
                    || ((l1 != null && l2 != null && l1.val <= l2.val))){
                next.next= l1;
                l1 = l1.next;
                next = next.next;
            }

        }
        return head;
    }

    /**
     *
     给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

     不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

     示例 1:

     给定数组 nums = [1,1,2],

     函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。

     你不需要考虑数组中超出新长度后面的元素。
     示例 2:

     给定 nums = [0,0,1,1,1,2,2,3,3,4],

     函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。

     你不需要考虑数组中超出新长度后面的元素。
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        /**
         * 方法：双指针法
         算法

         数组完成排序后，我们可以放置两个指针 ii 和 jj，其中 ii 是慢指针，而 jj 是快指针。只要 nums[i] = nums[j]nums[i]=nums[j]，
         我们就增加 jj 以跳过重复项。

         当我们遇到 nums[j] \neq nums[i]nums[j]≠nums[i] 时，跳过重复项的运行已经结束，因此我们必须把它（nums[j]nums[j]）
         的值复制到 nums[i + 1]nums[i+1]。然后递增 ii，接着我们将再次重复相同的过程，直到 jj 到达数组的末尾为止。
         */
        if(nums.length <= 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }


    /**
     * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。

     不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

     元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

     示例 1:

     给定 nums = [3,2,2,3], val = 3,

     函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。

     你不需要考虑数组中超出新长度后面的元素。
     示例 2:

     给定 nums = [0,1,2,2,3,0,4,2], val = 2,

     函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。

     注意这五个元素可为任意顺序。

     你不需要考虑数组中超出新长度后面的元素。
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if(nums.length <= 0) return 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    /**
     * 实现 strStr() 函数。

     给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

     示例 1:

     输入: haystack = "hello", needle = "ll"
     输出: 2
     示例 2:

     输入: haystack = "aaaaa", needle = "bba"
     输出: -1
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if(needle == null || "".equals(needle)) return 0;
        int len = haystack.length();
        int j = 0;
        for (int i = 0; i < len; i++) {
            char c = haystack.charAt(i);
            char c1 = needle.charAt(j);
            if(c == c1){
                if(j == needle.length()-1){
                    return i-j;
                }else {
                    j++;
                }
            }else {
                if(j >0){
                    i = i - j;
                    j = 0;
                }

            }
        }
        return -1;
    }


    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

     你可以假设数组中无重复元素。

     示例 1:

     输入: [1,3,5,6], 5
     输出: 2
     示例 2:

     输入: [1,3,5,6], 2
     输出: 1
     示例 3:

     输入: [1,3,5,6], 7
     输出: 4
     示例 4:

     输入: [1,3,5,6], 0
     输出: 0
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(target <= num) return i;
        }
        return nums.length;
    }


    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

     示例:

     输入: [-2,1,-3,4,-1,2,1,-5,4],
     输出: 6
     解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            }else {
                sum = nums[i];
            }
        }
        if(sum > result) {
            result = sum;
        }
        return result;
    }

    /**
     * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。

     如果不存在最后一个单词，请返回 0 。

     说明：一个单词是指由字母组成，但不包含任何空格的字符串。

     示例:

     输入: "Hello World"
     输出: 5
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        int length = s.length();
        int num=0;
        for (int i = length-1; i >= 0; i--) {
            if(' ' != s.charAt(i)){
                num++;
            }else if(num > 0) {
                return num;
            }
        }
        return num;

    }


    /**
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

     最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。

     你可以假设除了整数 0 之外，这个整数不会以零开头。

     示例 1:

     输入: [1,2,3]
     输出: [1,2,4]
     解释: 输入数组表示数字 123。
     示例 2:

     输入: [4,3,2,1]
     输出: [4,3,2,2]
     解释: 输入数组表示数字 4321。
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        boolean jinwei = true;
        for (int i = len-1; i >= 0; i--) {
            int a = digits[i];
            if(jinwei){
                a = a+1;
            }
            if(a >= 10){
                a = a - 10;
            }else {
                jinwei  = false;
            }
            digits[i] = a;
        }
        if(jinwei){
            int[] arr = new int[len +1];
            arr[0] = 1;
            return arr;
        }else {
            return digits;
        }
    }


    public int climbStairs(int level) {
        if(level < 1) return 0;
        if(level == 1) return 1;
        if(level == 2) return 2;
        int a= 1;
        int b  = 2;
        int temp = 0;
        for (int i = 3; i <= level; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }

    /**
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

     示例 1:

     输入: 1->1->2
     输出: 1->2
     示例 2:

     输入: 1->1->2->3->3
     输出: 1->2->3
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode next = head.next;
        ListNode cur = head;
        while (next != null) {
            if(next.val != cur.val){
                cur.next = next;
                cur = next;
            }else {
                cur.next = next.next;
            }
            next = next.next;
        }
        return head;
    }


    /**
     *
     给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

     说明:

     初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
     你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     示例:

     输入:
     nums1 = [1,2,3,0,0,0], m = 3
     nums2 = [2,5,6],       n = 3

     输出: [1,2,2,3,5,6]
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tmp = 0;
        int nIndex = 0;
        for (int i = 0; i < nums1.length; i++) {
            int n1 = nums1[i];
            int n2 = nums2[i];
            if(n1 <= n2){
                tmp = nums1[i++];
                
            }
        }
    }

    public static void main(String[] args) {
        int level = 3;
        System.err.println(new Solution().climbStairs(level));

    }

}
