//给你两个整数 n 和 start。你的任务是返回任意 (0,1,2,,...,2^n-1) 的排列 p，并且满足： 
//
// 
// p[0] = start 
// p[i] 和 p[i+1] 的二进制表示形式只有一位不同 
// p[0] 和 p[2^n -1] 的二进制表示形式也只有一位不同 
// 
//
// 
//
// 示例 1： 
//
// 输入：n = 2, start = 3
//输出：[3,2,0,1]
//解释：这个排列的二进制表示是 (11,10,00,01)
//     所有的相邻元素都有一位是不同的，另一个有效的排列是 [3,1,0,2]
// 
//
// 示例 2： 
//
// 输出：n = 3, start = 2
//输出：[2,6,7,5,4,0,1,3]
//解释：这个排列的二进制表示是 (010,110,111,101,100,000,001,011)
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 16 
// 0 <= start < 2^n 
// 
//
// Related Topics 位运算 数学 回溯 👍 74 👎 0

package leetcode.editor.cn.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Java:循环码排列
//Time:2023-02-23 10:19:17
class P1238_CircularPermutationInBinaryRepresentation {
    public static void main(String[] args) {
        Solution solution = new P1238_CircularPermutationInBinaryRepresentation().new Solution();
        System.out.println(solution.circularPermutation(2, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> result;
        public Set<Integer> set;

        public List<Integer> circularPermutation(int n, int start) {
            result = new ArrayList<>();
            set = new HashSet<>();
            set.add(start);
            backtracking(start, (1 << n) - 1);
            return result;
        }

        public void backtracking(int index, int n) {
            if (result.size() == n) {
                return;
            }
            for (int i = 0; i < n; i++) {
                if (!set.contains(i) && isDiff(index, i)) {
                    result.add(i);
                    set.add(i);
                    backtracking(i, n);
                    set.remove(i);
//                    result.remove(result.size() - 1);
                }
            }
        }

        public boolean isDiff(int num1, int num2) {
            return Integer.bitCount(num1 ^ num2) == 1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
