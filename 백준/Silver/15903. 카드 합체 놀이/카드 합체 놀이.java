import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            pq.add(Long.valueOf(input[i]));
        }
        for (int i = 0; i < m; i++) {
            long x = pq.poll();
            long y = pq.poll();
            x += y;
            pq.add(x);
            pq.add(x);
        }
        long ans = 0;
        while (!pq.isEmpty()) {
            ans += pq.poll();
        }
        System.out.println(ans);
    }
}