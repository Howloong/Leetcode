//Alice 在给 Bob 用手机打字。数字到字母的 对应 如下图所示。 
//
// 
//
// 为了 打出 一个字母，Alice 需要 按 对应字母 i 次，i 是该字母在这个按键上所处的位置。 
//
// 
// 比方说，为了按出字母 's' ，Alice 需要按 '7' 四次。类似的， Alice 需要按 '5' 两次得到字母 'k' 。 
// 注意，数字 '0' 和 '1' 不映射到任何字母，所以 Alice 不 使用它们。 
// 
//
// 但是，由于传输的错误，Bob 没有收到 Alice 打字的字母信息，反而收到了 按键的字符串信息 。 
//
// 
// 比方说，Alice 发出的信息为 "bob" ，Bob 将收到字符串 "2266622" 。 
// 
//
// 给你一个字符串 pressedKeys ，表示 Bob 收到的字符串，请你返回 Alice 总共可能发出多少种文字信息 。 
//
// 由于答案可能很大，将它对 10⁹ + 7 取余 后返回。 
//
// 
//
// 示例 1： 
//
// 输入：pressedKeys = "22233"
//输出：8
//解释：
//Alice 可能发出的文字信息包括：
//"aaadd", "abdd", "badd", "cdd", "aaae", "abe", "bae" 和 "ce" 。
//由于总共有 8 种可能的信息，所以我们返回 8 。
// 
//
// 示例 2： 
//
// 输入：pressedKeys = "222222222222222222222222222222222222"
//输出：82876089
//解释：
//总共有 2082876103 种 Alice 可能发出的文字信息。
//由于我们需要将答案对 10⁹ + 7 取余，所以我们返回 2082876103 % (10⁹ + 7) = 82876089 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= pressedKeys.length <= 10⁵ 
// pressedKeys 只包含数字 '2' 到 '9' 。 
// 
//
// Related Topics 哈希表 数学 字符串 动态规划 👍 36 👎 0

package leetcode.editor.cn.java;

import java.util.HashMap;

//Java:统计打字方案数
//Time:2023-03-16 14:38:40
class P2266_CountNumberOfTexts {
    public static void main(String[] args) {
        Solution solution = new P2266_CountNumberOfTexts().new Solution();
//        System.out.println(solution.countTexts("22"));
        System.out.println(solution.countTexts("6666666666666666666666666666666666666666666666666666666666"));
        System.out.println(solution.countTexts("88888888888888888888888888888999999999999999999999999999994444444444444444444444444444488888888888888888888888888888555555555555555555555555555556666666666666666666666666666666666666666666666666666666666222222222222222222222222222226666666666666666666666666666699999999999999999999999999999888888888888888888888888888885555555555555555555555555555577777777777777777777777777777444444444444444444444444444444444444444444444444444444444433333333333333333333333333333555555555555555555555555555556666666666666666666666666666644444444444444444444444444444999999999999999999999999999996666666666666666666666666666655555555555555555555555555555444444444444444444444444444448888888888888888888888888888855555555555555555555555555555555555555555555555555555555555555555555555555555555555999999999999999555555555555555555555555555554444444444444444444444444444444555"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        HashMap<Integer, Long> map1;
        HashMap<Integer, Long> map2;
        int top1 = 4;
        int top2 = 5;
        int MOD = (int) 1e9 + 7;

        public int countTexts(String pressedKeys) {
            map1 = new HashMap<>();
            map2 = new HashMap<>();
            map1.put(1, 1L);
            map1.put(2, 2L);
            map1.put(3, 4L);
            map2.put(1, 1L);
            map2.put(2, 2L);
            map2.put(3, 4L);
            map2.put(4, 8L);
            long cnt = 1;
            int last = 0;
            char cLast = pressedKeys.charAt(last);
            int n = pressedKeys.length();
            for (int i = 1; i < n; i++) {
                char pressed = pressedKeys.charAt(i);
                if (pressed != cLast) {
                    cnt = (cnt * getNum(i - last, cLast == '7' || cLast == '9')) % MOD;
                    last = i;
                    cLast = pressedKeys.charAt(i);
//                    System.out.println(cnt);
                }
            }
            cnt = (cnt * getNum(n - last, cLast == '7' || cLast == '9') % MOD);
            return (int) (cnt % MOD);
        }

        public long getNum(int len, boolean isSevenOrNine) {
            long t = 0;
            if (isSevenOrNine) {
                if (map2.containsKey(len)) {
                    return map2.get(len);
                }
                long x1 = map2.get(top2 - 4);
                long x2 = map2.get(top2 - 3);
                long x3 = map2.get(top2 - 2);
                long x4 = map2.get(top2 - 1);
                for (int i = top2; i <= len; i++) {
                    t = (x1 + x2 + x3 + x4) % MOD;
                    map2.put(i, t);
                    x1 = x2;
                    x2 = x3;
                    x3 = x4;
                    x4 = t;
                }
            } else {
                if (map1.containsKey(len)) {
                    return map1.get(len);
                }
                long x1 = map1.get(top1 - 3);
                long x2 = map1.get(top1 - 2);
                long x3 = map1.get(top1 - 1);
                for (int i = top1; i <= len; i++) {
                    t = (x1 + x2 + x3) % MOD;
                    map1.put(i, t);
                    x1 = x2;
                    x2 = x3;
                    x3 = t;
                }
            }
            return t % MOD;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
