//给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。 
//
// 进阶：不要 使用任何内置的库函数，如 sqrt 。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 16
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：num = 14
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 2^31 - 1 
// 
// Related Topics 数学 二分查找 👍 393 👎 0

package leetcode.editor.cn.java;

//Java：有效的完全平方数
class P367_ValidPerfectSquare {
    public static void main(String[] args) {
        Solution solution = new P367_ValidPerfectSquare().new Solution();
        solution.isPerfectSquare(9);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPerfectSquare(int num) {
            if (num == 1) {
                return true;
            }
            int i = 1, j = num / 2;
            int mid;
            while (i <= j) {
                mid = (i + j) / 2;
                int t = num / mid;
                if (t == mid) {
                    if (num % t == 0) {
                        return true;
                    }
                    i = mid + 1;
                } else if (t > mid) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
            return false;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
