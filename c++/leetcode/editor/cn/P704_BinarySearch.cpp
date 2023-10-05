#include <bits/stdc++.h>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    int search(vector<int> &nums, int target) {
        int left = 0;
        int right = nums.size();
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }
};

//leetcode submit region end(Prohibit modification and deletion)
int main() {
    Solution solution;
    cout << solution.search(*new vector{-1}, 2);
//    cout << solution.search(*new vector{-1, 0, 3, 5, 9, 12}, 9);
}