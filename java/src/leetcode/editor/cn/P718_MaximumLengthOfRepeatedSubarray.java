//给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
//输出：3
//解释：长度最长的公共子数组是 [3,2,1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 100 
// 
//
// Related Topics 数组 二分查找 动态规划 滑动窗口 哈希函数 滚动哈希 👍 790 👎 0

package leetcode.editor.cn.java;

//Java:最长重复子数组
//Time:2022-09-17 16:59:42
class P718_MaximumLengthOfRepeatedSubarray {
    public static void main(String[] args) {
        Solution solution = new P718_MaximumLengthOfRepeatedSubarray().new Solution();
//        System.out.println(solution.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
        System.out.println(solution.findLength(new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 0, 1, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLength(int[] nums1, int[] nums2) {
            int[] dp = new int[nums1.length + 1];
            int max = 0;
            for (int i = 1; i <= nums1.length; i++) {
                for (int j = nums2.length; j >= 1; j--) {
                    if (nums1[i - 1] == nums2[j - 1]) {
                        dp[j] = dp[j - 1] + 1;
                        max = Math.max(max, dp[j]);
                    } else {
                        dp[j] = 0;
                    }
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
