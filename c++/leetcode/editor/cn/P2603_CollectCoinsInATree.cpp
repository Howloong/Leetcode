// #include <bits/stdc++.h>
#include <iostream>
#include <queue>
#include <vector>

using namespace std;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    int collectTheCoins(vector<int> &coins, vector<vector<int>> &edges) {
        int count = coins.size();
        vector<vector<int>> g(count);
        vector<int> degree(count);
        for (const auto &edge: edges) {
            int x = edge[0];
            int y = edge[1];
            g[x].push_back(y);
            g[y].push_back(x);
            ++degree[x];
            ++degree[y];
        }
        int rest = count;
        queue<int> q;
        for (int i = 0; i < count; ++i) {
            if (degree[i] == 1 && !coins[i]) {
                q.push(i);
            }
        }
        while (!q.empty()) {
            int pop = q.front();
            q.pop();
            --degree[pop];
            --rest;
            for (auto node: g[pop]) {
                --degree[node];
                if (degree[node] == 1 && !coins[node]) {
                    q.push(node);
                }
            }
        }
        for (int i = 0; i < 2; ++i) {
            queue<int> q;
            for (int j = 0; j < count; ++j) {
                if (degree[j] == 1) {
                    q.push(j);
                }
            }
            while (!q.empty()) {
                int p = q.front();
                q.pop();
                --degree[p];
                --rest;
                for (auto node: g[p]) {
                    --degree[node];
                }
            }
        }
        return rest == 0 ? 0 : (rest - 1) << 1;
    }
};
// leetcode submit region end(Prohibit modification and deletion)

int main() { Solution solution; }