//给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。 
//
// 请你计算并返回该式的最大值。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,4,5,2]
//输出：12 
//解释：如果选择下标 i=1 和 j=2（下标从 0 开始），则可以获得最大值，(nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) =
// 3*4 = 12 。 
// 
//
// 示例 2： 
//
// 输入：nums = [1,5,4,5]
//输出：16
//解释：选择下标 i=1 和 j=3（下标从 0 开始），则可以获得最大值 (5-1)*(5-1) = 16 。
// 
//
// 示例 3： 
//
// 输入：nums = [3,7]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 500 
// 1 <= nums[i] <= 10^3 
// 
//
// Related Topics 数组 排序 堆（优先队列） 👍 70 👎 0

package leetcode.editor.cn;

//Java:数组中两元素的最大乘积
//Time:2022-08-26 16:04:19
class P1464_MaximumProductOfTwoElementsInAnArray {
    public static void main(String[] args) {
        Solution solution = new P1464_MaximumProductOfTwoElementsInAnArray().new Solution();
        System.out.println(solution.maxProduct(new int[]{3, 4, 5, 2}));
//        System.out.println(solution.maxProduct(new int[]{1,5,4,5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            for (int i = 0; i < 2; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] < nums[j]) {
                        nums[i] = nums[i] ^ nums[j];
                        nums[j] = nums[i] ^ nums[j];
                        nums[i] = nums[i] ^ nums[j];
                    }
                }
            }
            return (nums[0] - 1) * (nums[1] - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
