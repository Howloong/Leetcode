#include <bits/stdc++.h>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    int minCapability(vector<int> &nums, int k) {
        int min = *min_element(nums.begin(), nums.end());
        int max = *max_element(nums.begin(), nums.end());
        while (min < max) {
            int mid = min + (max - min) / 2;
            if (check(nums, mid) < k) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }

    int check(vector<int> &nums, int target) {
        bool isVisited = false;
        int res = 0;
        for (auto num: nums) {
            if (num <= target && !isVisited) {
                res++;
                isVisited = true;
            } else {
                isVisited = false;
            }
        }
        return res;
    }
};

//leetcode submit region end(Prohibit modification and deletion)
int main() {
    Solution solution;
    vector<int> v{1, 2, 3};
    cout << solution.minCapability(*new vector{2, 3, 5, 9}, 2);
}
