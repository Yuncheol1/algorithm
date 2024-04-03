#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <map>
using namespace std;
int main() {
	cin.tie(0);
	ios_base::sync_with_stdio(0);
	int n;
	cin >> n;
	vector<int> x(n),dp(n);
	for (int i = 0; i < n; i++)cin >> x[i];
	dp[0] = x[0];
	dp[1] = x[0] + x[1];
	dp[2] = max(x[0] + x[2], x[1] + x[2]);
	for (int i = 3; i < n; i++) {
		dp[i] = max(dp[i - 2] + x[i], dp[i - 3] + x[i - 1] + x[i]);
	}
	cout << dp[n - 1];
	return 0;
}