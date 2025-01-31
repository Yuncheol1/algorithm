import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stairs = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stairs[i] = sc.nextInt();
        }
        if (n == 1) {
            System.out.println(stairs[1]);
            return;
        }
        if (n == 2) {
            System.out.println(stairs[1] + stairs[2]);
            return;
        }
        int[] dp = new int[n + 1];
        dp[1] = stairs[1];
        dp[2] = stairs[1] + stairs[2];
        dp[3] = Math.max(stairs[3] + stairs[2], stairs[1] + stairs[3]);
        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + stairs[i], stairs[i] + stairs[i - 1] + dp[i - 3]);
        }
        System.out.println(dp[n]);
    }
}