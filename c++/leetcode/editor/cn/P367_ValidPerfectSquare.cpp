#include <bits/stdc++.h>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    bool isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        int left = 0;
        int right = (num >> 1);
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int t = num / mid;
            if (mid <t) {
                left = mid + 1;
            } else if (mid > t) {
                right = mid - 1;
            } else {
                if (num % t == 0) {
                    return true;
                }
                left = mid + 1;
            }
        }
        return false;
    }
};

//leetcode submit region end(Prohibit modification and deletion)


int main() {
    Solution solution;
//    cout << solution.isPerfectSquare(16) << endl;
//    cout << solution.isPerfectSquare(5) << endl;
    cout << solution.isPerfectSquare(5) << endl;

}