//给你一个整数数组 nums 。「数组值」定义为所有满足 0 <= i < nums.length-1 的 |nums[i]-nums[i+1]| 的和。 
//
// 你可以选择给定数组的任意子数组，并将该子数组翻转。但你只能执行这个操作 一次 。 
//
// 请你找到可行的最大 数组值 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,3,1,5,4]
//输出：10
//解释：通过翻转子数组 [3,1,5] ，数组变成 [2,5,1,3,4] ，数组值为 10 。
// 
//
// 示例 2： 
//
// 输入：nums = [2,4,9,24,2,1,10]
//输出：68
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3*10^4 
// -10^5 <= nums[i] <= 10^5 
// 
//
// Related Topics 贪心 数组 数学 👍 109 👎 0

package leetcode.editor.cn.java;

//Java:翻转子数组得到最大的数组值
//Time:2023-05-12 11:38:33
class P1330_ReverseSubarrayToMaximizeArrayValue {
    public static void main(String[] args) {
        Solution solution = new P1330_ReverseSubarrayToMaximizeArrayValue().new Solution();
        System.out.println(solution.maxValueAfterReverse(new int[]{2, 3, 1, 5, 4}));
        System.out.println(solution.maxValueAfterReverse(new int[]{2, 4, 9, 24, 2, 1, 10}));
        System.out.println(solution.maxValueAfterReverse(new int[]{5, -7, 9, -6, 8}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxValueAfterReverse(int[] nums) {
            int sum = 0;
            int low_max = Integer.MIN_VALUE;
            int high_min = Integer.MAX_VALUE;
            int ends = 0;
            for (int i = 1; i < nums.length; i++) {
                int x = nums[i - 1];
                int y = nums[i];
                int delta = Math.abs(x - y);
                low_max = Math.max(low_max, Math.min(x, y));
                high_min = Math.min(high_min, Math.max(x, y));
                sum += delta;
                ends = Math.max(Math.max(ends, Math.abs(nums[0] - y) - delta), Math.abs(x - nums[nums.length - 1]) - delta);
            }

            return Math.max((low_max - high_min) * 2, ends) + sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
