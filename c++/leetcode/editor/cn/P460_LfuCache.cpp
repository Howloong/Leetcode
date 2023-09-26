#include <bits/stdc++.h>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class LFUCache {
public:
    LFUCache(int capacity) {
        this->capacity = capacity;
        m = new map<int, int>(capacity);
    }
    
    int get(int key) {
        auto count = m.count(key);
        if (count == 0) {
            return -1;
        }

    }
    
    void put(int key, int value) {

    }

private:
    int capacity;
    map<int, int> m;
};

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache* obj = new LFUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)


int main() {
    LFUCache lfuCache();

}