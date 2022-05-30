//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。 
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
// Related Topics 哈希表 双指针 字符串 滑动窗口 👍 687 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Objects;

//Java：字符串的排列
class P567_PermutationInString{
    public static void main(String[] args) {
        Solution solution = new P567_PermutationInString().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int start = 0, end = 0;
        int len = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (Character c :
                s1.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        while (end < s2.length()) {
            char c = s2.charAt(end);
            if (hashMap.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (Objects.equals(window.get(c), hashMap.get(c))) {
                    ++len;
                }

            }
            while (len == hashMap.size()) {
                c = s2.charAt(start);
                if (end - start + 1 == s1.length()) {
                    return true;
                }
                if (hashMap.containsKey(c)) {
                    if (Objects.equals(window.get(c), hashMap.get(c))) {
                        --len;
                    }
                    window.put(c, window.get(c) - 1);
                }
                ++start;
            }
            end++;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
