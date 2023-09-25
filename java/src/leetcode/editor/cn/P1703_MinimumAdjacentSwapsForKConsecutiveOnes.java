//给你一个整数数组 nums 和一个整数 k 。 nums 仅包含 0 和 1 。每一次移动，你可以选择 相邻 两个数字并将它们交换。 
//
// 请你返回使 nums 中包含 k 个 连续 1 的 最少 交换次数。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,0,0,1,0,1], k = 2
//输出：1
//解释：在第一次操作时，nums 可以变成 [1,0,0,0,1,1] 得到连续两个 1 。
// 
//
// 示例 2： 
//
// 输入：nums = [1,0,0,0,0,0,1,1], k = 3
//输出：5
//解释：通过 5 次操作，最左边的 1 可以移到右边直到 nums 变为 [0,0,0,0,0,1,1,1] 。
// 
//
// 示例 3： 
//
// 输入：nums = [1,1,0,1], k = 2
//输出：0
//解释：nums 已经有连续 2 个 1 了。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] 要么是 0 ，要么是 1 。 
// 1 <= k <= sum(nums) 
// 
//
// Related Topics 贪心 数组 前缀和 滑动窗口 👍 81 👎 0

package leetcode.editor.cn.java;

//Java:得到连续 K 个 1 的最少相邻交换次数
//Time:2022-12-18 10:51:39
class P1703_MinimumAdjacentSwapsForKConsecutiveOnes {
    public static void main(String[] args) {
        Solution solution = new P1703_MinimumAdjacentSwapsForKConsecutiveOnes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minMoves(int[] nums, int k) {
            return 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
