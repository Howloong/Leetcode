//给你一个正整数数组 nums，你需要从中任选一些子集，然后将子集中每一个数乘以一个 任意整数，并求出他们的和。 
//
// 假如该和结果为 1，那么原数组就是一个「好数组」，则返回 True；否则请返回 False。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [12,5,7,23]
//输出：true
//解释：挑选数字 5 和 7。
//5*3 + 7*(-2) = 1
// 
//
// 示例 2： 
//
// 输入：nums = [29,6,10]
//输出：true
//解释：挑选数字 29, 6 和 10。
//29*1 + 6*(-3) + 10*(-1) = 1
// 
//
// 示例 3： 
//
// 输入：nums = [3,6]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i] <= 10^9 
// 
//
// Related Topics 数组 数学 数论 👍 89 👎 0

package leetcode.editor.cn.java;

//Java:检查「好数组」
//Time:2023-02-15 15:32:06
class P1250_CheckIfItIsAGoodArray {
    public static void main(String[] args) {
        Solution solution = new P1250_CheckIfItIsAGoodArray().new Solution();
//        System.out.println(solution.isGoodArray(new int[]{12, 5, 7, 23}));
//        System.out.println(solution.isGoodArray(new int[]{29,6,10}));
        System.out.println(solution.isGoodArray(new int[]{6, 10, 15}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isGoodArray(int[] nums) {
            int len = nums.length;
            int t = nums[0];
            for (int i = 1; i < len; i++) {
                t = gcd(t, nums[i]);
                if (t == 1) {
                    return true;
                }
            }
            return t == 1;
        }

        public int gcd(int nums1, int nums2) {
            while (nums2 != 0) {
                int temp = nums1;
                nums1 = nums2;
                nums2 = temp % nums2;
            }
            return nums1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
