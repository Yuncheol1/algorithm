#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#pragma warning(disable:4996)
int main() {
	int n, k;
	scanf("%d %d", &n, &k);

	int sum = 1;
	for (int i = 0; i < k; i++) {
		sum *= n;
		n--;
}
	int a = 1;
	for (int i = k; i > 0; i--)a *= i;
	printf("%d", sum / a);
	return 0;
}
