//当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。 
//
// 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 10
//输出: 9
// 
//
// 示例 2: 
//
// 
//输入: n = 1234
//输出: 1234
// 
//
// 示例 3: 
//
// 
//输入: n = 332
//输出: 299
// 
//
// 
//
// 提示: 
//
// 
// 0 <= n <= 10⁹ 
// 
//
// Related Topics 贪心 数学 👍 272 👎 0

package leetcode.editor.cn;

//Java:单调递增的数字
//Time:2022-07-21 16:18:27
class P738_MonotoneIncreasingDigits {
    public static void main(String[] args) {
        Solution solution = new P738_MonotoneIncreasingDigits().new Solution();
        System.out.println(solution.monotoneIncreasingDigits(1234));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int monotoneIncreasingDigits(int n) {
            char[] c = String.valueOf(n).toCharArray();
            int last = c.length;
            for (int i = c.length - 1; i > 0; i--) {
                if (c[i] < c[i - 1]) {
                    last = i;
                    c[i - 1]--;
                }
            }
            for (int i = last; i < c.length; i++) {
                c[i] = '9';
            }
            return Integer.parseInt(new String(c));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
