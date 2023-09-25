//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 1420 👎 0

package leetcode.editor.cn.java;

import java.util.Arrays;

//Java:分割等和子集
//Time:2022-07-29 13:25:27
class P416_PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new P416_PartitionEqualSubsetSum().new Solution();
        System.out.println(solution.canPartition(new int[]{1, 5, 11, 5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {
//            Arrays.sort(nums);
            int sum = Arrays.stream(nums).sum();
            if (sum % 2 == 1) {
                return false;
            }
            sum /= 2;
            int[] dp = new int[sum + 1];
            for (int num : nums) {
                for (int j = sum; j >= num; j--) {
                    dp[j] = Math.max(dp[j], dp[j - num] + num);
                }
            }
            return dp[sum] == sum;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
