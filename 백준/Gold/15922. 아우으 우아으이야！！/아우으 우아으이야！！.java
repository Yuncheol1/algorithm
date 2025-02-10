import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] line = new int[n * 2][2];
        for (int i = 0; i < 2 * n; i += 2) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            line[i][0] = start;
            line[i][1] = 1;
            line[i + 1][0] = end;
            line[i + 1][1] = -1;
        }
        Arrays.sort(line, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        int cnt = 0;
        int start = 0;
        int end = 0;
        int ans = 0;
        for (int i = 0; i < 2 * n; i++) {
            if (cnt == 0) {
                start = line[i][0];
            }
            cnt += line[i][1];
            if (cnt == 0) {
                ans += line[i][0] - start;
            }
        }
        System.out.println(ans);
    }
}
