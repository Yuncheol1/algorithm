#include <iostream>
#include <map>
#include <stack>
#include <queue>
using namespace std;

int main() {
    cin.tie(0);
    ios_base::sync_with_stdio(0);

    priority_queue<int> pq;
    vector<int>v;
    int n, m, k;
    int num;
    cin >> n >> m >> k;
    for (int i = 0; i < n; i++) {
        cin >> num;
        pq.push(num);
    }
    int top;
    int stfy = 0;
    int cnt = 0;
    while (pq.top() > k) {
        top = pq.top();
        pq.pop();
        stfy = stfy / 2 + top;
        v.push_back(stfy);
        top -= m;
        pq.push(top);
        cnt++;
    }
    cout << cnt << '\n';
    for (int i = 0; i < v.size(); i++)cout << v[i] << '\n';

    return 0;
}
