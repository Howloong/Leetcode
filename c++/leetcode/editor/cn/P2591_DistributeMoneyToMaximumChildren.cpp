#include <bits/stdc++.h>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    int distMoney(int money, int children) {
        if (money < children) {
            return -1;
        }
        money -= children;
        int cnt = min(money / 7, children);
        money -= 7 * cnt;
        children -= cnt;
        if (children == 0 && money > 0) {
            return cnt - 1;
        }
        if (children == 1) {
            if (money == 3) {
                return cnt - 1;
            }
        }
        return cnt;
    }
};
//leetcode submit region end(Prohibit modification and deletion)


int main() {
    Solution solution;
//    cout << solution.distMoney(20, 3);
    cout << solution.distMoney(16, 2);
}