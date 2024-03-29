#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <map>
using namespace std;
int main() {
	cin.tie(0);
	ios_base::sync_with_stdio(0);
	int n;
	long long sum = 0;
	cin >> n;
	vector<pair<long long, long long>> x(n);
	for (int i = 0; i < n; i++)
		cin >> x[i].second;//나무의 처음길이

	for (int i = 0; i < n; i++)
		cin >> x[i].first;//나무의 하루 자라는 길이

	sort(x.begin(), x.end());
	for (int i = 0; i < n; i++) {
		sum += x[i].second + i * x[i].first;
	}
	cout << sum;

	return 0;
}