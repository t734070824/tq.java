package _arithmetic;

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
        if(nums.length <= 1) return 1;
        int len = nums.length;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] == nums[i+1]){
                for (int j = i+1; j < nums.length; j++) {
                    //TODO 可以通过有序这个条件 对多个相同数字进行删除
                }
                len--;
            }
        }
        return len;
    }


    public static void main(String[] args) {
        System.err.println(new Solution().isValid("()"));
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(3);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(3);
        System.err.println(new Solution().mergeTwoLists(l1, l2));
        System.err.println(new Solution().mergeTwoLists(null, null));
    }

}
