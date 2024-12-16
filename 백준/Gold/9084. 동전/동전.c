#include <stdio.h>
#include <stdlib.h>
#pragma warning(disable:4996)

int main() {
	int n, m, t;
	scanf("%d", &t);
	for (int asd = 0; asd < t; asd++) {
		int dp[10001] = { 0 };
		int x[20] = { 0 };
		scanf("%d", &n);
		for (int i = 0; i < n; i++) {
			scanf("%d", &x[i]);
		}
		scanf("%d", &m);

		dp[0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = x[i]; j <= m; j++) {
				dp[j] = dp[j] + dp[j - x[i]];
			}
		}
		printf("%d\n", dp[m]);
	}

	return 0;
}