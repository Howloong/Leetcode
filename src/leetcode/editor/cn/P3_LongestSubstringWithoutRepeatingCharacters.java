//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 7646 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

//Java：无重复字符的最长子串
class P3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new P3_LongestSubstringWithoutRepeatingCharacters().new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.equals("")) {
                return 0;
            }
            int start = 0;
            int end = 0;
            int max = Integer.MIN_VALUE;
            HashMap<Character, Integer> hashMap = new HashMap<>();
            while (end < s.length()) {
                char c = s.charAt(end);
                hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
                ++end;
                while (hashMap.get(c) > 1) {
                    char d = s.charAt(start);
                    hashMap.put(d, hashMap.getOrDefault(d, 0) - 1);
                    ++start;
                }
                max = Math.max(max, end - start);
            }
            return max;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
