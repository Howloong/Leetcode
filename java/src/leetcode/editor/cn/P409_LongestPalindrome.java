//给定一个包含大写字母和小写字母的字符串
// s ，返回 通过这些字母构造成的 最长的回文串 。 
//
// 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入:s = "abccccdd"
//输出:7
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
//
// 示例 2: 
//
// 
//输入:s = "a"
//输入:1
// 
//
// 示例 3: 
//
// 
//输入:s = "bb"
//输入: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 2000 
// s 只能由小写和/或大写英文字母组成 
// 
//
// Related Topics 贪心 哈希表 字符串 👍 442 👎 0

package leetcode.editor.cn.java;

import java.util.HashMap;
import java.util.Map;

//Java:最长回文串
//Time:2022-08-02 17:35:05
class P409_LongestPalindrome {
    public static void main(String[] args) {
        Solution solution = new P409_LongestPalindrome().new Solution();
        System.out.println(solution.longestPalindrome("aab"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestPalindrome(String s) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            int sum = 0;
            for (Integer value : map.values()) {
                if (value % 2 == 0) {
                    sum += value;
                } else {
                    sum += value - 1;
                }
            }
            return sum == s.length() ? sum : sum + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
