//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 位运算 数学 字符串 模拟 👍 830 👎 0

package leetcode.editor.cn.java;

import java.util.Objects;

//Java：二进制求和
class P67_AddBinary {
    public static void main(String[] args) {
        Solution solution = new P67_AddBinary().new Solution();
        System.out.println(solution.addBinary("1111", "1111"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            if (Objects.equals(a, "0")) {
                return b;
            }
            if (Objects.equals(b, "0")) {
                return a;
            }
            int carry = 0;
            int m = a.length() - 1;
            int n = b.length() - 1;
            if (m < n) {
                StringBuilder aBuilder = new StringBuilder(a);
                while (m != n) {
                    aBuilder.insert(0, "0");
                    ++m;
                }
                a = aBuilder.toString();
            } else {
                StringBuilder bBuilder = new StringBuilder(b);
                while (m != n) {
                    bBuilder.insert(0, "0");
                    ++n;
                }
                b = bBuilder.toString();
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = m; i >= 0; --i) {
                int res = a.charAt(i) ^ b.charAt(i) ^ carry;
                carry = a.charAt(i) + b.charAt(i) - '0' - '0' + carry >= 2 ? 1 : 0;
                stringBuilder.insert(0, res);
            }
            if (carry == 1) {
                stringBuilder.insert(0, '1');
            }
            return stringBuilder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
