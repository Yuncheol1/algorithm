#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <map>
using namespace std;
void swap(int a, int b) {
	int tmp;
	tmp = a;
	a = b;
	b = tmp;
}
int main() {
	cin.tie(0);
	ios_base::sync_with_stdio(0);
	int n;
	cin >> n;
	int a;
	vector<int> x;
	for (int i = 0; i < n; i++) {
		cin >> a;
		x.push_back(a);
	}
	int idx;
	int sum = 0;
	int sum2 = 0;
	if (x[0] % 2 == 0)idx = 0;
	else idx = 1;
		for (int i = 1; i < n; i++) {
			if (x[i] % 2 != 0) {
				sum += (i - idx);
				idx++;
			}

		}
		if (x[0] % 2 == 0)idx = 1;
		else idx = 0;
		for (int i = 1; i < n; i++) {
			if (x[i] % 2 == 0) {
				sum2 += (i - idx);
				idx++;
			}
		}
		if (sum > sum2)cout << sum2;
		else cout << sum;

	return 0;
}