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
	vector<int> dp(n+1);
	dp[1] = 0;
	int tmp1, tmp2, tmp3;
	for (int i = 2; i < n + 1; i++) {
		tmp1 = n, tmp2 = n,tmp3 = n;
		if (i % 3 == 0) {
			tmp1 = dp[i / 3] + 1;
		}
		if (i % 2 == 0) {
			tmp2 = dp[i / 2] + 1;
		}
		tmp3 = dp[i - 1]+1;
		dp[i] = min({ tmp1,tmp2,tmp3 });
	}
	cout << dp[n];
	return 0;
}