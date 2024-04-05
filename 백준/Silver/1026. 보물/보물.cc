#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <map>
using namespace std;
int sum = 0;
int main() {
	cin.tie(0);
	ios_base::sync_with_stdio(0);
	int n;
	cin >> n;
	vector<int>x(n), y(n);
	for (int i = 0; i < n; i++)cin >> x[i];
	for (int i = 0; i < n; i++)cin >> y[i];

	sort(x.begin(), x.end(), greater<int>());
	sort(y.begin(), y.end());
	int sum = 0;
	for (int i = 0; i < n; i++)sum += x[i] * y[i];
	cout << sum;


	

	
	
	return 0;
}