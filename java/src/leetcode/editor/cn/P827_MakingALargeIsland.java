//给你一个大小为 n x n 二进制矩阵 grid 。最多 只能将一格 0 变成 1 。 
//
// 返回执行此操作后，grid 中最大的岛屿面积是多少？ 
//
// 岛屿 由一组上、下、左、右四个方向相连的 1 形成。 
//
// 
//
// 示例 1: 
//
// 
//输入: grid = [[1, 0], [0, 1]]
//输出: 3
//解释: 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。
// 
//
// 示例 2: 
//
// 
//输入: grid = [[1, 1], [1, 0]]
//输出: 4
//解释: 将一格0变成1，岛屿的面积扩大为 4。 
//
// 示例 3: 
//
// 
//输入: grid = [[1, 1], [1, 1]]
//输出: 4
//解释: 没有0可以让我们变成1，面积依然为 4。 
//
// 
//
// 提示： 
//
// 
// n == grid.length 
// n == grid[i].length 
// 1 <= n <= 500 
// grid[i][j] 为 0 或 1 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 214 👎 0

package leetcode.editor.cn.java;

import java.util.HashSet;

//Java:最大人工岛
//Time:2022-09-18 11:01:09
class P827_MakingALargeIsland {
    public static void main(String[] args) {
        Solution solution = new P827_MakingALargeIsland().new Solution();
        System.out.println(solution.largestIsland(new int[][]{{1, 1}, {1, 1}}));
//        System.out.println(solution.largestIsland(new int[][]{{1, 0}, {1, 1}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /* dfs解法
                int max = 0;
                boolean[][] visited;
                int count = 0;
                int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
               public int largestIsland(int[][] grid) {
                    int n = grid.length;
                    visited = new boolean[n][n];
                    HashMap<Integer, Integer> numHashMap = new HashMap<>();
                    HashMap<Integer, Integer> indexHashMap = new HashMap<>();
                    int index = 0;
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            if (!visited[i][j] && grid[i][j] == 1) {
                                List<Integer> list = new ArrayList<>();
                                count = 0;
                                dfs(grid, list, i, j);
                                for (Integer integer : list) {
                                    numHashMap.put(integer, count);
                                    indexHashMap.put(integer, index);
                                }
                                index++;
                            }
                        }
                    }
                    int max = 0;
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            int sum = 0;
                            if (grid[i][j] == 0) {
                                HashSet<Integer> hashSet = new HashSet<>();
                                for (int k = 0; k < 4; k++) {
                                    int newX = i + direction[k][0];
                                    int newY = j + direction[k][1];
                                    if (newX < 0 || newX >= n || newY < 0 || newY >= n || grid[newX][newY] == 0) {
                                        continue;
                                    }
                                    index = newX * n + newY;
                                    int t = indexHashMap.get(index);
                                    if (!hashSet.contains(t)) {
                                        hashSet.add(t);
                                        sum += numHashMap.get(index);
                                    }
                                }
                                max = Math.max(max, sum + 1);
                            }
                        }
                    }
                    return max == 0 ? n * n : max;
                }

                public void dfs(int[][] grid, List<Integer> list, int x, int y) {
                    if (grid[x][y] == 0 || visited[x][y]) {
                        return;
                    }
                    int n = grid.length;
                    list.add(x * n + y);
                    visited[x][y] = true;
                    count++;
                    for (int i = 0; i < 4; i++) {
                        int newX = x + direction[i][0];
                        int newY = y + direction[i][1];
                        if (newX < 0 || newX >= n || newY < 0 || newY >= n) {
                            continue;
                        }
                        dfs(grid, list, newX, newY);
                    }
                }*/
//        并查集做法
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int n;
        int[] p;
        int[] size;
        int ans;

        public int largestIsland(int[][] grid) {
            n = grid.length;
            p = new int[n * n];
            size = new int[n * n];
            for (int i = 0; i < p.length; i++) {
                p[i] = i;
                size[i] = 1;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        for (int k = 0; k < 4; k++) {
                            int newX = i + directions[k][0];
                            int newY = j + directions[k][1];
                            if (newX < 0 || newX >= n || newY < 0 || newY >= n || grid[newX][newY] == 0) {
                                continue;
                            }
                            union(newX * n + newY, i * n + j);
                        }
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        int sum = 0;
                        HashSet<Integer> hashSet = new HashSet<>();
                        for (int k = 0; k < 4; k++) {
                            int newX = i + directions[k][0];
                            int newY = j + directions[k][1];
                            if (newX < 0 || newX >= n || newY < 0 || newY >= n || grid[newX][newY] == 0) {
                                continue;
                            }
                            int root = find(newX * n + newY);
                            if (!hashSet.contains(root)) {
                                hashSet.add(root);
                                sum += size[root];
                            }
                        }
                        ans = Math.max(ans, sum);
                    }
                }
            }
            return ans == 0 ? (grid[0][0] == 0 ? 1 : n * n) : ans + 1;
        }

        public int find(int x) {
            if (x == p[x]) {
                return x;
            }
            p[x] = find(p[x]);
            return p[x];
        }

        public void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb) {
                return;
            }
            if (size[pa] > size[pb]) {
                union(pb, pa);
            } else {
                p[pa] = p[pb];
                size[pb] += size[pa];
            }

        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
