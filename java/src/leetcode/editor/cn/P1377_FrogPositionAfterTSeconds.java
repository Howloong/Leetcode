//给你一棵由 n 个顶点组成的无向树，顶点编号从 1 到 n。青蛙从 顶点 1 开始起跳。规则如下： 
//
// 
// 在一秒内，青蛙从它所在的当前顶点跳到另一个 未访问 过的顶点（如果它们直接相连）。 
// 青蛙无法跳回已经访问过的顶点。 
// 如果青蛙可以跳到多个不同顶点，那么它跳到其中任意一个顶点上的机率都相同。 
// 如果青蛙不能跳到任何未访问过的顶点上，那么它每次跳跃都会停留在原地。 
// 
//
// 无向树的边用数组 edges 描述，其中 edges[i] = [ai, bi] 意味着存在一条直接连通 ai 和 bi 两个顶点的边。 
//
// 返回青蛙在 t 秒后位于目标顶点 target 上的概率。与实际答案相差不超过 10⁻⁵ 的结果将被视为正确答案。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 2, target = 4
//输出：0.16666666666666666 
//解释：上图显示了青蛙的跳跃路径。青蛙从顶点 1 起跳，第 1 秒 有 1/3 的概率跳到顶点 2 ，然后第 2 秒 有 1/2 的概率跳到顶点 4，因此青蛙
//在 2 秒后位于顶点 4 的概率是 1/3 * 1/2 = 1/6 = 0.16666666666666666 。 
// 
//
// 示例 2： 
//
// 
//
// 
//输入：n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 1, target = 7
//输出：0.3333333333333333
//解释：上图显示了青蛙的跳跃路径。青蛙从顶点 1 起跳，有 1/3 = 0.3333333333333333 的概率能够 1 秒 后跳到顶点 7 。 
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// edges.length == n - 1 
// edges[i].length == 2 
// 1 <= ai, bi <= n 
// 1 <= t <= 50 
// 1 <= target <= n 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 图 👍 74 👎 0

package leetcode.editor.cn.java;

//Java:T 秒后青蛙的位置
//Time:2023-05-24 10:58:46
class P1377_FrogPositionAfterTSeconds {
    public static void main(String[] args) {
        Solution solution = new P1377_FrogPositionAfterTSeconds().new Solution();
//        System.out.println(solution.frogPosition(9, new int[][]{{2, 1}, {3, 1}, {4, 2}, {5, 1}, {6, 2}, {7, 5}, {8, 7}, {9, 7}}, 6, 8));
        System.out.println(solution.frogPosition(22, new int[][]{{2, 1}, {3, 1}, {4, 2}, {5, 2}, {6, 4}, {7, 4}, {8, 4}, {9, 3}, {10, 4},
                {11, 4}, {12, 5}, {13, 8}, {14, 9}, {15, 10}, {16, 7}, {17, 7}, {18, 15}, {19, 9}, {20, 11}, {21, 16}, {22, 19}}, 4, 7));
//        System.out.println(solution.frogPosition(7, new int[][]{{1, 2}, {1, 3}, {1, 7}, {2, 4}, {2, 6}, {3, 5}}, 20, 6));
//        System.out.println(solution.frogPosition(7, new int[][]{{1, 2}, {1, 3}, {1, 7}, {2, 4}, {2, 6}, {3, 5}}, 1, 7));
//        System.out.println(solution.frogPosition(8, new int[][]{{2, 1}, {3, 2}, {4, 1}, {5, 1}, {6, 4}, {7, 1}, {8, 7}}, 7, 7));
//        System.out.println(solution.frogPosition(5, new int[][]{{1, 5}, {1, 4}, {5, 3}, {3, 2}}, 3, 2));
//        System.out.println(solution.frogPosition(3, new int[][]{{2, 1}, {3, 2}}, 1, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        boolean found = false;
        double score = 0;
        boolean[] visited;

        public double frogPosition(int n, int[][] edges, int t, int target) {
            int[][] nums = new int[n][n + 1];
            for (int[] edge : edges) {
                nums[edge[0] - 1][edge[1] - 1] = 1;
                nums[edge[1] - 1][edge[0] - 1] = 1;
                nums[edge[0] - 1][n]++;
                nums[edge[1] - 1][n]++;
            }
            nums[0][n]++;
            visited = new boolean[n];
            visited[0] = true;
            dfs(nums, 0, n, t, target - 1, 1);
            return score;
        }

        public void dfs(int[][] nums, int location, int n, int restTime, int target, double score) {
            if (target == location) {
                if (restTime == 0 || nums[location][n] == 1) {
                    this.score = score;
                    found = true;
                    return;
                }
            }
            if (restTime != 0 && target == location) {
                this.score = 0;
                found = true;
                return;
            }
            if (restTime == 0 || nums[location][n] == 1) {
                return;
            }
            for (int i = 0; i < n && !found; i++) {
                if (!visited[i] && nums[location][i] != 0) {
                    visited[i] = true;
                    dfs(nums, i, n, restTime - 1, target, score * (1.0 / (nums[location][n] - 1)));
                    visited[i] = false;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
