//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 900 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//Java：找到字符串中所有字母异位词
class P438_FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new P438_FindAllAnagramsInAString().new Solution();
//        System.out.println(solution.findAnagrams("cbaebabacd","abc"));
        System.out.println(solution.findAnagrams("baa", "aa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            HashMap<Character, Integer> hashMap = new HashMap<>();
            HashMap<Character, Integer> window = new HashMap<>();
            for (char t :
                    p.toCharArray()) {
                hashMap.put(t, hashMap.getOrDefault(t, 0) + 1);
            }
            int start = 0;
            int end = 0;
            int len = p.length();
            List<Integer> list = new ArrayList<>();
            Arrays.sort(p.toCharArray());
            while (end != s.length()) {
                char c = s.charAt(end);
                if (hashMap.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (window.get(c) <= hashMap.get(c)) {
                        --len;
                    }
                }
                while (len == 0) {
                    c = s.charAt(start);
                    if (end - start + 1 == p.length()) {
                        list.add(start);
                    }
                    if (window.containsKey(c)) {
                        if (window.get(c) <= hashMap.get(c)) {
                            ++len;
                        }
                        window.put(c, window.get(c) - 1);
                    }
                    ++start;
                }
                ++end;
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
