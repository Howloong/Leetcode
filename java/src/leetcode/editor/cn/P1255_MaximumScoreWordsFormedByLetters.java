//你将会得到一份单词表 words，一个字母表 letters （可能会有重复字母），以及每个字母对应的得分情况表 score。 
//
// 请你帮忙计算玩家在单词拼写游戏中所能获得的「最高得分」：能够由 letters 里的字母拼写出的 任意 属于 words 单词子集中，分数最高的单词集合的
//得分。 
//
// 单词拼写游戏的规则概述如下： 
//
// 
// 玩家需要用字母表 letters 里的字母来拼写单词表 words 中的单词。 
// 可以只使用字母表 letters 中的部分字母，但是每个字母最多被使用一次。 
// 单词表 words 中每个单词只能计分（使用）一次。 
// 根据字母得分情况表score，字母 'a', 'b', 'c', ... , 'z' 对应的得分分别为 score[0], score[1], ..., 
//score[25]。 
// 本场游戏的「得分」是指：玩家所拼写出的单词集合里包含的所有字母的得分之和。 
// 
//
// 
//
// 示例 1： 
//
// 输入：words = ["dog","cat","dad","good"], letters = ["a","a","c","d","d","d",
//"g","o","o"], score = [1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0]
//输出：23
//解释：
//字母得分为  a=1, c=9, d=5, g=3, o=2
//使用给定的字母表 letters，我们可以拼写单词 "dad" (5+1+5)和 "good" (3+2+2+5)，得分为 23 。
//而单词 "dad" 和 "dog" 只能得到 21 分。
//
// 示例 2：
//
// 输入：words = ["xxxz","ax","bx","cx"], letters = ["z","a","b","c","x","x","x"],
//score = [4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,10]
//输出：27
//解释：
//字母得分为  a=4, b=4, c=4, x=5, z=10
//使用给定的字母表 letters，我们可以组成单词 "ax" (4+5)， "bx" (4+5) 和 "cx" (4+5) ，总得分为 27 。
//单词 "xxxz" 的得分仅为 25 。
//
// 示例 3：
//
// 输入：words = ["leetcode"], letters = ["l","e","t","c","o","d"], score = [0,0,1,
//1,1,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0]
//输出：0
//解释：
//字母 "e" 在字母表 letters 中只出现了一次，所以无法组成单词表 words 中的单词。
//
//
//
// 提示：
//
//
// 1 <= words.length <= 14
// 1 <= words[i].length <= 15
// 1 <= letters.length <= 100
// letters[i].length == 1
// score.length == 26
// 0 <= score[i] <= 10
// words[i] 和 letters[i] 只包含小写的英文字母。
//
//
// Related Topics 位运算 数组 字符串 动态规划 回溯 状态压缩 👍 97 👎 0

package leetcode.editor.cn.java;

//Java:得分最高的单词集合
//Time:2023-02-26 13:05:16
class P1255_MaximumScoreWordsFormedByLetters {
    public static void main(String[] args) {
        Solution solution = new P1255_MaximumScoreWordsFormedByLetters().new Solution();
//        System.out.println(solution.maxScoreWords(new String[]{"dog", "cat", "dad", "good"},
//                new char[]{'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'},
//                new int[]{1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
//        System.out.println(solution.maxScoreWords(new String[]{"leetcode"},
//                new char[]{'l', 'e', 't', 'c', 'o', 'd'},
//                new int[]{0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0}
//        ));
        System.out.println(solution.maxScoreWords(new String[]{"azb", "ax", "awb", "ayb", "bpppp"},
                new char[]{'z', 'a', 'w', 'x', 'y', 'b', 'p', 'p', 'p'},
                new int[]{10, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 3, 2, 3, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int max = 0;
        public int[][] map;
        public int[] scores;

        public int maxScoreWords(String[] words, char[] letters, int[] score) {
            int[] chars = new int[26];
            map = new int[words.length][26];
            scores = new int[words.length];
            for (int i = 0; i < words.length; i++) {
                int t = 0;
                for (char c : words[i].toCharArray()) {
                    map[i][c - 'a']++;
                    t += score[c - 'a'];
                }
                scores[i] = t;
            }
            for (char letter : letters) {
                chars[letter - 'a']++;
            }
            backtracking(words, 0, chars, 0);
            return max;
        }

        public void backtracking(String[] words, int index, int[] chars, int score) {
            if (index == words.length) {
                return;
            }
            for (int i = index; i < words.length; i++) {
                int t = isValid(i, chars);
                if (t != -1) {
                    max = Math.max(max, score + t);
                    backtracking(words, i + 1, chars, score + t);
                    addBack(words[i], chars);
                }
            }
        }

        public int isValid(int index, int[] chars) {
            for (int i = 0; i < 26; i++) {
                if (map[index][i] > chars[i]) {
                    return -1;
                }
            }
            for (int i = 0; i < 26; i++) {
                chars[i] -= map[index][i];
            }
            return scores[index];
        }

        public void addBack(String word, int[] chars) {
            for (char c : word.toCharArray()) {
                chars[c - 'a']++;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
