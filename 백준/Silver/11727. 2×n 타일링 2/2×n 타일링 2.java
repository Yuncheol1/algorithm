import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[1001];
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
        }
        System.out.print(dp[n]);
    }
}

