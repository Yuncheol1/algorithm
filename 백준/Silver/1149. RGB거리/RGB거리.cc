#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <map>
#include <tuple>
using namespace std;
int main() {
	cin.tie(0);
	ios_base::sync_with_stdio(0);
	int n;
	cin >> n;
	int dp[3] = { 0 };
	int r, g, b;
	for (int i = 0; i < n; i++) {
		cin >> r >> g >> b;
		r += min(dp[1], dp[2]);
		g += min(dp[0], dp[2]);
		b += min(dp[0], dp[1]);
		dp[0] = r;
		dp[1] = g;
		dp[2] = b;
	}
	sort(dp, dp + 3);
	cout << dp[0];
	return 0;
}