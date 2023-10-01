//作为项目经理，你规划了一份需求的技能清单 req_skills，并打算从备选人员名单 people 中选出些人组成一个「必要团队」（ 编号为 i 的备选人员
// people[i] 含有一份该备选人员掌握的技能列表）。 
//
// 所谓「必要团队」，就是在这个团队中，对于所需求的技能列表 req_skills 中列出的每项技能，团队中至少有一名成员已经掌握。可以用每个人的编号来表示团
//队中的成员： 
//
// 
// 例如，团队 team = [0, 1, 3] 表示掌握技能分别为 people[0]，people[1]，和 people[3] 的备选人员。 
// 
//
// 请你返回 任一 规模最小的必要团队，团队成员用人员编号表示。你可以按 任意顺序 返回答案，题目数据保证答案存在。 
//
// 
//
// 示例 1： 
//
// 
//输入：req_skills = ["java","nodejs","reactjs"], people = [["java"],["nodejs"],[
//"nodejs","reactjs"]]
//输出：[0,2]
// 
//
// 示例 2： 
//
// 
//输入：req_skills = ["algorithms","math","java","reactjs","csharp","aws"], people 
//= [["algorithms","math","java"],["algorithms","math","reactjs"],["java",
//"csharp","aws"],["reactjs","csharp"],["csharp","math"],["aws","java"]]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= req_skills.length <= 16 
// 1 <= req_skills[i].length <= 16 
// req_skills[i] 由小写英文字母组成 
// req_skills 中的所有字符串 互不相同 
// 1 <= people.length <= 60 
// 0 <= people[i].length <= 16 
// 1 <= people[i][j].length <= 16 
// people[i][j] 由小写英文字母组成 
// people[i] 中的所有字符串 互不相同 
// people[i] 中的每个技能是 req_skills 中的技能 
// 题目数据保证「必要团队」一定存在 
// 
//
// Related Topics 位运算 数组 动态规划 状态压缩 👍 120 👎 0

package leetcode.editor.cn;

import java.util.*;

//Java:最小的必要团队
//Time:2023-04-08 11:26:07
class P1125_SmallestSufficientTeam {
    public static void main(String[] args) {
        Solution solution = new P1125_SmallestSufficientTeam().new Solution();
        System.out.println(Arrays.toString(solution.smallestSufficientTeam(
                new String[]{"mmcmnwacnhhdd", "vza", "mrxyc"},
                new ArrayList<>() {{
                    add(new ArrayList<>() {{
                        add("mmcmnwacnhhdd");
                    }});
                    add(new ArrayList<>());
                    add(new ArrayList<>());
                    add(new ArrayList<>() {{
                        add("vza");
                        add("mrxyc");
                    }});

                }})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
            Map<String, Integer> map = new HashMap<>();
            int n = req_skills.length;
            int m = people.size();
            for (int i = 0; i < n; i++) {
                map.put(req_skills[i], 1 << i);
            }
//            int[] mask = new int[m];
            int all = (1 << n) - 1;

            long[] dp = new long[all + 1];
            Arrays.fill(dp, (1L << m) - 1);
            dp[0] = 0;
            for (int i = 0; i < m; i++) {
                int mask = 0;
                for (String s : people.get(i)) {
                    mask += map.get(s);
                }
                for (int j = 1; j < all + 1; j++) {
                    long res = dp[j];
                    long res2 = dp[j & ~mask] | (1L << i);
                    dp[j] = Long.bitCount(res) < Long.bitCount(res2) ? res : res2;
                }
            }
            long res = dp[all];
            int[] ans = new int[Long.bitCount(res)];
            for (int i = 0, j = 0; i < m; i++) {
                if (((res >> i) & 1) > 0) {
                    ans[j++] = i;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
