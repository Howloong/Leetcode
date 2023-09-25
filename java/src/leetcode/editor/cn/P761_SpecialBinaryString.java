//特殊的二进制序列是具有以下两个性质的二进制序列： 
//
// 
// 0 的数量与 1 的数量相等。 
// 二进制序列的每一个前缀码中 1 的数量要大于等于 0 的数量。 
// 
//
// 给定一个特殊的二进制序列 S，以字符串形式表示。定义一个操作 为首先选择 S 的两个连续且非空的特殊的子串，然后将它们交换。（两个子串为连续的当且仅当第一
//个子串的最后一个字符恰好为第二个子串的第一个字符的前一个字符。) 
//
// 在任意次数的操作之后，交换后的字符串按照字典序排列的最大的结果是什么？ 
//
// 示例 1: 
//
// 
//输入: S = "11011000"
//输出: "11100100"
//解释:
//将子串 "10" （在S[1]出现） 和 "1100" （在S[3]出现）进行交换。
//这是在进行若干次操作后按字典序排列最大的结果。
// 
//
// 说明: 
//
// 
// S 的长度不超过 50。 
// S 保证为一个满足上述定义的特殊 的二进制序列。 
// 
//
// Related Topics 递归 字符串 👍 184 👎 0

package leetcode.editor.cn.java;

import java.util.ArrayDeque;
import java.util.List;

//Java:特殊的二进制序列
//Time:2022-08-08 22:44:59
class P761_SpecialBinaryString {
    public static void main(String[] args) {
        Solution solution = new P761_SpecialBinaryString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] exclusiveTime(int n, List<String> logs) {
            int[] tasks = new int[n];
            ArrayDeque<String> arrayDeque = new ArrayDeque<>();
            for (String str : logs) {
                String[] s = str.split(":");
                int task = Integer.parseInt(s[0]);
                String status = s[1];
                int timeStamp = Integer.parseInt(s[2]);
                if (status.equals("start")) {
                    arrayDeque.push(str);
                } else {
                    String[] start = arrayDeque.pop().split(":");
                    int startTime = Integer.parseInt(start[2]);
                    int time = (timeStamp - startTime + 1);
                    tasks[task] += time;
                    if (!arrayDeque.isEmpty()) {
                        tasks[Integer.parseInt(arrayDeque.peek().split(":")[0])] -= time;
                    }
                }
            }
            return tasks;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
