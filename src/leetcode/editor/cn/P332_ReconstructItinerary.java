//给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。 
//
//
// 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。如果存在多种有效的行程，请你按字典排序返回最小的行程组合。 
//
//
// 
// 例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。 
// 
//
// 假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
//输出：["JFK","MUC","LHR","SFO","SJC"]
// 
//
// 示例 2： 
//
// 
//输入：tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL",
//"SFO"]]
//输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
//解释：另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"] ，但是它字典排序更大更靠后。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= tickets.length <= 300 
// tickets[i].length == 2 
// fromi.length == 3 
// toi.length == 3 
// fromi 和 toi 由大写英文字母组成 
// fromi != toi 
// 
// Related Topics 深度优先搜索 图 欧拉回路 👍 595 👎 0

package leetcode.editor.cn;

import java.util.*;

//Java：重新安排行程
class P332_ReconstructItinerary {
    public static void main(String[] args) {
        Solution solution = new P332_ReconstructItinerary().new Solution();
//        System.out.println(solution.findItinerary());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ArrayDeque<String> result = new ArrayDeque<>();
        public Map<String, Map<String, Integer>> map = new HashMap<>();

        public List<String> findItinerary(List<List<String>> tickets) {
            for (List<String> list : tickets
            ) {
                Map<String, Integer> temp;
                if (map.containsKey(list.get(0))) {
                    temp = map.get(list.get(0));
                    temp.put(list.get(1), temp.getOrDefault(list.get(1), 0) + 1);
                } else {
                    temp = new TreeMap<>();
                    temp.put(list.get(1), 1);
                }
                map.put(list.get(0), temp);
            }
            result.addLast("JFK");
            backTracking(tickets.size() + 1);
            return new ArrayList<>(result);
        }

        public boolean backTracking(int length) {
            if (result.size() == length) {
                return true;
            }

            String last = result.getLast();
            if (map.containsKey(last)) {
                for (Map.Entry<String, Integer> mapEntry :
                        map.get(last).entrySet()) {
                    int count = mapEntry.getValue();
                    if (count > 0) {
                        String dest = mapEntry.getKey();
                        result.addLast(dest);
                        mapEntry.setValue(count - 1);
                        if (backTracking(length)) {
                            return true;
                        }
                        result.removeLast();
                        mapEntry.setValue(count);
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
