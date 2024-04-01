#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <map>
using namespace std;
int main() {
	cin.tie(0);
	ios_base::sync_with_stdio(0);
	long long n;
	cin >> n;
	if (n == 1 || n == 3 || n == 4) {
		cout << "SK";
		return 0;
	}
	if (n % 7 == 0 || n % 7 == 2) {
		cout << "CY";
		return 0;
	}
	else {
		cout << "SK";
		return 0;
	}




	return 0;
}