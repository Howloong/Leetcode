//给定字符串 s 和字符串数组 words, 返回 words[i] 中是s的子序列的单词个数 。 
//
// 字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。 
//
// 
// 例如， “ace” 是 “abcde” 的子序列。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcde", words = ["a","bb","acd","ace"]
//输出: 3
//解释: 有三个是 s 的子序列的单词: "a", "acd", "ace"。
// 
//
// Example 2: 
//
// 
//输入: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 50 
// words[i]和 s 都只由小写字母组成。 
// 
//
//
// Related Topics 字典树 哈希表 字符串 排序 👍 264 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;

//Java:匹配子序列的单词数
//Time:2022-11-17 10:37:18
class P792_NumberOfMatchingSubsequences {
    public static void main(String[] args) {
        Solution solution = new P792_NumberOfMatchingSubsequences().new Solution();
        System.out.println(solution.numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numMatchingSubseq(String s, String[] words) {
            ArrayDeque<int[]>[] arrayLists = new ArrayDeque[26];

            for (int i = 0; i < 26; i++) {
                arrayLists[i] = new ArrayDeque<>();
            }
            for (int i = 0; i < words.length; i++) {
                arrayLists[words[i].charAt(0) - 'a'].offer(new int[]{i, 0});
            }
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                int size = arrayLists[index].size();
                for (int j = 0; j < size; j++) {
                    int[] t = arrayLists[index].poll();
                    int len = t[1] + 1;
                    if (words[t[0]].length() == len) {
                        count++;
                    } else {
                        arrayLists[words[t[0]].charAt(len) - 'a'].offer(new int[]{t[0], len});
                    }
                }
            }
            return count;
        }

    }


//leetcode submit region end(Prohibit modification and deletion)

}
