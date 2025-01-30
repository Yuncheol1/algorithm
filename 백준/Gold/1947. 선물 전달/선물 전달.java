import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final long mod = 1000000000;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n==1){
            System.out.println(0);
            return;
        }
        long[] dp = new long[n + 1];
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2]);
            dp[i] = dp[i] % mod;
        }
      
        System.out.println(dp[n]);
    }
}