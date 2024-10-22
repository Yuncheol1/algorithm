#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include<math.h>
#pragma warning(disable:4996)
int find(int a, int b) {
	return (rand() % (b - a + 1) + a);
}
int partition(int* x, int begin, int end, int k) {
	int p = x[k];
	int temp = x[end];
	x[end] = x[k];
	x[k] = temp;
	int L = begin;
	int R = end - 1;
	while (L <= R) {
		while (L <= R && x[L] <= p)L++;
		while (L <= R && x[R] >= p)R--;
		if (L < R) {
			temp = x[L];
			x[L] = x[R];
			x[R] = temp;
		}
	}
	temp = x[L];
	x[L] = x[end];
	x[end] = temp;
	return L;
}
void inPlaceQuickSort(int* x, int begin, int end) {
	if (begin < end) {
		int p = find(begin, end);
		int pivot = partition(x, begin, end, p);
		inPlaceQuickSort(x, begin, pivot - 1);
		inPlaceQuickSort(x, pivot + 1, end);
	}
}
int main() {
	int n;
	int f;
	scanf("%d", &n);
	scanf("%d", &f);
	if (n == 1) {
		printf("0");
		return 0;
	}
	int* x = (int*)malloc((n - 1) * sizeof(int));
	for (int i = 0; i < n - 1; i++)scanf("%d", &x[i]);
	int cnt = 0;
	while (1) {
		int max = x[0];
		int idx = 0;
		for (int i = 0; i < n - 1; i++) {
			if (max < x[i]) {
				idx = i;
				max = x[i];
			}
		}
		if (f <= x[idx]) {
			f++;
			x[idx]--;
			cnt++;
		}
		else break;

	}
	free(x);
	printf("%d", cnt);
	return 0;
}
