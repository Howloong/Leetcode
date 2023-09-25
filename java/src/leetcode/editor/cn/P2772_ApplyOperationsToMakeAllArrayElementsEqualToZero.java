//给你一个下标从 0 开始的整数数组 nums 和一个正整数 k 。 
//
// 你可以对数组执行下述操作 任意次 ： 
//
// 
// 从数组中选出长度为 k 的 任一 子数组，并将子数组中每个元素都 减去 1 。 
// 
//
// 如果你可以使数组中的所有元素都等于 0 ，返回 true ；否则，返回 false 。 
//
// 子数组 是数组中的一个非空连续元素序列。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,2,3,1,1,0], k = 3
//输出：true
//解释：可以执行下述操作：
//- 选出子数组 [2,2,3] ，执行操作后，数组变为 nums = [1,1,2,1,1,0] 。
//- 选出子数组 [2,1,1] ，执行操作后，数组变为 nums = [1,1,1,0,0,0] 。
//- 选出子数组 [1,1,1] ，执行操作后，数组变为 nums = [0,0,0,0,0,0] 。
// 
//
// 示例 2： 
//
// 输入：nums = [1,3,1,1], k = 2
//输出：false
//解释：无法使数组中的所有元素等于 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁶ 
// 
//
// Related Topics 数组 前缀和 👍 22 👎 0

package leetcode.editor.cn.java;

//Java:使数组中的所有元素都等于零
//Time:2023-08-22 15:25:56
class P2772_ApplyOperationsToMakeAllArrayElementsEqualToZero {
    public static void main(String[] args) {
        Solution solution = new P2772_ApplyOperationsToMakeAllArrayElementsEqualToZero().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkArray(int[] nums, int k) {
            if (k == 1) {
                return true;
            }
            int length = nums.length;
            int[] delta = new int[length + 1];
            delta[0] = nums[0];
            for (int i = 1; i < length; i++) {
                delta[i] = nums[i] - nums[i - 1];
            }
            for (int i = 0; i < length; i++) {
                if (delta[i] == 0) {
                    continue;
                }
                if (delta[i] < 0) {
                    return false;
                }
                if (i + k > length && delta[i] > 0) {
                    return false;
                }
                delta[i + k] += delta[i];
                delta[i] = 0;
            }
            return true;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
