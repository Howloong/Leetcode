//你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。 
//
// 注意：本题中，每个活字字模只能使用一次。 
//
// 
//
// 示例 1： 
//
// 
//输入："AAB"
//输出：8
//解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
// 
//
// 示例 2： 
//
// 
//输入："AAABBC"
//输出：188
// 
//
// 示例 3： 
//
// 
//输入："V"
//输出：1 
//
// 
//
// 提示： 
//
// 
// 1 <= tiles.length <= 7 
// tiles 由大写英文字母组成 
// 
//
// Related Topics 字符串 回溯 👍 153 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Java:活字印刷
//Time:2022-09-14 10:50:31
class P1079_LetterTilePossibilities {
    public static void main(String[] args) {
        Solution solution = new P1079_LetterTilePossibilities().new Solution();
        System.out.println(solution.numTilePossibilities("AAB"));
//        System.out.println(solution.numTilePossibilities("AAABBC"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int sum = 0;
        Set<String> res = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        public int numTilePossibilities(String tiles) {
            char[] tileChars = tiles.toCharArray();
            Arrays.sort(tileChars);
            boolean[] used = new boolean[tileChars.length];
            backTracking(tileChars, used);
            return res.size();
        }

        public void backTracking(char[] tileChars, boolean[] used) {
            for (int i = 0; i < tileChars.length; i++) {
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                sb.append(tileChars[i]);
                res.add(sb.toString());
                backTracking(tileChars, used);
                sb.deleteCharAt(sb.length() - 1);
                used[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
