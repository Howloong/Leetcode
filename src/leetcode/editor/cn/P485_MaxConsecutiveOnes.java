//给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,0,1,1,1]
//输出：3
//解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
// 
//
// 示例 2: 
//
// 
//输入：nums = [1,0,1,1,0,1]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] 不是 0 就是 1. 
// 
//
// Related Topics 数组 👍 331 👎 0

package leetcode.editor.cn;

//Java:最大连续 1 的个数
//Time:2022-08-06 17:34:56
class P485_MaxConsecutiveOnes {
    public static void main(String[] args) {
        Solution solution = new P485_MaxConsecutiveOnes().new Solution();
        System.out.println(solution.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int sum = 0;
            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                if (num == 1) {
                    sum++;
                } else {
                    max = Math.max(max, sum);
                    sum = 0;
                }
            }
            max = Math.max(max, sum);
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
