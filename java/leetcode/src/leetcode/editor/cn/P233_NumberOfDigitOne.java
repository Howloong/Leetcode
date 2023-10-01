//给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 13
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 10⁹ 
// 
//
// Related Topics 递归 数学 动态规划 👍 495 👎 0

package leetcode.editor.cn;

//Java:数字 1 的个数
//Time:2023-03-20 14:54:15
class P233_NumberOfDigitOne {
    public static void main(String[] args) {
        Solution solution = new P233_NumberOfDigitOne().new Solution();
        System.out.println(solution.countDigitOne(13));
        System.out.println(solution.countDigitOne(0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countDigitOne(int n) {
            int sum = 0;
            String s = String.valueOf(n);
            int[] nums = new int[s.length()];
            for (int i = 0; i < s.length(); i++) {
                nums[i] = s.charAt(i) - '0';
            }
            for (int i = 0; i < nums.length; i++) {
                sum += getCount(nums, i);
            }
            return sum;
        }

        public int getCount(int[] nums, int pos) {
            int pre = 0, suf = 0;
            for (int i = 0; i < pos; i++) {
                pre *= 10;
                pre += nums[i];
            }
            for (int i = pos + 1; i < nums.length; i++) {
                suf *= 10;
                suf += nums[i];
            }

            int res = (int) (pre * Math.pow(10, nums.length - pos - 1));
            if (nums[pos] == 1) {
                res += suf + 1;
            } else if (nums[pos] > 1) {
                res += Math.pow(10, nums.length - pos - 1);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
