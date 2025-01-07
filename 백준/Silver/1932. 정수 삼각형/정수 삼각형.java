import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] x = new int[n][];
        int[][] dp = new int[n][];
        for (int i = 0; i < n; i++) {
            x[i] = new int[i + 1];
            dp[i] = new int[i + 1];
        }
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                x[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = x[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + x[i][j];
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + x[i][j];
                } else {
                    if (dp[i - 1][j - 1] + x[i][j] > dp[i - 1][j] + x[i][j]) {
                        dp[i][j] = dp[i - 1][j - 1] + x[i][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] + x[i][j];
                    }
                }
            }
        }
        Arrays.sort(dp[n - 1]);
        System.out.print(dp[n - 1][n - 1]);
    }
}