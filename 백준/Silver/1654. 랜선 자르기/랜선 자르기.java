import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] LAN = new int[K];
        long min = 0;
        long max = 0;
        for (int i = 0; i < K; i++) {
            LAN[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, LAN[i]);
        }
        max++;
        while (min < max) {
            long mid = min + (max - min) / 2;
            long sum = 0;
            for (int i = 0; i < K; i++) {
                sum += LAN[i] / mid;
            }
            if (sum < N) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }
}