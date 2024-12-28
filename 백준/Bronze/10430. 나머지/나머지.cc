#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <map>
#include <queue>
using namespace std;
int main() {
	cin.tie(0);
	ios_base::sync_with_stdio(0);
	int A, B, C;
	cin >> A >> B >> C;
	cout << (A + B) % C << "\n";
	cout << ((A % C) + (B % C)) % C << "\n";
	cout << (A*B) % C << "\n";
	cout << ((A % C) *(B % C)) % C << "\n";
	return 0;
}