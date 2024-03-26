#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <map>
using namespace std;
int main() {
	cin.tie(0);
	ios_base::sync_with_stdio(0);

	vector <pair<int, int>> study;
	int n;
	cin >> n;
	int start, end;
	for (int i = 0; i < n; i++) {
		cin >> start >> end;
		study.push_back(make_pair(start, 1));
		study.push_back(make_pair(end, -1));
	}
	sort(study.begin(), study.end());
	int sum=0;
	int max=0;
	for (int i = 0; i < study.size(); i++) {
		sum += study[i].second;
		if (max < sum) {
			max = sum;
	}
	}
	cout << max;


	return 0;
}