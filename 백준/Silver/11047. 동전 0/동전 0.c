#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#pragma warning(disable:4996)
int main() {
    long long n, k;
    scanf("%lld %lld", &n, &k);
    long long* x = (long long*)malloc(n * sizeof(long long));
    long long a;
    int check = 0;
    for (long long i = 0; i < n; i++) {
        scanf("%lld", &x[i]);
        if (x[i] > k&&check==0) {
            a = i - 1;
            check = 1;
        }

    }
    if (check == 0)a = n - 1;
    long long cnt = 0;
    while (1) {
        if (k <= 0)break;
        if (k < x[a])a--;
        else {
            k -= x[a];
            cnt++;
        }
    //    printf("%lld\n", k);
   }
    printf("%lld", cnt);

    return 0;
}
