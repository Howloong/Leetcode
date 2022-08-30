//给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。 
//
// 整数 a 比整数 b 更接近 x 需要满足： 
//
// 
// |a - x| < |b - x| 或者 
// |a - x| == |b - x| 且 a < b 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,2,3,4,5], k = 4, x = 3
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：arr = [1,2,3,4,5], k = 4, x = -1
//输出：[1,2,3,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= arr.length 
// 1 <= arr.length <= 10⁴
// 
// arr 按 升序 排列 
// -10⁴ <= arr[i], x <= 10⁴ 
// 
//
// Related Topics 数组 双指针 二分查找 排序 堆（优先队列） 👍 408 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java:找到 K 个最接近的元素
//Time:2022-08-25 15:59:34
class P658_FindKClosestElements {
    public static void main(String[] args) {
        Solution solution = new P658_FindKClosestElements().new Solution();
        System.out.println(solution.findClosestElements(new int[]{1, 2, 7, 9}, 3, 6));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            List<Integer> list = new ArrayList<>();
            int len = arr.length;
            if (arr[0] >= x) {
                for (int i = 0; i < k; i++) {
                    list.add(arr[i]);
                }
            } else if (arr[len - 1] <= x) {
                for (int i = 0; i < k; i++) {
                    list.add(arr[len - k + i]);
                }
            } else {
                int i = 0;
                for (i = 0; i < len - 1; i++) {
                    if (arr[i] <= x && arr[i + 1] > x) {
                        break;
                    }
                }
                int j = i + 1;
                while (k > 0) {
                    if (j == len || i >= 0 && x - arr[i] <= arr[j] - x) {
                        list.add(0, arr[i]);
                        i--;
                    } else  {
                        list.add(arr[j]);
                        j++;
                    }
                    k--;
                }
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
