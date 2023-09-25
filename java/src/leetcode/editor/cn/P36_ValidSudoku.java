//请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图） 
// 
//
// 
//
// 注意： 
//
// 
// 一个有效的数独（部分已被填充）不一定是可解的。 
// 只需要根据以上规则，验证已经填入的数字是否有效即可。 
// 空白格用 '.' 表示。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = 
//[["5","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = 
//[["8","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//输出：false
//解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无
//效的。 
//
// 
//
// 提示： 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] 是一位数字（1-9）或者 '.' 
// 
//
// Related Topics 数组 哈希表 矩阵 👍 932 👎 0

package leetcode.editor.cn.java;

//Java:有效的数独
//Time:2022-08-04 16:10:52
class P36_ValidSudoku {
    public static void main(String[] args) {
        Solution solution = new P36_ValidSudoku().new Solution();
/*        char[][] c = {{'.', '.', '4', '.', '.', '.', '6', '3', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.', '.'}, {'5', '.', '.', '.', '.'
                , '.', '.', '9', '.'}, {'.', '.', '.', '5', '6', '.', '.', '.', '.'}, {'4', '.', '3', '.', '.', '.', '.', '.', '1'}, {'.',
                '.', '.', '7', '.', '.', '.', '.', '.'}, {'.', '.', '.', '5', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.', '.'}};*/
        char[][] c = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(solution.isValidSudoku(c));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            int n = board.length;
            for (int i = 0; i < n; i++) {
                int[] c1 = new int[9];
                int[] c2 = new int[9];
                for (int j = 0; j < n; j++) {
                    if (board[i][j] != '.') {
                        if (c1[board[i][j] - '0' - 1] == 1) {
                            return false;
                        }
                        c1[board[i][j] - '0' - 1]++;
                    }
                    if (board[j][i] != '.') {
                        if (c2[board[j][i] - '0' - 1] == 1) return false;
                        c2[board[j][i] - '0' - 1]++;
                    }
                    int startRow = 3 * (i / 3);
                    int startCol = 3 * (j / 3);
                    for (int k = startRow; k < startRow + 3; k++) {
                        for (int l = startCol; l < startCol + 3; l++) {
                            if (board[i][j] != '.' && board[i][j] == board[k][l] && i != k && j != l) {
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
