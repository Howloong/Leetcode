#include "bits/stdc++.h"

using namespace std;

int main() {
    int M, K;
    while (cin >> M >> K) {
        if (M == 0 && K == 0) {
            break;
        }
        int a = M / K;
        int b = M % K;
        int res = M;
        while (a + b >= K) {
            res += a;
            a = a + b;
            b = a % K;
            a = a / K;
        }
        cout << res + a << endl;
    }
}

