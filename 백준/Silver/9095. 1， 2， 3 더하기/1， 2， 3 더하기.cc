#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <map>
#include <queue>
using namespace std;

int main(){
	vector<int> dp(11);
	dp[1] = 1;
	dp[2] = 2;
	dp[3] = 4;
	for (int i = 4; i <= 10; i++)
		dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];

	int n,t;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> t;
		cout << dp[t] << "\n";
	}

	return 0;
}