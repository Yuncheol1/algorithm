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
    vector<int> x(n),x2;
    for (int i = 0; i < n; i++)x[i] = i + 1;
    int idx = 0,cnt=1;
    while (x.size()>0) {
        if (cnt == k) {
            x2.push_back(x[idx]);
            x.erase(x.begin() + idx);
            cnt = 1;
        }
        else {
            idx++;
            cnt++;
        }
        if(x.size()>0)
        idx %= x.size();
    }
    cout << '<';
    for (int i = 0; i < x2.size(); i++) {
        cout << x2[i];
        if (i != n - 1)cout << ", ";
    }cout << '>';


    return 0;
}