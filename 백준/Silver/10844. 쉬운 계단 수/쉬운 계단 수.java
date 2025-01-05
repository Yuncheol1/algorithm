import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] dp = new long[n + 1][11];
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }
        dp[1][0] = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j + 1];
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
                }
            }
        }
        long sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum = (sum + dp[n][i]) % 1000000000;
        }
        System.out.print(sum);
    }
}

