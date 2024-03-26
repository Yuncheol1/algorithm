#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <map>
using namespace std;

int main() {
	cin.tie(0);
	ios_base::sync_with_stdio(0);
	vector <pair<int, int>> x;
	int n;
	cin >> n;
	int start, end;
	for (int i = 0; i < n; i++) {
		cin >> start >> end;
		x.push_back(make_pair(end, start));
	}
	sort(x.begin(), x.end());
	int cnt = 1;
	int endtime = x[0].first;
	for (int i = 1; i < n; i++) {
		if (endtime <= x[i].second) {
			cnt++;
			endtime = x[i].first;
		}
	}
	cout << cnt;
	return 0;
}