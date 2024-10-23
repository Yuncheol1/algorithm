#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include<math.h>
#pragma warning(disable:4996)
int find(int a, int b) {
	return (rand() % (b - a + 1) + a);
}
int partition(int* x, int begin, int end, int k) {
	long long p = x[k];
	long long temp = x[end];
	x[end] = x[k];
	x[k] = temp;
	int L = begin;
	int R = end - 1;
	while (L <= R) {
		while (L <= R && x[L] >= p)L++;
		while (L <= R && x[R] <= p)R--;
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
	long long n,n1;
	scanf("%lld", &n);
	n1 = n;
	int idx = 0;
	while (n1 > 0) {
		n1 /= 10;
		idx++;
	}
	int* x = (int*)malloc(idx * sizeof(int));
	for (int i = 0; i < idx; i++) {
		x[i] = (int)n % 10;
		n /= 10;
	}
	inPlaceQuickSort(x, 0, idx - 1);
	for (int i = 0; i < idx; i++)printf("%d", x[i]);

	return 0;
}
