#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#pragma warning(disable:4996)
int main() {
	int top = 0;
	int n;
	scanf("%d", &n);
	int check = n;
	int* x = (int*)malloc((n*3) * sizeof(int));
	for (int i = 0; i < n; i++) {
		x[i] = i + 1;
	}
	while (top!=check-1) {
		x[top++] = 0;
		x[check++] = x[top];
		x[top++] = 0;

	}
	printf("%d", x[top]);



	return 0;
}