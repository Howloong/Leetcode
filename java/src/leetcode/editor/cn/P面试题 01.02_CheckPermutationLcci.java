//给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。 
//
// 示例 1： 
//
// 输入: s1 = "abc", s2 = "bca"
//输出: true 
// 
//
// 示例 2： 
//
// 输入: s1 = "abc", s2 = "bad"
//输出: false
// 
//
// 说明： 
//
// 
// 0 <= len(s1) <= 100 
// 0 <= len(s2) <= 100 
// 
//
// Related Topics 哈希表 字符串 排序 👍 109 👎 0

package leetcode.editor.cn.java;

import java.util.HashMap;

//Java:判定是否互为字符重排
//Time:2022-09-27 12:23:46
class CheckPermutationLcci {
    public static void main(String[] args) {
        Solution solution = new CheckPermutationLcci().new Solution();
        System.out.println(solution.CheckPermutation("abc", "bcd"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean CheckPermutation(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }
            HashMap<Character, Integer> hashMap = new HashMap<>();
            for (var o : s1.toCharArray()) {
                hashMap.put(o, hashMap.getOrDefault(o, 0) + 1);
            }
            for (char c : s2.toCharArray()) {
                if (!hashMap.containsKey(c)) {
                    return false;
                }
                int num = hashMap.get(c);
                hashMap.put(c, num - 1);
                if (num == 1) {
                    hashMap.remove(c);
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
