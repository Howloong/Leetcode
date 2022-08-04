//给定两个字符串 s 和 t ，它们只包含小写字母。
//
// 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。 
//
// 请找出在 t 中被添加的字母。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcd", t = "abcde"
//输出："e"
//解释：'e' 是那个被添加的字母。
// 
//
// 示例 2： 
//
// 
//输入：s = "", t = "y"
//输出："y"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 1000 
// t.length == s.length + 1 
// s 和 t 只包含小写字母 
// 
//
// Related Topics 位运算 哈希表 字符串 排序 👍 335 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

//Java:找不同
//Time:2022-08-01 17:02:26
class P389_FindTheDifference {
    public static void main(String[] args) {
        Solution solution = new P389_FindTheDifference().new Solution();
        System.out.println(solution.findTheDifference("abcde", "abdcde"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char findTheDifference(String s, String t) {
            if (s.equals("")) {
                return t.charAt(0);
            }
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                sum += s.charAt(i);
            }
            int sum2 = 0;
            for (int i = 0; i < t.length(); i++) {
                sum2 += t.charAt(i);
            }
            return (char) (sum2 - sum);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
