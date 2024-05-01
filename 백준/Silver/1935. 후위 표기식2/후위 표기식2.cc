#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <map>
#include <stack>
using namespace std;
void printstack(stack<double>x) {
    while (!x.empty()) {
        cout << x.top() << " ";
        x.pop();
    }
    cout << "\n";
}
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    stack <double> st;
    int n;
    string str;
    cin >> n;
    cin >> str;
    vector <double> x(n);
    for (int i = 0; i < n; i++) {
        cin >> x[i];
    }
    int idx = 0;
    double tmp1, tmp2;
    for (int i = 0; i < str.size(); i++) {
        if (str[i] >= 'A' && str[i] <= 'Z') {
            st.push(x[str[i]-'A']);
        }
        else if(str[i]=='*') {
            tmp1 = st.top();
            st.pop();
            tmp2 = st.top();
            st.pop();
            st.push(tmp1 * tmp2);
        }
        else if (str[i] == '/') {
            tmp1 = st.top();
            st.pop();
            tmp2 = st.top();
            st.pop();
            st.push(tmp2 / tmp1);
       
        }
        else if (str[i] == '+') {
            tmp1 = st.top();
            st.pop();
            tmp2 = st.top();
            st.pop();
            st.push(tmp1 + tmp2);
            
        }
        else if (str[i] == '-') {
            tmp1 = st.top();
            st.pop();
            tmp2 = st.top();
            st.pop();
            st.push(tmp2 - tmp1);
         
        }
    }
    cout << fixed;
    cout . precision(2);
   cout << st.top();
    return 0;
}