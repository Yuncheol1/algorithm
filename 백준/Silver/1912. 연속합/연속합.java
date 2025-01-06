import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n + 1];
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            x[i] = sc.nextInt();
        }
        dp[1] = x[1];
        dp[0] = Integer.MAX_VALUE * -1;
        for (int i = 2; i <= n; i++) {
            if (dp[i - 1] + x[i] >= x[i]) {
                dp[i] = dp[i - 1] + x[i];
            } else {
                dp[i] = x[i];
            }
        }
        // System.out.print(Arrays.toString(dp));
        Arrays.sort(dp);
        System.out.print(dp[n]);
    }
}

