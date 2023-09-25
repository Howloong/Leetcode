//给定一个由 4 位数字组成的数组，返回可以设置的符合 24 小时制的最大时间。 
//
// 24 小时格式为 "HH:MM" ，其中 HH 在 00 到 23 之间，MM 在 00 到 59 之间。最小的 24 小时制时间是 00:00 ，而最大
//的是 23:59 。从 00:00 （午夜）开始算起，过得越久，时间越大。 
//
// 以长度为 5 的字符串，按 "HH:MM" 格式返回答案。如果不能确定有效时间，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,2,3,4]
//输出："23:41"
//解释：有效的 24 小时制时间是 "12:34"，"12:43"，"13:24"，"13:42"，"14:23"，"14:32"，"21:34"，"21:4
//3"，"23:14" 和 "23:41" 。这些时间中，"23:41" 是最大时间。
// 
//
// 示例 2： 
//
// 
//输入：arr = [5,5,5,5]
//输出：""
//解释：不存在有效的 24 小时制时间，因为 "55:55" 无效。
// 
//
// 示例 3： 
//
// 
//输入：arr = [0,0,0,0]
//输出："00:00"
// 
//
// 示例 4： 
//
// 
//输入：arr = [0,0,1,0]
//输出："10:00"
// 
//
// 
//
// 提示： 
//
// 
// arr.length == 4 
// 0 <= arr[i] <= 9 
// 
//
// Related Topics 字符串 枚举 👍 87 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java:给定数字能组成的最大时间
//Time:2023-06-06 15:28:47
class P949_LargestTimeForGivenDigits {
    public static void main(String[] args) {
        Solution solution = new P949_LargestTimeForGivenDigits().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestTimeFromDigits(int[] arr) {
            Arrays.sort(arr);
            if (arr[0] > 2) {
                return "";
            }
            int len = arr.length;
            int hourMax = -1;
            int minMax = -1;
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    int k = 0;
                    while (k < len && (k == i || k == j)) {
                        k++;
                    }
                    int l = 6 - i - j - k;
                    int[] nums = new int[4];
                    nums[0] = arr[i] * 10 + arr[j];
                    nums[1] = arr[j] * 10 + arr[i];
                    nums[2] = arr[k] * 10 + arr[l];
                    nums[3] = arr[l] * 10 + arr[k];
                    for (int m = 0; m < 2; m++) {
                        for (int n = 2; n < 4; n++) {
                            if (nums[m] < 24 && nums[n] < 60) {
                                int[] temp = cmpTime(new int[]{hourMax, minMax},
                                        new int[]{nums[m], nums[n]});
                                hourMax = temp[0];
                                minMax = temp[1];
                            }
                        }
                    }
                }
            }
            if (hourMax == -1) {
                return "";
            }
            return String.format("%02d:%02d", hourMax, minMax);
        }

        public int[] cmpTime(int[] hour1, int[] hour2) {
            if (hour1[0] < hour2[0]) {
                return hour2;
            }
            if (hour1[0] > hour2[0]) {
                return hour1;
            }
            return hour1[1] > hour2[1] ? hour1 : hour2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
