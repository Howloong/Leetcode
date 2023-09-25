//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口 👍 1893 👎 0

package leetcode.editor.cn.java;

import java.util.HashMap;
import java.util.Map;

//Java：最小覆盖子串
class P76_MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new P76_MinimumWindowSubstring().new Solution();
        System.out.println(solution.minWindow("a", "a"));
//        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            if (t.length() > s.length()) {
                return "";
            }
            HashMap<Character, Integer> origin = new HashMap<>();
            HashMap<Character, Integer> window = new HashMap<>();
            int i = 0;
            int j = 0;
            while (i < t.length()) {
                origin.put(t.charAt(i), origin.getOrDefault(t.charAt(i), 0) + 1);
                i++;
            }
            i = 0;
            int size = Integer.MAX_VALUE;
            int left = 0;
            int right = 0;
            while (j < s.length()) {
                char c = s.charAt(j);
                if (origin.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                }
                if (origin.size() == window.size()) {
                    while (check(origin, window)) {
                        if (j - i + 1 < size) {
                            size = j - i + 1;
                            right = j;
                            left = i;
                        }
                        char c2 = s.charAt(i);
                        if (origin.containsKey(c2)) {
                            window.put(c2, window.get(c2) - 1);
                        }
                        i++;
                    }
                }
                j++;
            }
            return size != Integer.MAX_VALUE ? s.substring(left, right + 1) : "";

        }

        private boolean check(HashMap<Character, Integer> origin, HashMap<Character, Integer> window) {
            for (Map.Entry<Character, Integer> entry : origin.entrySet()
            ) {
                if (window.get(entry.getKey()) < entry.getValue()) {
                    return false;
                }
            }
            return true;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)
}

