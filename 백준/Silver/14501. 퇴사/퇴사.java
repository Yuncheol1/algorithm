import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] x = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            x[i][0] = sc.nextInt();
            x[i][1] = sc.nextInt();
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        if (x[n][0] == 1) {
            dp[n] = x[n][1];
        }
        for (int i = n - 1; i >= 1; i--) {
            if (i + x[i][0] <= n) {
                dp[i] = Math.max(dp[i + 1], dp[i + x[i][0]] + x[i][1]);
            } else if (i + x[i][0] == n + 1) {
                dp[i] = Math.max(x[i][1], dp[i + 1]);
            } else if (i + x[i][0] > n + 1) {
                dp[i] = dp[i + 1];
            }
        }
        int max = Arrays.stream(dp).max().getAsInt();
        System.out.print(max);
    }
}




