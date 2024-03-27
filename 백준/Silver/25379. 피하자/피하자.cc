#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <map>
using namespace std;
int main() {
	cin.tie(0);
	ios_base::sync_with_stdio(0);
	long long n,a,idx1,idx2,sum=0,sum2=0;
	cin >> n;
	vector<int> x;
	for (int i = 0; i < n; i++) {
		cin >> a;
		x.push_back(a);
	}
	if (x[0] % 2 == 0) {
		idx1 = 0;
		idx2 = 1;
	}
	else {
		idx1 = 1;
		idx2 = 0;
	}
	for (int i = 1; i < n; i++) {
			if (x[i] % 2 != 0) {
				sum += (i - idx1);
				idx1++;
			}
			else {
				sum2 += (i - idx2);
				idx2++;
			}

		}
	cout << min(sum, sum2);
	return 0;
}