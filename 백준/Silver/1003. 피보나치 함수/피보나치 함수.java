import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int qw = 0; qw < t; qw++) {
            int n = sc.nextInt();
            if (n == 0) {
                System.out.printf("%d %d\n", 1, 0);
                continue;
            }
            if (n == 1) {
                System.out.printf("%d %d\n", 0, 1);
                continue;

            }
            int[][] dp = new int[n + 1][2];
            dp[0][0] = 1;
            dp[0][1] = 0;
            dp[1][0] = 0;
            dp[1][1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
                dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
            }
            System.out.printf("%d %d\n", dp[n][0], dp[n][1]);
        }
    }
}

