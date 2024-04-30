#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <map>
#include <stack>
using namespace std;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    stack <int> st;
    int n, a,num;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> a;
        if (a == 1) {
            cin >> num;
            st.push(num);
        }
        if (a == 2) {
            if (!st.empty()) {
                cout << st.top() << "\n";
                st.pop();
            }
            else cout << -1 << "\n";
        }
        if (a == 3) {
            cout << st.size()<<"\n";
        }
        if (a == 4) {
            if (st.empty())cout << 1<<"\n";
            else cout << 0<<"\n";
        }
        if (a == 5) {
            if (!st.empty())cout << st.top()<<"\n";
            else cout << -1<<"\n";
        }
    }

    return 0;
}