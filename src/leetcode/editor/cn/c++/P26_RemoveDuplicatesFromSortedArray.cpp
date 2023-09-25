#include <bits/stdc++.h>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    int removeDuplicates(vector<int> &nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.size(); ++fast) {
            if (nums[fast] == nums[slow]) {
                continue;
            }
            slow++;
            nums[slow] = nums[fast];
        }
        return slow+1;
    }
};
//leetcode submit region end(Prohibit modification and deletion)


int main() {
    Solution solution;
    cout << solution.removeDuplicates(*new vector{1, 1, 2});
    cout << solution.removeDuplicates(*new vector{0,0,1,1,1,2,2,3,3,4});
}