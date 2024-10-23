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
	scanf("%d", &n);
	int* x = (int*)malloc(n * sizeof(int));
	int* y = (int*)malloc(n * sizeof(int));
	for (int i = 0; i < n; i++)scanf("%d", &x[i]);
	for (int i = 0; i < n; i++)scanf("%d", &y[i]);
	inPlaceQuickSort(x, 0, n - 1);
	inPlaceQuickSort(y, 0, n - 1);
	int sum = 0;
	for (int i = 0; i < n; i++) {
		sum += x[i] * y[n - 1 - i];
	}
	printf("%d", sum);


	return 0;
}
