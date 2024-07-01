import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[][] x = new int[1024][1024];
        int[][] c_sum = new int[1024][1024];
        int n, m;
        int sum = 0;

        // 첫 줄에서 n과 m을 입력받음
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 배열 x를 채우고 c_sum 계산
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                x[i][j] = Integer.parseInt(st.nextToken());
                sum += x[i][j];
                c_sum[i][j] = sum;
            }
        }

        // 쿼리를 처리하고 결과를 출력
        for (int i = 0; i < m; i++) {
            int result = 0;
            st = new StringTokenizer(reader.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;

            for (int j = x1; j <= x2; j++) {
                result += c_sum[j][y2] - c_sum[j][y1] + x[j][y1];
            }
            System.out.println(result);
        }
    }
}
