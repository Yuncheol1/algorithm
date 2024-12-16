#include <stdio.h>
#include <stdlib.h>
#pragma warning(disable:4996)
#define max(x, y) (((x) > (y)) ? (x) : (y))

int main() {
	int n, k;
	int v[101];
	int w[101];
	int dp[100001] = { 0 };
	scanf("%d %d", &n, &k);
	
	for (int i = 1; i <= n; i++) {
		scanf("%d %d", &w[i], &v[i]);
	}
	for (int i = 1; i <= n; i++) {
		for (int j = k; j >= 1; j--) {//현재 가방의 무게
			if (j >= w[i]) {
				dp[j] = max(dp[j], dp[j - w[i]] + v[i]);
			}
		}
	}
	printf("%d", dp[k]);

	return 0;
}