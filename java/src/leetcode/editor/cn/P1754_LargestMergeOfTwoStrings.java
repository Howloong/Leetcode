//给你两个字符串 word1 和 word2 。你需要按下述方式构造一个新字符串 merge ：如果 word1 或 word2 非空，选择 下面选项之一 继
//续操作：
//
// 
// 如果 word1 非空，将 word1 中的第一个字符附加到 merge 的末尾，并将其从 word1 中移除。 
// 
//
// 
// 例如，word1 = "abc" 且 merge = "dv" ，在执行此选项操作之后，word1 = "bc" ，同时 merge = "dva" 。 
//
// 
// 
// 如果 word2 非空，将 word2 中的第一个字符附加到 merge 的末尾，并将其从 word2 中移除。
// 
// 例如，word2 = "abc" 且 merge = "" ，在执行此选项操作之后，word2 = "bc" ，同时 merge = "a" 。 
// 
// 
//
//
// 返回你可以构造的字典序 最大 的合并字符串 merge 。 
//
// 长度相同的两个字符串 a 和 b 比较字典序大小，如果在 a 和 b 出现不同的第一个位置，a 中字符在字母表中的出现顺序位于 b 中相应字符之后，就认为
//字符串 a 按字典序比字符串 b 更大。例如，"abcd" 按字典序比 "abcc" 更大，因为两个字符串出现不同的第一个位置是第四个字符，而 d 在字母表中的
//出现顺序位于 c 之后。 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "cabaa", word2 = "bcaaa"
//输出："cbcabaaaaa"
//解释：构造字典序最大的合并字符串，可行的一种方法如下所示：
//- 从 word1 中取第一个字符：merge = "c"，word1 = "abaa"，word2 = "bcaaa"
//- 从 word2 中取第一个字符：merge = "cb"，word1 = "abaa"，word2 = "caaa"
//- 从 word2 中取第一个字符：merge = "cbc"，word1 = "abaa"，word2 = "aaa"
//- 从 word1 中取第一个字符：merge = "cbca"，word1 = "baa"，word2 = "aaa"
//- 从 word1 中取第一个字符：merge = "cbcab"，word1 = "aa"，word2 = "aaa"
//- 将 word1 和 word2 中剩下的 5 个 a 附加到 merge 的末尾。
// 
//
// 示例 2： 
//
// 
//输入：word1 = "abcabc", word2 = "abdcaba"
//输出："abdcabcabcaba"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word1.length, word2.length <= 3000 
// word1 和 word2 仅由小写英文组成 
// 
//
// Related Topics 贪心 双指针 字符串 👍 51 👎 0

package leetcode.editor.cn.java;

//Java:构造字典序最大的合并字符串
//Time:2022-12-24 16:50:35
class P1754_LargestMergeOfTwoStrings {
    public static void main(String[] args) {
        Solution solution = new P1754_LargestMergeOfTwoStrings().new Solution();
//        System.out.println(solution.largestMerge("abcabc", "abdcaba"));
        System.out.println(solution.largestMerge("guguuuuuuuuuuuuuuguguuuuguug",
                "gguggggggguuggguugggggg").equals("guguuuuuuuuuuuuuuguguuuuguugguggggggguuggguuggggggg"));
//        System.out.println(solution.largestMerge("cabaa", "bcaaa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestMerge(String word1, String word2) {
            int i = 0;
            int j = 0;
            int len1 = word1.length();
            int len2 = word2.length();
            StringBuilder sb = new StringBuilder(len1 + len2);
            while (i < len1 && j < len2) {
                char c1 = word1.charAt(i);
                char c2 = word2.charAt(j);
                if (c1 < c2) {
                    sb.append(c2);
                    j++;
                } else if (c1 > c2) {
                    sb.append(c1);
                    i++;
                } else {
                    int m = i;
                    int n = j;
                    sb.append(c1);
                    while (m < len1 && n < len2 && word1.charAt(m) == word2.charAt(n)) {
                        m++;
                        n++;
                    }
                    if (m == len1) {
                        j++;
                    } else if (n == len2) {
                        i++;
                    } else {
                        if (word1.charAt(m) < word2.charAt(n)) {
                            j++;
                        } else {
                            i++;
                        }
                    }
                }
            }
            if (i < len1) {
                while (i < len1) {
                    sb.append(word1.charAt(i));
                    i++;
                }
            } else if (j < len2) {
                while (j < len2) {
                    sb.append(word2.charAt(j));
                    j++;
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
