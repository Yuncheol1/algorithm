import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] x = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i][0] = Integer.parseInt(st.nextToken());
            x[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(x, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        int start = x[0][0];
        int end = x[0][1];
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (x[i][0] <= end && x[i][1] >= end) {
                end = x[i][1];
                continue;
            }
            if (x[i][0] > end) {
                ans += Math.abs(end - start);
                start = x[i][0];
                end = x[i][1];
            }
        }
        ans += Math.abs(end - start);
        System.out.println(ans);
    }
}