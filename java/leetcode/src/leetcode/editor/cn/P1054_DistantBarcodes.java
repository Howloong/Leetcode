//在一个仓库里，有一排条形码，其中第 i 个条形码为 barcodes[i]。 
//
// 请你重新排列这些条形码，使其中任意两个相邻的条形码不能相等。 你可以返回任何满足该要求的答案，此题保证存在答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：barcodes = [1,1,1,2,2,2]
//输出：[2,1,2,1,2,1]
// 
//
// 示例 2： 
//
// 
//输入：barcodes = [1,1,1,1,2,2,3,3]
//输出：[1,3,1,3,2,1,2,1] 
//
// 
//
// 提示： 
//
// 
// 1 <= barcodes.length <= 10000 
// 1 <= barcodes[i] <= 10000 
// 
//
// Related Topics 贪心 数组 哈希表 计数 排序 堆（优先队列） 👍 133 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//Java:距离相等的条形码
//Time:2023-05-14 12:32:00
class P1054_DistantBarcodes {
    public static void main(String[] args) {
        Solution solution = new P1054_DistantBarcodes().new Solution();
        System.out.println(Arrays.toString(solution.rearrangeBarcodes(new int[]{2, 2, 1, 3})));
        System.out.println(Arrays.toString(solution.rearrangeBarcodes(new int[]{1, 1, 1, 2, 2, 2})));
        System.out.println(Arrays.toString(solution.rearrangeBarcodes(new int[]{1, 1, 1, 1, 2, 2, 3, 3})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] rearrangeBarcodes(int[] barcodes) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int barcode : barcodes) {
                hashMap.put(barcode, hashMap.getOrDefault(barcode, 0) + 1);
            }
            int[] res = new int[barcodes.length];
            int index = 0;
            PriorityQueue<int[]> deque = new PriorityQueue<>(((o1, o2) -> o2[1] - o1[1]));
            for (Map.Entry<Integer, Integer> integerIntegerEntry : hashMap.entrySet()) {
                deque.add(new int[]{integerIntegerEntry.getKey(), integerIntegerEntry.getValue()});
            }
            while (index < barcodes.length) {
                int[] t = deque.poll();
                res[index++] = t[0];
                t[1]--;
                int[] t2;
                if (index < barcodes.length) {
                    t2 = deque.poll();
                    res[index++] = t2[0];
                    t2[1]--;
                } else {
                    break;
                }
                if (t[1] != 0)
                    deque.offer(t);
                if (t2[1] != 0) {
                    deque.offer(t2);
                }

            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
