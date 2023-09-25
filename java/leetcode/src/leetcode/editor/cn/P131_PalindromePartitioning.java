//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 回溯 👍 1191 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

//Java：分割回文串
class P131_PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new P131_PalindromePartitioning().new Solution();
        System.out.println(solution.partition("aab"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> result = new ArrayList<>();
        ArrayDeque<String> path = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        public List<List<String>> partition(String s) {
            backTracking(0, s);
            return result;
        }

        public void backTracking(int startIndex, String s) {
            if (startIndex >= s.length()) {
                result.add(new ArrayList<>(path));
                return;
            }
            for (int i = startIndex; i < s.length(); i++) {
                String str = s.substring(startIndex, i + 1);
                if (str.equals(new StringBuilder(str).reverse().toString())) {
                    path.addLast(str);
                } else
                    continue;
                backTracking(i + 1, s);
                path.removeLast();
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
