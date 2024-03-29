#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <map>
using namespace std;
int main() {
	cin.tie(0);
	ios_base::sync_with_stdio(0);
	int n, k;
	cin >> n >> k;
	vector<int> x(n),y;
	int a;
	for (int i = 0; i < n; i++)
		cin >> x[i];
	for (int i = 0; i < n - 1; i++) {
		y.push_back(x[i + 1] - x[i]);
	}
	int sum = 0;
	sort(y.begin(), y.end(), greater<>());
	for (int i = k - 1; i < y.size(); i++)
		sum += y[i];
	cout << sum;


	return 0;
}