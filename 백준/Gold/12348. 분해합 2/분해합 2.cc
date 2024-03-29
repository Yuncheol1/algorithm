#include <iostream>
#include <string>
using namespace std;
int main() {
    long long n;
    cin >> n;
    char tmp;
    string check = to_string(n);
    long long digit = check.length();
    long long start = (n - digit * 9);
    long long sum;
    if (start < 0)start = 0;
    for (long long i = start; i <= n; i++) {
        sum = i;
        string c = to_string(i);
        for (long long j = 0; j < c.length(); j++) {
            tmp = c[j];
            sum += tmp - '0';
        }
        if (sum == n) {
            cout << i;
            return 0;
        }
    }
    cout << "0";

    return 0;
}