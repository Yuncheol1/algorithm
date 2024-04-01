#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <map>
using namespace std;
void swap(vector<int> &x, int j) {
	for (int i = j; i < j + 3; i++) {
		if (x.size() <= i)return;
		if (x[i] == 0)x[i] = 1;
		else x[i] = 0;
	
	}
}
int main() {
	cin.tie(0);
	ios_base::sync_with_stdio(0);
	int n;
	cin >> n;
	vector<int> x(n);
	for (int i = 0; i < n; i++) {
		cin >> x[i];
	}
	int cnt = 0;
		for (int i = 0; i < x.size(); i++) {
			if (x[i] == 1) {
				swap(x, i);
				cnt++;
				
			}
		}
	cout << cnt;
	return 0;
}