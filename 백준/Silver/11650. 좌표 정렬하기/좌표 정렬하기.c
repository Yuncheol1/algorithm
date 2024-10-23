#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#pragma warning(disable:4996)
typedef struct {
	int x;
	int y;
}point;
void merge(point [], int, int, int);
void mergesort(point [], int, int);
int main() {
	int n;
	scanf("%d", &n);
	point* p = (point*)malloc(n * sizeof(point));
	for (int i = 0; i < n; i++) {
		scanf("%d %d", &p[i].x, &p[i].y);
	}
	mergesort(p, 0, n - 1);
	for (int i = 0; i < n; i++) {
		printf("%d %d\n", p[i].x, p[i].y);
	}
	return 0;
}
void merge(point a[], int left, int mid, int right) {
	int n1 = mid - left + 1;
	int n2 = right - mid;
	point *L = (point*)malloc(n1 * sizeof(point));
	point *R = (point*)malloc(n2 * sizeof(point));
	for (int i = 0; i < n1; i++) {
		L[i] = a[left+i];
	}
	for (int i = 0; i < n2; i++) {
		R[i] = a[mid+1+i];
	}
	int i = 0, j = 0, k = left;
	while (i < n1 && j < n2) {
		if (L[i].x<R[j].x || (L[i].x==R[j].x&&L[i].y<R[j].y)) {
			a[k] = L[i];
			i++;
		}
		else {
			a[k] = R[j];
			j++;
		}
		k++;
	}
	while (i < n1) {
		a[k++] = L[i++];
	}
	while (j < n2) {
		a[k++] = R[j++];
	}
	free(L);
	free(R);
}
void mergesort(point a[], int left, int right) {
	if (left < right) {
		int mid = left + (right - left) / 2;
		mergesort(a, left, mid);
		mergesort(a, mid+1, right);
		merge(a, left, mid, right);

	}
}
