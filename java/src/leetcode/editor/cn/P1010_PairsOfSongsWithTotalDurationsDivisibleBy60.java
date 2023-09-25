//在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。 
//
// 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望下标数字 i 和 j 满足 i < j 且有 (time[i] + 
//time[j]) % 60 == 0。 
//
// 
//
// 示例 1： 
//
// 
//输入：time = [30,20,150,100,40]
//输出：3
//解释：这三对的总持续时间可被 60 整除：
//(time[0] = 30, time[2] = 150): 总持续时间 180
//(time[1] = 20, time[3] = 100): 总持续时间 120
//(time[1] = 20, time[4] = 40): 总持续时间 60
// 
//
// 示例 2： 
//
// 
//输入：time = [60,60,60]
//输出：3
//解释：所有三对的总持续时间都是 120，可以被 60 整除。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= time.length <= 6 * 10⁴ 
// 1 <= time[i] <= 500 
// 
//
// Related Topics 数组 哈希表 计数 👍 243 👎 0

package leetcode.editor.cn.java;

//Java:总持续时间可被 60 整除的歌曲
//Time:2023-05-07 15:25:09
class P1010_PairsOfSongsWithTotalDurationsDivisibleBy60 {
    public static void main(String[] args) {
        Solution solution = new P1010_PairsOfSongsWithTotalDurationsDivisibleBy60().new Solution();
//        System.out.println(solution.numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40}));
//        System.out.println(solution.numPairsDivisibleBy60(new int[]{30,30,30}));
        System.out.println(solution.numPairsDivisibleBy60(new int[]{60, 60, 60}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numPairsDivisibleBy60(int[] time) {
            int[] times = new int[60];
            for (int i : time) {
                times[i % 60]++;
            }
            int sum = 0;
            for (int i = 1; i < 30; i++) {
                sum += times[i] * times[60 - i];
            }
            sum += (times[30] * (times[30] - 1)) / 2;
            sum += times[0] % 2 == 0 ? (times[0] >> 1) * (times[0] - 1) : ((times[0] - 1) >> 1) * times[0];
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
