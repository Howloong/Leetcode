//给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。 
//
// 如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 输入：s1 = "bank", s2 = "kanb"
//输出：true
//解释：例如，交换 s2 中的第一个和最后一个字符可以得到 "bank"
// 
//
// 示例 2： 
//
// 输入：s1 = "attack", s2 = "defend"
//输出：false
//解释：一次字符串交换无法使两个字符串相等
// 
//
// 示例 3： 
//
// 输入：s1 = "kelb", s2 = "kelb"
//输出：true
//解释：两个字符串已经相等，所以不需要进行字符串交换
// 
//
// 示例 4： 
//
// 输入：s1 = "abcd", s2 = "dcba"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 100 
// s1.length == s2.length 
// s1 和 s2 仅由小写英文字母组成 
// 
//
// Related Topics 哈希表 字符串 计数 👍 57 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

//Java:仅执行一次字符串交换能否使两个字符串相等
//Time:2022-10-11 10:32:40
class P1790_CheckIfOneStringSwapCanMakeStringsEqual {
    public static void main(String[] args) {
        Solution solution = new P1790_CheckIfOneStringSwapCanMakeStringsEqual().new Solution();
        System.out.println(solution.areAlmostEqual("bank", "kanb"));
        System.out.println(solution.areAlmostEqual("attack", "defend"));
        System.out.println(solution.areAlmostEqual("aa", "ac"));
        System.out.println(solution.areAlmostEqual("qgqeg", "gqgeq"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean areAlmostEqual(String s1, String s2) {
            if (s1.equals(s2)) {
                return true;
            }
            HashMap<Character, Character> hashMap = new HashMap<>();
            HashSet<Character> hashSet = new HashSet<>();
            int index = 0;
            for (int i = 0; i < s1.length(); i++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);
                if (c1 != c2) {
                    index++;
                    if (index > 2) {
                        return false;
                    }
                    if (!hashMap.containsKey(c1)) {
                        hashMap.put(c1, c2);
                        hashSet.add(c1);
                        hashSet.add(c2);
                    }
                }

            }
            return hashMap.size() == 2 && hashSet.size() == 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
