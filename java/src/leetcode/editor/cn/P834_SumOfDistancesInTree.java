//给定一个无向、连通的树。树中有 n 个标记为 0...n-1 的节点以及 n-1 条边 。 
//
// 给定整数 n 和数组 edges ， edges[i] = [ai, bi]表示树中的节点 ai 和 bi 之间有一条边。 
//
// 返回长度为 n 的数组 answer ，其中 answer[i] 是树中第 i 个节点与所有其他节点之间的距离之和。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: n = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
//输出: [8,12,6,10,10,10]
//解释: 树如图所示。
//我们可以计算出 dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5) 
//也就是 1 + 1 + 2 + 2 + 2 = 8。 因此，answer[0] = 8，以此类推。
// 
//
// 示例 2: 
// 
// 
//输入: n = 1, edges = []
//输出: [0]
// 
//
// 示例 3: 
// 
// 
//输入: n = 2, edges = [[1,0]]
//输出: [1,1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= n <= 3 * 10⁴ 
// edges.length == n - 1 
// edges[i].length == 2 
// 0 <= ai, bi < n 
// ai != bi 
// 给定的输入保证为有效的树 
// 
//
// Related Topics 树 深度优先搜索 图 动态规划 👍 416 👎 0

package leetcode.editor.cn.java;

import java.util.ArrayList;

//Java:树中距离之和
//Time:2023-07-16 11:21:23
class P834_SumOfDistancesInTree {
    public static void main(String[] args) {
        Solution solution = new P834_SumOfDistancesInTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int sum1;
        ArrayList<ArrayList<Integer>> list;
        int[] f;
        int[] s;
        int n;

        public int[] sumOfDistancesInTree(int n, int[][] edges) {
            list = new ArrayList<>(n);
            list.ensureCapacity(n);
            for (int i = 0; i < n; i++) {
                list.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                list.get(edge[0]).add(edge[1]);
                list.get(edge[1]).add(edge[0]);
            }
            s = new int[n];
            f = new int[n];
            this.n = n;
            dfs1(0, 0, 0);
            f[0] = sum1;
            dfs2(0, 0);
            return f;
        }

        public void dfs1(int u, int depth, int father) {
            sum1 += depth;
            int sum = 0;
            for (int i = 0; i < list.get(u).size(); i++) {
                int integer = list.get(u).get(i);
                if (integer == father) {
                    continue;
                }
                dfs1(integer, depth + 1, u);
                sum += s[integer];
            }
            s[u] = sum + 1;
        }

        public void dfs2(int u, int father) {
            for (int i = 0; i < list.get(u).size(); i++) {
                int integer = list.get(u).get(i);
                if (integer == father) {
                    continue;
                }
                f[integer] = f[u] + n - 2 * s[integer];
                dfs2(integer, u);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
