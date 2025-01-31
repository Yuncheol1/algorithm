import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] wine = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            wine[i] = sc.nextInt();
        }
        if (n == 1) {
            System.out.println(wine[1]);
            return;
        }
        if (n == 2) {
            System.out.println(wine[1] + wine[2]);
            return;
        }
        int[] dp = new int[n + 1];
        dp[1] = wine[1];
        dp[2] = wine[1] + wine[2];
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(wine[i - 1] + wine[i] + dp[i - 3], dp[i - 2] + wine[i]));
        }
        System.out.println(dp[n]);
    }
}