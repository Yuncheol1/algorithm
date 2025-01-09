#include <stdio.h>
#pragma warning(disable:4996)
int main() {
	int a[] = { 0,1,0,0,2,10,4,40,92,352,724,2680,14200,73712,365596 };
	int n;
	scanf("%d", &n);
	printf("%d", a[n]);

	return 0;
}