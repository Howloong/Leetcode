//一个序列的 宽度 定义为该序列中最大元素和最小元素的差值。 
//
// 给你一个整数数组 nums ，返回 nums 的所有非空 子序列 的 宽度之和 。由于答案可能非常大，请返回对 10⁹ + 7 取余 后的结果。 
//
// 子序列 定义为从一个数组里删除一些（或者不删除）元素，但不改变剩下元素的顺序得到的数组。例如，[3,6,2,7] 就是数组 [0,3,1,6,2,2,7]
// 的一个子序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,1,3]
//输出：6
//解释：子序列为 [1], [2], [3], [2,1], [2,3], [1,3], [2,1,3] 。
//相应的宽度是 0, 0, 0, 1, 1, 2, 2 。
//宽度之和是 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 数学 排序 👍 99 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java:子序列宽度之和
//Time:2022-11-18 10:09:26
class P891_SumOfSubsequenceWidths {
    public static void main(String[] args) {
        Solution solution = new P891_SumOfSubsequenceWidths().new Solution();
//        int[] num = new int[100000];
//        for (int i = 0; i < num.length; i++) {
//            num[i] = i;
//        }
//        System.out.println(solution.sumSubseqWidths(num));
        System.out.println(solution.sumSubseqWidths(new int[]{5, 69, 89, 92, 31, 16, 25, 45, 63, 40, 16, 56, 24, 40, 75, 82, 40, 12, 50, 62, 92, 44, 67, 38, 92, 22, 91, 24, 26, 21, 100, 42, 23, 56, 64, 43, 95, 76, 84, 79, 89, 4, 16, 94, 16, 77, 92, 9, 30, 13}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int sumSubseqWidths(int[] nums) {
            int MOD = (int) 1e9 + 7;
            Arrays.sort(nums);
            int len = nums.length;
            long sum = 0;
            long[] pow;
            pow = new long[len];
            pow[0] = 1;
            for (int i = 1; i < pow.length; i++) {
                pow[i] = (pow[i - 1] << 1) % MOD;
            }
            for (int i = 0; i < len; i++) {
                sum = (sum + (pow[i] - pow[len - i - 1]) * nums[i] % MOD) % MOD;
            }
            try {
                Thread.sleep(1000000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return (int) sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
