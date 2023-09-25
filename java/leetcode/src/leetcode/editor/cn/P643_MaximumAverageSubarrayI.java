//给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。 
//
// 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。 
//
// 任何误差小于 10⁻⁵ 的答案都将被视为正确答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,12,-5,-6,50,3], k = 4
//输出：12.75
//解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
// 
//
// 示例 2： 
//
// 
//输入：nums = [5], k = 1
//输出：5.00000
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= k <= n <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 滑动窗口 👍 254 👎 0

package leetcode.editor.cn;

//Java：子数组最大平均数 I
class P643_MaximumAverageSubarrayI {
    public static void main(String[] args) {
        Solution solution = new P643_MaximumAverageSubarrayI().new Solution();
        System.out.println(solution.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMaxAverage(int[] nums, int k) {
            int i = 0;
            int j = 0;
            double avg = 0;
            double sum = 0;
            while (j < k) {
                sum += nums[j];
                j++;
            }
            avg = sum / k;
            double max = avg;
            while (j < nums.length) {
                sum += nums[j];
                sum -= nums[i];
                avg = sum / k;
                max = Math.max(max, avg);
                ++i;
                ++j;
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
