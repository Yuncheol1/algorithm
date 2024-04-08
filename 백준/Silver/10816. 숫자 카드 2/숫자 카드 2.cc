#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <map>
using namespace std;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	int n;
	cin >> n;
	vector<int> x(n);
	for (int i = 0; i < n; i++)
		cin >> x[i];
	
	sort(x.begin(), x.end());
	int m,a;
	int cnt;
	cin >> m;
	for (int i = 0; i < m; i++) {
		cin >> a;
		cout << upper_bound(x.begin(), x.end(), a) - lower_bound(x.begin(), x.end(), a);
		cout << "\n";
	}



	return 0;
}