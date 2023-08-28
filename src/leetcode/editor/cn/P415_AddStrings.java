//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。 
//
// 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。 
//
// 
//
// 示例 1： 
//
// 
//输入：num1 = "11", num2 = "123"
//输出："134"
// 
//
// 示例 2： 
//
// 
//输入：num1 = "456", num2 = "77"
//输出："533"
// 
//
// 示例 3： 
//
// 
//输入：num1 = "0", num2 = "0"
//输出："0"
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 10⁴ 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 
// Related Topics 数学 字符串 模拟 👍 585 👎 0

package leetcode.editor.cn;

import java.util.Objects;

//Java：字符串相加
class P415_AddStrings {
    public static void main(String[] args) {
        Solution solution = new P415_AddStrings().new Solution();
        System.out.println(solution.addStrings("999", "99"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            if (Objects.equals(num1, "0")) {
                return num2;
            }
            if (Objects.equals(num2, "0")) {
                return num1;
            }
            if (num1.length() > num2.length()) {
                return add(num1, num2);
            }
            return add(num2, num1);
        }

        public String add(String num1, String num2) {
            StringBuilder sb = new StringBuilder();
            StringBuilder blank = new StringBuilder(num2);
            while (blank.length() < num1.length()) {
                blank.insert(0, '0');
            }
            boolean carry = false;
            int i = num1.length() - 1;
            while (i >= 0) {
                int a = num1.charAt(i) - '0';
                int b = blank.charAt(i) - '0';
                int t = a + b + (carry ? 1 : 0);
                if (t >= 10) {
                    carry = true;
                    t = t - 10;
                } else {
                    carry = false;
                }
                sb.insert(0, t);
                --i;
            }
            if (carry) {
                sb.insert(0, 1);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
