//给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。 
//
// 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。 
//
// 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。 
//
// 
//
// 示例： 
//
// 
//输入：[[1,2], [2,3], [3,4]]
//输出：2
//解释：最长的数对链是 [1,2] -> [3,4]
// 
//
// 
//
// 提示： 
//
// 
// 给出数对的个数在 [1, 1000] 范围内。 
// 
//
// Related Topics 贪心 数组 动态规划 排序 👍 270 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

//Java:最长数对链
//Time:2022-09-03 10:12:16
class P646_MaximumLengthOfPairChain {
    public static void main(String[] args) {
        Solution solution = new P646_MaximumLengthOfPairChain().new Solution();
//        System.out.println(solution.findLongestChain(new int[][]{{1, 2}, {7, 8}, {4, 5}}));
        System.out.println(solution.findLongestChain(new int[][]{{-6, 9}, {1, 6}, {8, 10}, {-1, 4}, {-6, -2}, {-9, 8}, {-5, 3},
                {0, 3}}));
//        System.out.println(solution.findLongestChain(new int[][]{{3, 4}, {2, 3}, {1, 2}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLongestChain(int[][] pairs) {
            Arrays.sort(pairs, Comparator.comparingInt(value -> value[1])
                );
            int res = 1;
//        int max = 1;
            int last = pairs[0][1];
            for (int i = 1; i < pairs.length; i++) {
                if (last < pairs[i][0]) {
                    res++;
                    last = pairs[i][1];
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
