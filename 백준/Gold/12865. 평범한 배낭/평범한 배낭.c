#include <stdio.h>
#include <stdlib.h>
#pragma warning(disable:4996)
#define max(x, y) (((x) > (y)) ? (x) : (y))
int dp[101][1000001];
int w[101];
int v[101];
int n, k;
int main() {
	
	scanf("%d %d", &n, &k);
	
	for (int i = 1; i <= n; i++) {
		scanf("%d %d", &w[i], &v[i]);
	}
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= k; j++) {
			if (j - w[i] >= 0) {
				dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
			}
			else {
				dp[i][j] = dp[i - 1][j];
			}
		}
	}
	printf("%d", dp[n][k]);



	return 0;
}