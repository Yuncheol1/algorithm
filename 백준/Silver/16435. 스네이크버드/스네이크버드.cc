#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <map>
#include <queue>
using namespace std;
int main(){
	int n, h;
	cin >> n >> h;
	vector<int> fruit(n);
	for (int i = 0; i < n; i++)cin >> fruit[i];
	sort(fruit.begin(), fruit.end());
	for (int i = 0; i < n; i++) {
		if (h >= fruit[i])h++;
	}
	cout << h;
	return 0;
}