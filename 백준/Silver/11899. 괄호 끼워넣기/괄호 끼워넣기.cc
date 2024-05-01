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
    string str;
    cin >> str;
    stack <char>st;
    int cnt = 0;
    for (int i = 0; i < str.size(); i++) {
        if (str[i] == '(')st.push(str[i]);
        if (str[i] == ')'&&!st.empty()) {
            if (st.top() == '(') {
                st.pop();
                cnt += 2;
            }
        }
    }
    cout << str.size()-cnt ;

    return 0;
}