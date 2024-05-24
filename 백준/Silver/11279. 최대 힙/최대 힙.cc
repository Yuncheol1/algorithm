#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <map>
#include <stack>
#include <queue>
#include <functional>
using namespace std;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);cout.tie(nullptr);
    priority_queue<int, vector<int>, greater<int>> pq2;
    priority_queue<int>pq;
    int n;
    int num;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> num;
        if (num == 0) {
            if (pq.empty())cout << 0 << "\n";
            else {
                cout <<pq.top() << '\n';
                pq.pop();
            }continue;
        }
        pq.push(num);
       
    }



    return 0;
}