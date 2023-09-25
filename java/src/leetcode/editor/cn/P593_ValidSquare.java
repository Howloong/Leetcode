//给定2D空间中四个点的坐标 p1, p2, p3 和 p4，如果这四个点构成一个正方形，则返回 true 。 
//
// 点的坐标 pi 表示为 [xi, yi] 。输入 不是 按任何顺序给出的。 
//
// 一个 有效的正方形 有四条等边和四个等角(90度角)。 
//
// 
//
// 示例 1: 
//
// 
//输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
//输出: True
// 
//
// 示例 2: 
//
// 
//输入：p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
//输出：false
// 
//
// 示例 3: 
//
// 
//输入：p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]
//输出：true
// 
//
// 
//
// 提示: 
//
// 
// p1.length == p2.length == p3.length == p4.length == 2 
// -10⁴ <= xi, yi <= 10⁴ 
// 
//
// Related Topics 几何 数学 👍 135 👎 0

package leetcode.editor.cn.java;

//Java:有效的正方形
//Time:2022-07-29 12:52:39
class P593_ValidSquare {
    public static void main(String[] args) {
        Solution solution = new P593_ValidSquare().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
            double midX = (p1[0] + p2[0] + p3[0] + p4[0]) / 4.0;
            double midY = (p1[1] + p2[1] + p3[1] + p4[1]) / 4.0;
            double d1 = distance(midX, midY, p1[0], p1[1]);
            double d2 = distance(midX, midY, p2[0], p2[1]);
            double d3 = distance(midX, midY, p3[0], p3[1]);
            double d4 = distance(midX, midY, p4[0], p4[1]);
            if (d1 == d2 && d1 == d3 && d1 == d4 && d1 != 0) {
                return (midY - p1[1]) * (midY - p2[1]) + (midX - p1[0]) * (midX - p2[0]) == 0 ||
                        (midY - p1[1]) * (midY - p3[1]) + (midX - p1[0]) * (midX - p3[0]) == 0;
            }
            return false;
        }

        public double distance(double x1, double y1, double x2, double y2) {
            return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
