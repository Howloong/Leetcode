//给你一个整数 n ，以二进制字符串的形式返回该整数的 负二进制（base -2）表示。 
//
// 注意，除非字符串就是 "0"，否则返回的字符串中不能含有前导零。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出："110"
//解释：(-2)² + (-2)¹ = 2
// 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出："111"
//解释：(-2)² + (-2)¹ + (-2)⁰ = 3
// 
//
// 示例 3： 
//
// 
//输入：n = 4
//输出："100"
//解释：(-2)² = 4
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
// Related Topics 数学 👍 94 👎 0

package leetcode.editor.cn;

//Java:负二进制转换
//Time:2023-04-06 10:35:47
class P1017_ConvertToBase2 {
    public static void main(String[] args) {
        Solution solution = new P1017_ConvertToBase2().new Solution();
        System.out.println(solution.baseNeg2(2));
        System.out.println(solution.baseNeg2(3));
        System.out.println(solution.baseNeg2(4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String baseNeg2(int n) {
            if (n == 0) {
                return "0";
            }
            StringBuilder sb = new StringBuilder();
            while (n != 0) {
                int t = n % -2;
                if (t == 0) {
                    sb.insert(0, 0);
                    n /= -2;
                } else if (t == -1) {
                    sb.insert(0, 1);
                    n = n / -2 + 1;
                } else {
                    sb.insert(0, 1);
                    n /= -2;
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
