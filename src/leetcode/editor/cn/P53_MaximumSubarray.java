//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 子数组 是数组中的一个连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [5,4,-1,7,8]
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
// Related Topics 数组 分治 动态规划 👍 5011 👎 0

package leetcode.editor.cn;

//Java：最大子数组和
class P53_MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new P53_MaximumSubarray().new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
          /*  int res = nums[0];
            int sum = 0;
            for (int i : nums
            ) {
                if (sum > 0) {
                    sum += i;
                } else {
                    sum = i;
                }
                res = Math.max(res, sum);
            }
            return res;*/
            int n = nums.length;
            int dp = Math.max(nums[0], 0);
            int max = nums[0];
            for (int i = 1; i < n; i++) {
                dp = Math.max(dp+ nums[i], nums[i]);
                max = Math.max(max, dp);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
