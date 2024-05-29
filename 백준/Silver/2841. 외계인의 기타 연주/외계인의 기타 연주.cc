#include <iostream>
#include <map>
#include <stack>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr); cout.tie(nullptr);

    map<int, stack<int>> vst;
    int n, k;
    cin >> n >> k;

    int a, b;
    int cnt = 0;

    for (int i = 0; i < n; i++) {
        cin >> a >> b;
        if (vst[a].empty()) {
            cnt++;
            vst[a].push(b);
            continue;
        }
        if (vst[a].top() < b) {
            cnt++;
            vst[a].push(b);
            continue;
        }
        while (!vst[a].empty() && vst[a].top() > b) {
            vst[a].pop();
            cnt++;
        }
        if (!vst[a].empty() && vst[a].top() == b) continue;
        cnt++;
        vst[a].push(b);
    }

    cout << cnt;

    return 0;
}
