//给定一个非负整数数组 nums， nums 中一半整数是 奇数 ，一半整数是 偶数 。 
//
// 对数组进行排序，以便当 nums[i] 为奇数时，i 也是 奇数 ；当 nums[i] 为偶数时， i 也是 偶数 。 
//
// 你可以返回 任何满足上述条件的数组作为答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,2,5,7]
//输出：[4,5,2,7]
//解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 2 * 10⁴ 
// nums.length 是偶数 
// nums 中一半是偶数 
// 0 <= nums[i] <= 1000 
// 
//
// 
//
// 进阶：可以不使用额外空间解决问题吗？ 
//
// Related Topics 数组 双指针 排序 👍 252 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java:按奇偶排序数组 II
//Time:2022-10-05 14:08:33
class P922_SortArrayByParityIi {
    public static void main(String[] args) {
        Solution solution = new P922_SortArrayByParityIi().new Solution();
        System.out.println(Arrays.toString(solution.sortArrayByParityII(new int[]{648, 831, 560, 986, 192, 424, 997, 829, 897, 843})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArrayByParityII(int[] nums) {
            int i = 0;
            int j = 1;
            while (i < nums.length) {
                if (nums[i] % 2 == 0) {
                    i += 2;
                    continue;
                }
                while (j < nums.length && nums[j] % 2 == 1) {
                    j += 2;
                }
                swap(nums, i, j);
                i += 2;
            }
            return nums;
        }

        public void swap(int[] nums, int i, int j) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
