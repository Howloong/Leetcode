//给你一个以 (radius, xCenter, yCenter) 表示的圆和一个与坐标轴平行的矩形 (x1, y1, x2, y2) ，其中 (x1, y1
//) 是矩形左下角的坐标，而 (x2, y2) 是右上角的坐标。 
//
// 如果圆和矩形有重叠的部分，请你返回 true ，否则返回 false 。 
//
// 换句话说，请你检测是否 存在 点 (xi, yi) ，它既在圆上也在矩形上（两者都包括点落在边界上的情况）。 
//
// 
//
// 示例 1 ： 
// 
// 
//输入：radius = 1, xCenter = 0, yCenter = 0, x1 = 1, y1 = -1, x2 = 3, y2 = 1
//输出：true
//解释：圆和矩形存在公共点 (1,0) 。
// 
//
// 示例 2 ： 
//
// 
//输入：radius = 1, xCenter = 1, yCenter = 1, x1 = 1, y1 = -3, x2 = 2, y2 = -1
//输出：false
// 
//
// 示例 3 ： 
// 
// 
//输入：radius = 1, xCenter = 0, yCenter = 0, x1 = -1, y1 = 0, x2 = 0, y2 = 1
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= radius <= 2000 
// -10⁴ <= xCenter, yCenter <= 10⁴ 
// -10⁴ <= x1 < x2 <= 10⁴ 
// -10⁴ <= y1 < y2 <= 10⁴ 
// 
//
// Related Topics 几何 数学 👍 97 👎 0

package leetcode.editor.cn;

//Java:圆和矩形是否有重叠
//Time:2023-07-01 15:04:50
class P1401_CircleAndRectangleOverlapping {
    public static void main(String[] args) {
        Solution solution = new P1401_CircleAndRectangleOverlapping().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
            if (xCenter >= x1 && xCenter <= x2) {
                return yCenter >= (y1 - radius) && yCenter <= (y2 + radius);
            }
            if (yCenter >= y1 && yCenter <= y2) {
                return xCenter >= (x1 - radius) && xCenter <= (x2 + radius);
            }
            return distance(xCenter, yCenter, x1, y1) <= radius || distance(xCenter, yCenter, x1, y2) <= radius
                    || distance(xCenter, yCenter, x2, y1) <= radius || distance(xCenter, yCenter, x2, y2) <= radius;
        }

        public double distance(int xCenter, int yCenter, int x, int y) {
            return Math.sqrt(Math.pow(x - xCenter, 2) + Math.pow(y - yCenter, 2));
        }

    }


//leetcode submit region end(Prohibit modification and deletion)

}
