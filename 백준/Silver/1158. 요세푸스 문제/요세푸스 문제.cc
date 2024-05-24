#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <map>
#include <stack>
#include <queue>
using namespace std;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int n, k;
    cin >> n >> k;
    queue<int> q;
    for (int i = 1; i <= n; i++)q.push(i);
    cout << '<';
    while (!q.empty()) {
        for (int i = 0; i < k - 1; i++) {
            q.push(q.front());
                q.pop();
        }
        
        cout << q.front();
        q.pop();
        if (!q.empty())cout << ", ";
    }
    cout << '>';
    return 0;
}