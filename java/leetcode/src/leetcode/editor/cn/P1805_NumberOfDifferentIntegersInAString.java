//给你一个字符串 word ，该字符串由数字和小写英文字母组成。 
//
// 请你用空格替换每个不是数字的字符。例如，"a123bc34d8ef34" 将会变成 " 123 34 8 34" 。注意，剩下的这些整数为（相邻彼此至少有
//一个空格隔开）："123"、"34"、"8" 和 "34" 。 
//
// 返回对 word 完成替换后形成的 不同 整数的数目。 
//
// 只有当两个整数的 不含前导零 的十进制表示不同， 才认为这两个整数也不同。 
//
// 
//
// 示例 1： 
//
// 
//输入：word = "a123bc34d8ef34"
//输出：3
//解释：不同的整数有 "123"、"34" 和 "8" 。注意，"34" 只计数一次。
// 
//
// 示例 2： 
//
// 
//输入：word = "leet1234code234"
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：word = "a1b01c001"
//输出：1
//解释："1"、"01" 和 "001" 视为同一个整数的十进制表示，因为在比较十进制值时会忽略前导零的存在。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 1000 
// word 由数字和小写英文字母组成 
// 
//
// Related Topics 哈希表 字符串 👍 27 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//Java:字符串中不同整数的数目
//Time:2022-10-05 12:31:21
class P1805_NumberOfDifferentIntegersInAString {
    public static void main(String[] args) {
        Solution solution = new P1805_NumberOfDifferentIntegersInAString().new Solution();
//        System.out.println(solution.numDifferentIntegers("a123bc34d8ef34"));
//        System.out.println(solution.numDifferentIntegers("gi851a851q8510v"));
//        System.out.println(solution.numDifferentIntegers("a1b01c001"));
//        System.out.println(solution.numDifferentIntegers("leet1234code234"));
        System.out.println(solution.numDifferentIntegers("leet0000code00a00"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDifferentIntegers(String word) {
            Set<String> set = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            int i = 0;
            int j = 0;
            while (i < word.length()) {
                if (!Character.isDigit(word.charAt(i))) {
                    i++;
                    continue;
                }
//                sb.append(word.charAt(i));
                j = i;
                while (j < word.length() && word.charAt(j) == '0') {
                    j++;
                }
                while (j < word.length() && Character.isDigit(word.charAt(j))) {
                    sb.append(word.charAt(j));
                    j++;
                }
                set.add(sb.toString());
                sb.setLength(0);
                i = j;
            }
            return set.size();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
