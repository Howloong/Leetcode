//给定你一个整数数组
// nums 
//
// 我们要将
// nums 数组中的每个元素移动到 A 数组 或者 B 数组中，使得 A 数组和
// B 数组不为空，并且
// average(A) == average(B) 。 
//
// 如果可以完成则返回true ， 否则返回 false 。 
//
// 注意：对于数组
// arr , 
// average(arr) 是
// arr 的所有元素除以
// arr 长度的和。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,3,4,5,6,7,8]
//输出: true
//解释: 我们可以将数组分割为 [1,4,5,8] 和 [2,3,6,7], 他们的平均值都是4.5。
// 
//
// 示例 2: 
//
// 
//输入: nums = [3,1]
//输出: false
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 30 
// 0 <= nums[i] <= 10⁴ 
// 
//
// Related Topics 位运算 数组 数学 动态规划 状态压缩 👍 167 👎 0

package leetcode.editor.cn.java;

import java.util.Arrays;

//Java:数组的均值分割
//Time:2022-11-14 11:07:46
class P805_SplitArrayWithSameAverage {
    public static void main(String[] args) {
        Solution solution = new P805_SplitArrayWithSameAverage().new Solution();
        System.out.println(solution.splitArraySameAverage(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
//        System.out.println(solution.splitArraySameAverage(new int[]{2, 0, 7, 0, 6}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean splitArraySameAverage(int[] nums) {
            int total = Arrays.stream(nums).sum();
            if (nums.length == 1) {
                return false;
            }
            if (total == 0) {
                return true;
            }
            int[] dp = new int[total / 2 + 1];
            for (int i = 0; i < nums.length; i++) {
                for (int j = total / 2; j >= nums[i]; j--) {
                    dp[j] = dp[j] | dp[j - nums[i]] << 1;
                    if (j * nums.length % total == 0 && (1 << (j * nums.length / total) & dp[j]) > 0) {
                        return true;
                    }
                }
            }
            return false;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
