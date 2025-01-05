import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n + 1];
        int[] reverse_x = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            x[i] = sc.nextInt();
            reverse_x[n + 1 - i] = x[i];
        }

        int[] dp = new int[n + 1];
        int[] dp2 = new int[n + 1];
        Arrays.fill(dp, 1);
        Arrays.fill(dp2, 1);
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (x[i] > x[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (reverse_x[i] > reverse_x[j]) {
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dp[i] + dp2[n + 1 - i] - 1);
        }
        System.out.print(max);
    }
}

