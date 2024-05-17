#include <iostream>
#include <vector>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int t;
    cin >> t;

    for (int nt = 0; nt < t; nt++) {
        int n;
        cin >> n;

        vector<int> x(n);
        for (int i = 0; i < n; i++) {
            cin >> x[i];
        }

        long long benefit = 0;
        int max_price = 0;

        // 배열을 뒤에서부터 순회하며 최대 이익 계산
        for (int i = n - 1; i >= 0; i--) {
            if (x[i] > max_price) {
                max_price = x[i];
            }
            benefit += max_price - x[i];
        }

        cout << benefit << '\n';
    }

    return 0;
}
