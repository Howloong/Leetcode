//在 `n*m` 大小的棋盘中，有黑白两种棋子，黑棋记作字母 `"X"`, 白棋记作字母 `"O"`，空余位置记作 `"."`。当落下的棋子与其他相同颜色的棋
//子在行、列或对角线完全包围（中间不存在空白位置）另一种颜色的棋子，则可以翻转这些棋子的颜色。
//
//![1.gif](https://pic.leetcode-cn.com/1630396029-eTgzpN-6da662e67368466a96d203
//f67bb6e793.gif){:height=170px}![2.gif](https://pic.leetcode-cn.com/1630396240-
//nMvdcc-8e4261afe9f60e05a4f740694b439b6b.gif){:height=170px}![3.gif](https://pic.
//leetcode-cn.com/1630396291-kEtzLL-6fcb682daeecb5c3f56eb88b23c81d33.gif){:height=170
//px}
//
//「力扣挑战赛」黑白翻转棋项目中，将提供给选手一个未形成可翻转棋子的棋盘残局，其状态记作 `chessboard`。若下一步可放置一枚黑棋，请问选手最多能翻转
//多少枚白棋。
//
//**注意：**
//- 若翻转白棋成黑棋后，棋盘上仍存在可以翻转的白棋，将可以 **继续** 翻转白棋
//- 输入数据保证初始棋盘状态无可以翻转的棋子且存在空余位置
//
//**示例 1：**
//
//> 输入：`chessboard = ["....X.","....X.","XOOO..","......","......"]`
//>
//> 输出：`3`
//>
//> 解释：
//> 可以选择下在 `[2,4]` 处，能够翻转白方三枚棋子。
//
//**示例 2：**
//
//> 输入：`chessboard = [".X.",".O.","XO."]`
//>
//> 输出：`2`
//>
//> 解释：
//> 可以选择下在 `[2,2]` 处，能够翻转白方两枚棋子。
//> ![2126c1d21b1b9a9924c639d449cc6e65.gif](https://pic.leetcode-cn.com/16266832
//55-OBtBud-2126c1d21b1b9a9924c639d449cc6e65.gif)
//
//**示例 3：**
//
//> 输入：`chessboard = [".......",".......",".......","X......",".O.....","..O....
//","....OOX"]`
//>
//> 输出：`4`
//>
//> 解释：
//> 可以选择下在 `[6,3]` 处，能够翻转白方四枚棋子。
//> ![803f2f04098b6174397d6c696f54d709.gif](https://pic.leetcode-cn.com/16303937
//70-Puyked-803f2f04098b6174397d6c696f54d709.gif)
//
//**提示：**
//- `1 <= chessboard.length, chessboard[i].length <= 8`
//- `chessboard[i]` 仅包含 `"."、"O"` 和 `"X"`
//
// Related Topics 广度优先搜索 数组 矩阵 👍 75 👎 0

package leetcode.editor.cn.java;

import java.util.ArrayDeque;

//Java:黑白翻转棋
//Time:2023-07-01 15:06:45
class PLCP_41_FHi6rV {
    public static void main(String[] args) {
        Solution solution = new PLCP_41_FHi6rV().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] idx = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1},
                {1, -1}, {1, 0}, {1, 1}};

        public int flipChess(String[] chessboard) {
            int max = 0;
            char[][] chars = new char[chessboard.length][chessboard[0].length()];
            for (int i = 0; i < chars.length; i++) {
                for (int j = 0; j < chars[0].length; j++) {
                    chars[i][j] = chessboard[i].charAt(j);
                }
            }
            for (int i = 0; i < chessboard.length; i++) {
                for (int j = 0; j < chessboard[i].length(); j++) {
                    char c = chessboard[i].charAt(j);
                    if (c == 'X' || c == 'O') {
                        continue;
                    }
                    if (!hasNeighbor(chars, i, j)) {
                        continue;
                    }
                    char[][] sTemp = new char[chars.length][chars[0].length];
                    for (int k = 0; k < chars.length; k++) {
                        System.arraycopy(chars[k], 0, sTemp[k], 0, chars[k].length);
                    }
                    max = Math.max(max, func(sTemp, i, j));
                }
            }
            return max;
        }

        public boolean hasNeighbor(char[][] chessboard, int x, int y) {
            int[][] idx = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1},
                    {1, -1}, {1, 0}, {1, 1}};
            for (int[] ints : idx) {
                int newX = x + ints[0];
                int newY = y + ints[1];
                if (newX >= 0 && newX < chessboard.length && newY >= 0 && newY < chessboard[0].length) {
                    if (chessboard[newX][newY] == 'O') {
                        return true;
                    }
                }
            }
            return false;
        }

        public int func(char[][] chessboard, int x, int y) {
            int sum = 0;
            ArrayDeque<int[]> arrayDeque = new ArrayDeque<>();
            chessboard[x][y] = 'X';
            arrayDeque.offer(new int[]{x, y});
            while (!arrayDeque.isEmpty()) {
                int[] t = arrayDeque.poll();
                for (int i = 0; i < 8; i++)
                    if (judge(chessboard, t[0], t[1], idx[i][0], idx[i][1])) {
                        int newX = t[0] + idx[i][0];
                        int newY = t[1] + idx[i][1];
                        while (chessboard[newX][newY] != 'X') {
                            arrayDeque.offer(new int[]{newX, newY});
                            chessboard[newX][newY] = 'X';
                            newX += idx[i][0];
                            newY += idx[i][1];
                            sum++;
                        }
                    }
            }
            return sum;
        }


        public boolean judge(char[][] board, int x, int y, int dx, int dy) {
            x += dx;
            y += dy;
            while (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
                if (board[x][y] == 'X') {
                    return true;
                }
                if (board[x][y] == '.') {
                    return false;
                }
                x += dx;
                y += dy;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
