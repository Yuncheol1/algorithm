#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <map>
using namespace std;
int main() {
	cin.tie(0);
	ios_base::sync_with_stdio(0);
	double n;
	cin >> n;
	vector <double>x;
	double a;
	for (int i = 0; i < n; i++) {
		cin >> a;
		x.push_back(a);
	}
	sort(x.begin(), x.end());
	for (int i = 0; i < n - 1; i++) {
		x[n - 1] += x[i] / 2;
	}
	cout << x[n - 1];
	return 0;
}