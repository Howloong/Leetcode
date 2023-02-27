//爱丽丝和鲍勃继续他们的石子游戏。许多堆石子 排成一行，每堆都有正整数颗石子 piles[i]。游戏以谁手中的石子最多来决出胜负。 
//
// 爱丽丝和鲍勃轮流进行，爱丽丝先开始。最初，M = 1。 
//
// 在每个玩家的回合中，该玩家可以拿走剩下的 前 X 堆的所有石子，其中 1 <= X <= 2M。然后，令 M = max(M, X)。 
//
// 游戏一直持续到所有石子都被拿走。 
//
// 假设爱丽丝和鲍勃都发挥出最佳水平，返回爱丽丝可以得到的最大数量的石头。 
//
// 
//
// 示例 1： 
//
// 
//输入：piles = [2,7,9,4,4]
//输出：10
//解释：如果一开始Alice取了一堆，Bob取了两堆，然后Alice再取两堆。爱丽丝可以得到2 + 4 + 4 = 10堆。如果Alice一开始拿走了两堆，那
//么Bob可以拿走剩下的三堆。在这种情况下，Alice得到2 + 7 = 9堆。返回10，因为它更大。
// 
//
// 示例 2: 
//
// 
//输入：piles = [1,2,3,4,5,100]
//输出：104
// 
//
// 
//
// 提示： 
//
// 
// 1 <= piles.length <= 100 
// 
// 1 <= piles[i] <= 10⁴ 
// 
//
// Related Topics 数组 数学 动态规划 博弈 👍 185 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Map;

//Java:石子游戏 II
//Time:2023-02-22 10:28:52
class P1140_StoneGameIi {
    public static void main(String[] args) {
        Solution solution = new P1140_StoneGameIi().new Solution();
        System.out.println(solution.stoneGameII(new int[]{86, 11, 7, 6, 46, 37, 72, 67, 33, 25, 54, 45}) == 273);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] cache;
        int n;
        int[] s;

        public int stoneGameII(int[] piles) {
            n = piles.length;
            cache = new int[n - 1][(n + 1) / 4 + 1];
            s = piles;
            for (int i = n - 2; i >= 0; i--) {
                s[i] += s[i + 1];
            }
            for (int[] ints : cache) {
                Arrays.fill(ints, -1);
            }
            return dfs(0, 1);
        }

        public int dfs(int i, int M) {
            if (i + M * 2 >= n) {
                return s[i];
            }
            if (cache[i][M] != -1) {
                return cache[i][M];
            }
            int min = Integer.MAX_VALUE;
            for (int x = 1; x <= M * 2; x++) {
                min = Math.min(min, dfs(x + i, Math.max(x, M)));
            }
            cache[i][M] = s[i] - min;
            return s[i] - min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
