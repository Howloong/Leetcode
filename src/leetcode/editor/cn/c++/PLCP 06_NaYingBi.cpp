#include <bits/stdc++.h>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    int minCount(vector<int> &coins) {
        int res = 0;
        for (auto coin: coins) {
            res += (coin + 1) / 2;
        }
        return res;
    }
};
//leetcode submit region end(Prohibit modification and deletion)


int main() {
    Solution solution;

}