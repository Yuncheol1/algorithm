#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <map>
using namespace std;

long long koongfibo(int n) {
	vector<long long>dp(68);
	dp[0] = 1;
	dp[1] = 1;
	dp[2] = 2;
	dp[3] = 4;
	for (int i = 4; i <= n; i++) {
		dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3] + dp[i - 4];
	}
	return dp[n];
}
int main() {
	cin.tie(0);
	ios_base::sync_with_stdio(0);
	int t,n;
	cin >> t;
	for (int i = 0; i < t; i++) {
		cin >> n;
		cout << koongfibo(n) << endl;
	}

	
	return 0;
}