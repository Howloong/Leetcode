//给定一个二进制字符串 s 和一个正整数 n，如果对于 [1, n] 范围内的每个整数，其二进制表示都是 s 的 子字符串 ，就返回 true，否则返回 
//false 。 
//
// 子字符串 是字符串中连续的字符序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "0110", n = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "0110", n = 4
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s[i] 不是 '0' 就是 '1' 
// 1 <= n <= 10⁹ 
// 
//
// Related Topics 字符串 👍 72 👎 0

package leetcode.editor.cn.java;

//Java:子串能表示从 1 到 N 数字的二进制串
//Time:2023-05-11 09:30:34
class P1016_BinaryStringWithSubstringsRepresenting1ToN {
    public static void main(String[] args) {
        Solution solution = new P1016_BinaryStringWithSubstringsRepresenting1ToN().new Solution();
        System.out.println(solution.queryString("0110", 3));
        System.out.println(solution.queryString("0110", 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean queryString(String s, int n) {
            for (int i = 1; i <= n; i++) {
                if (!s.contains(Integer.toString(i, 2))) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
