#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <map>
using namespace std;
int x[100001];
int main() {
	cin.tie(0);
	ios_base::sync_with_stdio(0);
	int n, m;
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++) {
		scanf("%d", &x[i]);
		if (i > 0) {
			x[i] += x[i - 1];
		}
	}
	int a, b;
	for (int i = 0; i < m; i++) {
	scanf("%d %d",&a,&b);
	if (a <= 1)
		printf("%d\n", x[b - 1]);

	else
		printf("%d\n", x[b - 1] - x[a - 2]);
		
	}

	return 0;
}