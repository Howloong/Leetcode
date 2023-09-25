//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 
//输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 200 
// num1 和 num2 只能由数字组成。 
// num1 和 num2 都不包含任何前导零，除了数字0本身。 
// 
//
// Related Topics 数学 字符串 模拟 👍 1006 👎 0

package leetcode.editor.cn;

//Java:字符串相乘
//Time:2022-08-05 13:40:21
class P43_MultiplyStrings {
    public static void main(String[] args) {
        Solution solution = new P43_MultiplyStrings().new Solution();
        System.out.println(solution.multiply("99999", "456"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0")) {
                return "0";
            }
            if (num1.equals("1")) {
                return num2;
            }
            if (num2.equals("1")) {
                return num1;
            }
            String last = "0";
            int offset = 0;
            for (int i = num2.length() - 1; i >= 0; i--) {
                String t = mul(num1, num2.charAt(i));
                last = add(last, t + "0".repeat(offset++));
            }
            return last;
        }

        public String mul(String num1, char num2) {
            int carry = 0;
            StringBuilder res = new StringBuilder();
            int n = num2 - '0';
            for (int i = num1.length() - 1; i >= 0; i--) {
                int m = num1.charAt(i) - '0';
                int t = m * n + carry;
                carry = t / 10;
                res.insert(0, t % 10);
            }
            if (carry != 0) {
                res.insert(0, carry);
            }
            return res.toString();
        }

        public String add(String num1, String num2) {
            if (num1.length() != num2.length()) {
                num1 = "0".repeat(num2.length() - num1.length()) + num1;
            }
            StringBuilder res = new StringBuilder();
            boolean carry = false;
            for (int i = num1.length() - 1; i >= 0; i--) {
                int m = num1.charAt(i) - '0';
                int n = num2.charAt(i) - '0';
                int t = m + n + (carry ? 1 : 0);
                carry = t >= 10;
                res.insert(0, carry ? t - 10 : t);
            }
            if (carry) {
                res.insert(0, "1");
            }
            return res.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
