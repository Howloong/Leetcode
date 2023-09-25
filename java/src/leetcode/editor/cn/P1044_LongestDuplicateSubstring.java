//给你一个字符串 s ，考虑其所有 重复子串 ：即 s 的（连续）子串，在 s 中出现 2 次或更多次。这些出现之间可能存在重叠。 
//
// 返回 任意一个 可能具有最长长度的重复子串。如果 s 不含重复子串，那么答案为 "" 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "banana"
//输出："ana"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd"
//输出：""
// 
//
// 
//
// 提示： 
//
// 
// 2 <= s.length <= 3 * 10⁴ 
// s 由小写英文字母组成 
// 
//
// Related Topics 字符串 二分查找 后缀数组 滑动窗口 哈希函数 滚动哈希 👍 365 👎 0

package leetcode.editor.cn.java;

//Java:最长重复子串
//Time:2023-04-12 11:04:30
class P1044_LongestDuplicateSubstring {
    public static void main(String[] args) {
        Solution solution = new P1044_LongestDuplicateSubstring().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestDupSubstring(String s) {
            int n = s.length();
            int b = 1331;
            long p = (long) Math.pow(2, 40);
            long[] hash = new long[n + 1];
            long[] p1331 = new long[n + 1];
            for (int i = 0; i < n; i++) {
                hash[i + 1] = (hash[i] * b + s.charAt(i) - 'a' + 1) % p;
                p1331[i + 1] = p1331[i] * b;
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
