//定义一个函数 f(s)，统计 s 中（按字典序比较）最小字母的出现频次 ，其中 s 是一个非空字符串。 
//
// 例如，若 s = "dcce"，那么 f(s) = 2，因为字典序最小字母是 "c"，它出现了 2 次。 
//
// 现在，给你两个字符串数组待查表 queries 和词汇表 words 。对于每次查询 queries[i] ，需统计 words 中满足 f(
//queries[i]) < f(W) 的 词的数目 ，W 表示词汇表 words 中的每个词。 
//
// 请你返回一个整数数组 answer 作为答案，其中每个 answer[i] 是第 i 次查询的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：queries = ["cbd"], words = ["zaaaz"]
//输出：[1]
//解释：查询 f("cbd") = 1，而 f("zaaaz") = 3 所以 f("cbd") < f("zaaaz")。
// 
//
// 示例 2： 
//
// 
//输入：queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
//输出：[1,2]
//解释：第一个查询 f("bbb") < f("aaaa")，第二个查询 f("aaa") 和 f("aaaa") 都 > f("cc")。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= queries.length <= 2000 
// 1 <= words.length <= 2000 
// 1 <= queries[i].length, words[i].length <= 10 
// queries[i][j]、words[i][j] 都由小写英文字母组成 
// 
//
// Related Topics 数组 哈希表 字符串 二分查找 排序 👍 73 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java:比较字符串最小字母出现频次
//Time:2023-06-10 09:36:45
class P1170_CompareStringsByFrequencyOfTheSmallestCharacter {
    public static void main(String[] args) {
        Solution solution = new P1170_CompareStringsByFrequencyOfTheSmallestCharacter().new Solution();
        System.out.println(Arrays.toString(solution.numSmallerByFrequency(new String[]{"bbb", "cc"},
                new String[]{"a", "aa", "aaa", "aaaa"})));
        System.out.println(Arrays.toString(solution.numSmallerByFrequency(new String[]{"cbd"},
                new String[]{"zaaaz"})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] nums = new int[26];

        public int[] numSmallerByFrequency(String[] queries, String[] words) {
            int lenA = queries.length;
            int lenB = words.length;
            int[] funcQuery = new int[lenA];
            for (int i = 0; i < lenA; i++) {
                funcQuery[i] = getFuc(queries[i]);
            }
            int[] funcWord = new int[lenB];
            for (int i = 0; i < lenB; i++) {
                funcWord[i] = getFuc(words[i]);
            }
            Arrays.sort(funcWord);
            int[] res = new int[lenA];
            for (int i = 0; i < lenA; i++) {
                res[i] = lenB - getAns(funcQuery[i] + 1, funcWord);
            }
            return res;

        }

        public int getFuc(String word) {
            Arrays.fill(nums, 0);
            for (char c : word.toCharArray()) {
                nums[c - 'a']++;
            }
            int res = 0;
            for (int num : nums) {
                if (num != 0) {
                    res = num;
                    break;
                }
            }
            return res;
        }

        public int getAns(int num, int[] words) {
            int left = 0;
            int right = words.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (num > words[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
