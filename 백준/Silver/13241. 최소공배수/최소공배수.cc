#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <map>
using namespace std;
int gcd(int a, int b) {
    if (b == 0) 
        return a;
    else
    return gcd(b, a % b);
}
int main() {
    long long a, b;
    cin >> a >> b;
    cout << a*b/gcd(a, b);

	return 0;
}
