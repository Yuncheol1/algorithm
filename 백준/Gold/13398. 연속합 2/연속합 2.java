import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp1 = new int[N];
        dp1[0] = arr[0];

        int ans = dp1[0];

        for (int i = 1; i < N; i++) {
            dp1[i] = Math.max(dp1[i - 1] + arr[i], arr[i]);

            ans = Math.max(ans, dp1[i]);
        }

        int[] dp2 = new int[N];
        dp2[N - 1] = arr[N - 1];

        for (int i = N - 2; i >= 0; i--) {
            dp2[i] = Math.max(dp2[i + 1] + arr[i], arr[i]);
        }

        for (int i = 1; i < N - 1; i++) {
            int temp = dp1[i - 1] + dp2[i + 1];

            ans = Math.max(ans, temp);
        }

        System.out.println(ans);
    }

}