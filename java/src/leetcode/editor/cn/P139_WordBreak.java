//给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。 
//
// 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
// 
//
// 示例 2： 
//
// 
//输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
//     注意，你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 
//输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s 和 wordDict[i] 仅有小写英文字母组成 
// wordDict 中的所有字符串 互不相同 
// 
//
// Related Topics 字典树 记忆化搜索 哈希表 字符串 动态规划 👍 1779 👎 0

package leetcode.editor.cn.java;

import java.util.ArrayList;
import java.util.List;

//Java:单词拆分
//Time:2022-08-31 23:09:10
class P139_WordBreak {
    public static void main(String[] args) {
        Solution solution = new P139_WordBreak().new Solution();
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        System.out.println(solution.wordBreak("leetcode", list));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
//            boolean[] memory = new boolean[s.length()];
//            return backTracking(s, wordDict, 0, memory);
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    String str = s.substring(j, i);
                    if (wordDict.contains(str) && dp[j]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }

      /*  public boolean backTracking(String s, List<String> wordDict, int index, boolean[] memory) {
            if (index >= s.length()) {
                return true;
            }
            if (memory[index]) {
                return !memory[index];
            }
            for (int i = index; i < s.length(); i++) {
                String str = s.substring(index, i + 1);
                if (wordDict.contains(str) && backTracking(s, wordDict, i + 1, memory)) {
                    return true;
                }
            }
            memory[index] = true;
            return false;
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}
