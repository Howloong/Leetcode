//给你一个整数数组 nums ，你可以对它进行一些操作。 
//
// 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i]
// + 1 的元素。 
//
// 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,4,2]
//输出：6
//解释：
//删除 4 获得 4 个点数，因此 3 也被删除。
//之后，删除 2 获得 2 个点数。总共获得 6 个点数。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,3,3,3,4]
//输出：9
//解释：
//删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
//之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
//总共获得 9 个点数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// 1 <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 哈希表 动态规划 👍 804 👎 0

package leetcode.editor.cn;

//Java:删除并获得点数
//Time:2023-08-22 15:27:18
class P740_DeleteAndEarn {
    public static void main(String[] args) {
        Solution solution = new P740_DeleteAndEarn().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int deleteAndEarn(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            int[] newNums = new int[10001];
            int max = 0;
            for (int num : nums) {
                newNums[num] += num;
                max = Math.max(max, num);
            }
            int[] dp = new int[max + 1];
            dp[0] = newNums[0];
            dp[1] = Math.max(newNums[0], newNums[1]);
            for (int i = 2; i <= max; i++) {
                dp[i] = Math.max(dp[i - 2] + newNums[i], dp[i - 1]);
            }
            return dp[max];
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
