#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <map>
using namespace std;
int main() {
	cin.tie(0);
	ios_base::sync_with_stdio(0);
	vector<long long> x;
	long long a;
	cin >> a;
	int i=0;
	while (a > 0) {
		x.push_back(a % 10);
		a /= 10;
	}
	sort(x.begin(), x.end(), greater<long long>());
	for (long long i : x) {
		cout << i ;
	}
	return 0;
}