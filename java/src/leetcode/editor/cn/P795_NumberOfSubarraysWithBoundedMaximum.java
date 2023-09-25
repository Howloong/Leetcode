//给你一个整数数组 nums 和两个整数：left 及 right 。找出 nums 中连续、非空且其中最大元素在范围 [left, right] 内的子数组
//，并返回满足条件的子数组的个数。 
//
// 生成的测试用例保证结果符合 32-bit 整数范围。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,1,4,3], left = 2, right = 3
//输出：3
//解释：满足条件的三个子数组：[2], [2, 1], [3]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,9,2,5,6], left = 2, right = 8
//输出：7
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 0 <= left <= right <= 10⁹ 
// 
//
// Related Topics 数组 双指针 👍 239 👎 0

package leetcode.editor.cn.java;

//Java:区间子数组个数
//Time:2022-11-24 10:38:17
class P795_NumberOfSubarraysWithBoundedMaximum {
    public static void main(String[] args) {
        Solution solution = new P795_NumberOfSubarraysWithBoundedMaximum().new Solution();
//        System.out.println(solution.numSubarrayBoundedMax(new int[]{2, 9, 2, 5, 6}, 2, 8));
        System.out.println(solution.numSubarrayBoundedMax(new int[]{73, 55, 36, 5, 55, 14, 9, 7, 72, 52}, 32, 69));
        System.out.println(solution.numSubarrayBoundedMax(new int[]{2, 1, 4, 3}, 2, 3));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubarrayBoundedMax(int[] nums, int left, int right) {
            int count = 0;
            int i0 = -1;
            int i1 = -1;
            int i = 0;
            while (i < nums.length) {
                if (nums[i] > right) {
                    i0 = i;
                }
                if (nums[i] >= left) {
                    i1 = i;
                }
                count += i1 - i0;
                i++;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
