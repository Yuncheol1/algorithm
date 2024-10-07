#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include <time.h>
#pragma warning(disable:4996)
int findpivot(int L, int R) {
	int p = (rand() % (R - L + 1)) + L;
	return p;
}
int inPlacePartition(int x[], int begin, int end, int k) {
	int p = x[k];
	int tmp = x[k];
	x[k] = x[end];
	x[end] = tmp;
	int L = begin;
	int R = end - 1;
	while (L <= R) {
		while (x[L] <= p && L <= R)L++;
		while (x[R] >= p && L <= R)R--;
		if (L < R) {
			tmp = x[L];
			x[L] = x[R];
			x[R] = tmp;
		}
	}
	tmp = x[L];
	x[L] = x[end];
	x[end] = tmp;
	return L;
}
void inPlaceQuickSort(int x[], int begin, int end) {
	if (begin < end) {
		int k = findpivot(begin, end);
		int pivot = inPlacePartition(x, begin, end, k);
		inPlaceQuickSort(x, begin, pivot - 1);
		inPlaceQuickSort(x, pivot + 1, end);
	}
}
int main() {
	int n;
	scanf("%d", &n);
	int* x = (int*)malloc(n * sizeof(int));
	for (int i = 0; i < n; i++)scanf("%d", &x[i]);
	inPlaceQuickSort(x, 0, n - 1);
	for (int i = 0; i < n; i++)printf("%d\n", x[i]);


	return 0;
}