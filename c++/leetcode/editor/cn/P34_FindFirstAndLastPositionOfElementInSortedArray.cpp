#include <bits/stdc++.h>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    vector<int> searchRange(vector<int> &nums, int target) {
        if (nums.empty()) {
            return {-1, -1};
        }
        if (nums[0] > target || *(nums.end() - 1) < target) {
            return {-1, -1};
        }
        int left = 0;
        int right = nums.size();
        int l = -2;
        int r = -2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {

            }
        }
        left = 0;
        right = nums.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
                r = left;
            } else {
                right = mid;
            }
        }
        if (r - l >= 1) {
            return {l, r - 1};
        }
        return {-1, -1};
    }
};
//leetcode submit region end(Prohibit modification and deletion)


int main() {
    Solution solution;
    vector v{5, 7, 7, 8, 8, 10};
//    vector v{1};
    solution.searchRange(v, 8);
}