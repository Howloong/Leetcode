//给你一个字符串 s 表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
//
// 
// 'A'：Absent，缺勤 
// 'L'：Late，迟到 
// 'P'：Present，到场 
// 
//
// 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励： 
//
// 
// 按 总出勤 计，学生缺勤（'A'）严格 少于两天。 
// 学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。 
// 
//
// 如果学生可以获得出勤奖励，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "PPALLP"
//输出：true
//解释：学生缺勤次数少于 2 次，且不存在 3 天或以上的连续迟到记录。
// 
//
// 示例 2： 
//
// 
//输入：s = "PPALLL"
//输出：false
//解释：学生最后三天连续迟到，所以不满足出勤奖励的条件。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s[i] 为 'A'、'L' 或 'P' 
// 
//
// Related Topics 字符串 👍 134 👎 0

package leetcode.editor.cn.java;

//Java:学生出勤记录 I
//Time:2022-08-17 23:24:24
class P551_StudentAttendanceRecordI {
    public static void main(String[] args) {
        Solution solution = new P551_StudentAttendanceRecordI().new Solution();
        System.out.println(solution.checkRecord("LALL"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkRecord(String s) {
            char[] c = s.toCharArray();
            int aCount = 0;
            int lCount = 0;
            for (char value : c) {
                if (value == 'A') {
                    aCount++;
                    lCount = 0;
                    if (aCount >= 2) {
                        return false;
                    }
                } else if (value == 'L') {
                    lCount++;
                    if (lCount >= 3) {
                        return false;
                    }
                } else {
                    lCount = 0;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
