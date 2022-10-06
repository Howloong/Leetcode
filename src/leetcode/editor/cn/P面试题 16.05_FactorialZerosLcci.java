//设计一个算法，算出 n 阶乘有多少个尾随零。 
//
// 示例 1: 
//
// 输入: 3
//输出: 0
//解释: 3! = 6, 尾数中没有零。 
//
// 示例 2: 
//
// 输入: 5
//输出: 1
//解释: 5! = 120, 尾数中有 1 个零. 
//
// 说明: 你算法的时间复杂度应为 O(log n) 。 
//
// Related Topics 数学 👍 79 👎 0

package leetcode.editor.cn;

//Java:阶乘尾数
//Time:2022-10-03 20:48:19
class FactorialZerosLcci {
    public static void main(String[] args) {
        Solution solution = new FactorialZerosLcci().new Solution();
        System.out.println(solution.trailingZeroes(10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trailingZeroes(int n) {
            int sum = 0;
            while (n >=5) {
                n /= 5;
                sum += n;
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
