import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] x = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }
        int startP = 0;
        int endP = 0;
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            return o1 - o2;
        });
        while (true) {
            if (endP == n && sum < s) {
                break;
            }
            if (sum < s) {
                sum += x[endP];
                endP++;
                if (sum >= s) {
                    pq.add(endP - startP);
                }
                continue;
            }
            if (sum >= s) {
                sum -= x[startP];
                startP++;
                if (sum >= s) {
                    pq.add(endP - startP);
                }
                continue;
            }
        }
        if (pq.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(pq.poll());
        }
    }
}