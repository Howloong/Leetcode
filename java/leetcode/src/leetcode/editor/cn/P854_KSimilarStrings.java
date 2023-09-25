//对于某些非负整数 k ，如果交换 s1 中两个字母的位置恰好 k 次，能够使结果字符串等于 s2 ，则认为字符串 s1 和 s2 的 相似度为 k 。 
//
// 给你两个字母异位词 s1 和 s2 ，返回 s1 和 s2 的相似度 k 的最小值。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab", s2 = "ba"
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：s1 = "abc", s2 = "bca"
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length <= 20 
// s2.length == s1.length 
// s1 和 s2 只包含集合 {'a', 'b', 'c', 'd', 'e', 'f'} 中的小写字母 
// s2 是 s1 的一个字母异位词 
// 
//
// Related Topics 广度优先搜索 字符串 👍 164 👎 0

package leetcode.editor.cn;

//Java:相似度为 K 的字符串
//Time:2022-09-21 09:56:11
class P854_KSimilarStrings {
    public static void main(String[] args) {
        Solution solution = new P854_KSimilarStrings().new Solution();
        System.out.println(solution.kSimilarity("baababbaaabbabaaabaa", "abaabaabababaabababa"));
//        System.out.println(solution.kSimilarity("abac", "baca"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int res = Integer.MAX_VALUE;

        public int kSimilarity(String s1, String s2) {
            char[] char1 = s1.toCharArray();
            char[] char2 = s2.toCharArray();
            backtracking(char1, char2, 0, 0);
            return res;
        }

        public void backtracking(char[] s1, char[] s2, int startIndex, int path) {
            if (path >= res) {
                return;
            }
            if (startIndex == s1.length) {
                res = path;
                return;
            }
            if (s1[startIndex] == s2[startIndex]) {
                backtracking(s1, s2, startIndex + 1, path);
            } else {
                for (int i = startIndex + 1; i < s1.length; i++) {
                    if (s1[i] != s2[startIndex]) {
                        continue;
                    }
                    swap(s1, i, startIndex);
                    backtracking(s1, s2, 1 + startIndex, 1 + path);
                    swap(s1, i, startIndex);
                }
            }
        }

        public void swap(char[] s1, int i, int j) {
            char t = s1[i];
            s1[i] = s1[j];
            s1[j] = t;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
