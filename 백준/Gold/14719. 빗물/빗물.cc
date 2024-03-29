#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <map>
using namespace std;
int main() {
	cin.tie(0);
	ios_base::sync_with_stdio(0);
	int n, m;
	cin >> n>> m;
	vector<int> x(m);
	for (int i = 0; i < m; i++) {
		cin >> x[i];
	}
	int max=0,max1=0, max2,res=0;
	for (int i = 1; i < m - 1; i++) {
		max1 = 0, max2 = 0;
		for (int j = 0; j < i; j++) {
			if (max1 < x[j])max1 = x[j];
		}
		for (int j = m - 1; j > i;j--) {
			if (max2 < x[j])max2 = x[j];
		}
		if (max1 < max2)max = max1;
		else max = max2;
		if (max-x[i] < 0)continue;
		res += max - x[i];
	}
	cout << res;

	return 0;
}