package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> list;
    public int index = 0;

    public List<Integer> spiralOrder(int[][] matrix) {
        list = new ArrayList<>();
        int len = matrix[0].length * matrix.length;
        if (matrix.length == 1) {
            for (int i :
                    matrix[0]) {
                list.add(i);
            }
            return list;
        } else if (matrix[0].length == 1) {
            for (int i = 0; i < matrix.length; i++) {
                list.add(matrix[i][0]);
            }
            return list;
        }
        int row = 0;
        int col = 0;
        int p = matrix[0].length;
        int q = matrix.length;
        while (index < len) {
            //只剩中心的一个元素了，单独处理
            if (p == q && q == 1) {
                list.add(matrix[row][col]);
                break;
            }
            //在row行从左到右走p个
            leftToRight(matrix, col, col + p, row);
            //列往后走
            col += p - 1;
            //列少一个长度
            q--;
            //行下移
            row++;

            if (q > 0 && index < len) {
                topToBottom(matrix, row, row + q, col);
                row += q - 1;
                p--;
                col--;
            }
            if (p > 0 && index < len) {
                rightToLeft(matrix, col, col - p, row);
                col -= p - 1;
                q--;
                row--;
            }
            if (q > 0 && index < len) {
                bottomToTop(matrix, row, row - q, col);
                row -= q - 1;
                p--;
                col++;
            }

        }
        return list;
    }

    public void leftToRight(int[][] matrix, int startJ, int endJ, int row) {
        for (int j = startJ; j < endJ; j++) {
            list.add(matrix[row][j]);
            index++;
        }
    }

    public void topToBottom(int[][] matrix, int startI, int endI, int col) {
        for (int i = startI; i < endI; i++) {
            list.add(matrix[i][col]);
            index++;
        }
    }

    public void rightToLeft(int[][] matrix, int startJ, int endJ, int row) {
        for (int j = startJ; j > endJ; j--) {
            list.add(matrix[row][j]);
            index++;
        }
    }

    public void bottomToTop(int[][] matrix, int startI, int endI, int col) {
        for (int i = startI; i > endI; i--) {
            list.add(matrix[i][col]);
            index++;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

