//n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。 
//
// 你需要按照以下要求，给这些孩子分发糖果： 
//
// 
// 每个孩子至少分配到 1 个糖果。 
// 相邻两个孩子评分更高的孩子会获得更多的糖果。 
// 
//
// 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。 
//
// 
//
// 示例 1： 
//
// 
//输入：ratings = [1,0,2]
//输出：5
//解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
// 
//
// 示例 2： 
//
// 
//输入：ratings = [1,2,2]
//输出：4
//解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
//     第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。 
//
// 
//
// 提示： 
//
// 
// n == ratings.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= ratings[i] <= 2 * 10⁴ 
// 
// Related Topics 贪心 数组 👍 921 👎 0

package leetcode.editor.cn;
//Java：分发糖果
class P135_Candy{
    public static void main(String[] args) {
        Solution solution = new P135_Candy().new Solution();
        System.out.println(solution.candy(new int[]{1, 0, 2, 3, 4}));
        System.out.println(solution.candy(new int[]{1,0,2}));
        System.out.println(solution.candy(new int[]{1,2,2}));
        System.out.println(solution.candy(new int[]{1,3,4,5,2}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int candy(int[] ratings) {
        int sum = 0;
//        int last = 0;
        int[] candy = new int[ratings.length];
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i+1] > ratings[i]) {
                candy[i + 1] = candy[i] + 1;
            }
        }
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                candy[i - 1] = Math.max(candy[i - 1], candy[i] + 1);
            }
            sum += candy[i];
        }
        return sum + candy[0] + ratings.length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
