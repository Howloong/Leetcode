#include <bits/stdc++.h>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    int maxProfit(vector<int> &prices) {
        int dp[2];
        dp[0] = -prices[0];
        dp[1] = 0;
        for (int i = 1; i < prices.size(); ++i) {
            dp[0] = max(dp[0], dp[1] - prices[i]);
            dp[1] = max(dp[1], dp[0] + prices[i]);
        }
        return dp[1];
    }
};
//leetcode submit region end(Prohibit modification and deletion)

int main() {
    Solution solution;
    vector<int> v = {7, 1, 5, 3, 6, 4};
    cout << solution.maxProfit(v) << endl;
}