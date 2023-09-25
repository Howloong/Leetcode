#include <bits/stdc++.h>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class LockingTree {
public:

    LockingTree(vector<int> &parent) {
        int n = parent.size();
        this->parent = parent;
        this->children = vector<vector<int>>(n);
        this->lockedNode = vector<int>(n, -1);
        for (int i = 0; i < n; ++i) {
            int p = parent[i];
            if (p != -1) {
                children[p].push_back(i);
            }
        }
    }

    bool lock(int num, int user) {
        if (lockedNode[num] == -1) {
            lockedNode[num] = user;
            return true;
        }
        return false;
    }

    bool unlock(int num, int user) {
        if (lockedNode[num] != user) {
            return false;
        }
        lockedNode[num] = -1;
        return true;
    }

    bool upgrade(int num, int user) {
        auto b= lockedNode[num] == -1
               && checkParent(num)
               && checkChildren(num);
        if (b) {
            lockedNode[num] = user;
        }
        return b;
    }

    bool checkParent(int num) {
        while (parent[num] != -1) {
            int t = parent[num];
            if (lockedNode[t] != -1) {
                return false;
            }
            num = t;
        }
        return true;
    }

    bool checkChildren(int num) {
        bool b = lockedNode[num] != -1;
        lockedNode[num] = -1;
        for (auto node: children[num]) {
            b |= checkChildren(node);
        }
        return b;
    }

private:
    vector<int> parent;
    vector<vector<int>> children;
    vector<int> lockedNode;
};

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree* obj = new LockingTree(parent);
 * bool param_1 = obj->lock(num,user);
 * bool param_2 = obj->unlock(num,user);
 * bool param_3 = obj->upgrade(num,user);
 */
//leetcode submit region end(Prohibit modification and deletion)


int main() {
}