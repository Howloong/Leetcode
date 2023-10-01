//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics 回溯 👍 1043 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

//Java：组合
class P77_Combinations {
    public static void main(String[] args) {
        Solution solution = new P77_Combinations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> result;
        ArrayDeque<Integer> path;

        public List<List<Integer>> combine(int n, int k) {
            result = new ArrayList<>();
            path = new ArrayDeque<>();
            backTracking(n, k, 1);
            return result;
        }

        public void backTracking(int n, int k, int startIndex) {
            if (path.size() == k) {
                result.add(new ArrayList<>(path));
                return;
            }
            for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
                path.push(i);
                backTracking(n, k, i + 1);
                path.pop();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
