//对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。 
//
// 给定一个 整数 n， 如果是完美数，返回 true；否则返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 28
//输出：true
//解释：28 = 1 + 2 + 4 + 7 + 14
//1, 2, 4, 7, 和 14 是 28 的所有正因子。 
//
// 示例 2： 
//
// 
//输入：num = 7
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 10⁸ 
// 
//
// Related Topics 数学 👍 181 👎 0

package leetcode.editor.cn;

//Java:完美数
//Time:2022-08-17 22:47:24
class P507_PerfectNumber {
    public static void main(String[] args) {
        Solution solution = new P507_PerfectNumber().new Solution();
        System.out.println(solution.checkPerfectNumber(28));
        System.out.println(solution.checkPerfectNumber(7));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkPerfectNumber(int num) {
            return num == 6 || num == 28 || num == 496 || num == 8128 || num == 33550336;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
