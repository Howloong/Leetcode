//我们有一个 n 项的集合。给出两个整数数组 values 和 labels ，第 i 个元素的值和标签分别是 values[i] 和 labels[i]。还
//会给出两个整数 numWanted 和 useLimit 。 
//
// 从 n 个元素中选择一个子集 s : 
//
// 
// 子集 s 的大小 小于或等于 numWanted 。 
// s 中 最多 有相同标签的 useLimit 项。 
// 
//
// 一个子集的 分数 是该子集的值之和。 
//
// 返回子集 s 的最大 分数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：values = [5,4,3,2,1], labels = [1,1,2,2,3], numWanted = 3, useLimit = 1
//输出：9
//解释：选出的子集是第一项，第三项和第五项。
// 
//
// 示例 2： 
//
// 
//输入：values = [5,4,3,2,1], labels = [1,3,3,3,2], numWanted = 3, useLimit = 2
//输出：12
//解释：选出的子集是第一项，第二项和第三项。
// 
//
// 示例 3： 
//
// 
//输入：values = [9,8,8,7,6], labels = [0,0,0,1,1], numWanted = 3, useLimit = 1
//输出：16
//解释：选出的子集是第一项和第四项。
// 
//
// 
//
// 提示： 
//
// 
// n == values.length == labels.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= values[i], labels[i] <= 2 * 10⁴ 
// 1 <= numWanted, useLimit <= n 
// 
//
// Related Topics 贪心 数组 哈希表 计数 排序 👍 48 👎 0

package leetcode.editor.cn.java;

import java.util.Arrays;
import java.util.HashMap;

//Java:受标签影响的最大值
//Time:2023-05-23 10:22:23
class P1090_LargestValuesFromLabels {
    public static void main(String[] args) {
        Solution solution = new P1090_LargestValuesFromLabels().new Solution();
        System.out.println(solution.largestValsFromLabels(new int[]{5, 4, 3, 2, 1}, new int[]{1, 1, 2, 2, 3}, 3, 1));
        System.out.println(solution.largestValsFromLabels(new int[]{5, 4, 3, 2, 1}, new int[]{1, 3, 3, 3, 2}, 3, 2));
        System.out.println(solution.largestValsFromLabels(new int[]{2, 6, 1, 2, 6}, new int[]{2, 2, 2, 1, 1}, 1, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
            int N = values.length;
            int[][] nums = new int[N][2];
            for (int i = 0; i < N; i++) {
                nums[i][0] = values[i];
                nums[i][1] = labels[i];
            }
            Arrays.sort(nums, ((o1, o2) -> {
                if (o1[0] != o2[0]) {
                    return o2[0] - o1[0];
                }
                return o1[1] - o2[1];
            }));
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            int sum = 0;
            int count = 0;
            for (int[] num : nums) {
                int t = hashMap.getOrDefault(num[1], 0);
                if (t < useLimit) {
                    sum += num[0];
                    hashMap.put(num[1], t + 1);
                    count++;
                    if (count == numWanted) {
                        break;
                    }
                }
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
