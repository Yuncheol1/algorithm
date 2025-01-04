#include <stdio.h>
#pragma warning(disable:4996)
int main() {
	int x[31] = { 0 };
	for (int i = 0; i < 28; i++) {
		int a;
		scanf("%d", &a);
		x[a] = 1;
	}
	for (int i = 1; i <= 30; i++) {
		if (x[i] == 0)printf("%d\n", i);
	}

	return 0;
}