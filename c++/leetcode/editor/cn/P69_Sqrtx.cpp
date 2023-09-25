#include <bits/stdc++.h>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int left = 1;
        int right = x / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int t = x / mid;
            if (mid < t) {
                left = mid + 1;
            } else if (mid > t) {
                right = mid - 1;
            } else {
                return mid;
            }

        }
        return right;
    }
};
//leetcode submit region end(Prohibit modification and deletion)


int main() {
    Solution solution;
    cout << solution.mySqrt(4) << endl;
    cout << solution.mySqrt(8) << endl;

}