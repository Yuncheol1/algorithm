#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <map>
#include <stack>
using namespace std;
int main() {
	cin.tie(0);
	ios_base::sync_with_stdio(0);
	string str;
	stack<char> st;
	cin >> str;
	int cnt = 0;
	for (int i = 0; i < str.size(); i++) {
		if (str[i] == '(')st.push(str[i]);
		else {
			if (str[i - 1] == '(') {
				st.pop();
				cnt += st.size();
			}
			else {
				st.pop();
				cnt++;
			}
		}
	}
	cout << cnt;

	return 0;
}