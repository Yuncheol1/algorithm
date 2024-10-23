#include <stdio.h>  // 카드
#include <stdlib.h>

int compare(void* first, void* second)
{
	long long int* a = (long long int*)first;
	long long int* b = (long long int*)second;
	if (*a > *b)
		return 1;
	else if (*a < *b)
		return -1;
	else
		return 0;
}


int main()
{
	int n;
	scanf("%d", &n);

	long long int arr[100000];
	for (int i = 0; i < n; i++)
	{
		scanf("%lld", &arr[i]);
	}

	qsort(arr, n, sizeof(arr[0]), compare);

	long long int ans = 0;
	int cnt = 1;
	int max_cnt = 0;
	for (int i = 0; i < n - 1; i++)
	{
		if (arr[i] == arr[i + 1])
			cnt++;
		else
			cnt = 1;

		if (cnt > max_cnt)
		{
			ans = arr[i];
			max_cnt = cnt;
		}
	}
	if (n == 1)
		ans = arr[0];

	printf("%lld", ans);

	return 0;
}