#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <map>
#include <stack>
#include <queue>
using namespace std;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int n;
    cin >> n;
    queue <int> q;
    int tmp;
    for (int i = 1; i <= n; i++)
        q.push(i);
    while (q.size() > 1) {
        cout << q.front() << " ";
        q.pop();
        tmp = q.front();
        q.pop();
        q.push(tmp);
    }

    cout << q.back();
    return 0;
}