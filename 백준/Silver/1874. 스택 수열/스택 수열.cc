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
	int n,a;
	cin >> n;
	vector<int> x(n),x2(n);
	vector<char>cnt;
	stack<int> st;
	for (int i = 0; i < n; i++) {
		cin >> x[i];
		x2[i] = x[i];
	}
	sort(x2.begin(), x2.end());
	int idx = 0;
	for (int i = 0; i < x2.size(); i++) {
		if (!st.empty() && st.top() == x[idx]) {
			while (!st.empty() && st.top() == x[idx]) {
				st.pop();
				cnt.push_back('-');
				idx++;
			}
		}
		st.push(x2[i]);
		cnt.push_back('+');
		if (!st.empty() && st.top() == x[idx]) {
			while (!st.empty()&&st.top() == x[idx]) {
				st.pop();
				cnt.push_back('-');
				idx++;
			}
		}
	}
	while (!st.empty()) {
		if (!st.empty() && st.top() == x[idx]) {
			st.pop();
			cnt.push_back('-');
			idx++;
		}
		if(!st.empty()&&st.top()!=x[idx]) break;
	}
	if (st.empty()) {
		for (int i = 0; i < cnt.size(); i++)
			cout << cnt[i] << "\n";
	}
	else cout << "NO";
	return 0;
}