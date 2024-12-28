import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge {
    int start;
    int end;
    int weight;

    Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Edge[] edge = new Edge[m];
        long[] ans = new long[n + 1];
        Arrays.fill(ans, Long.MAX_VALUE);
        ans[1] = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edge[i] = new Edge(start, end, weight);
        }
        for (int as = 0; as < n - 1; as++) {
            for (int i = 0; i < m; i++) {
                if (ans[edge[i].start] != Long.MAX_VALUE &&
                        ans[edge[i].start] + edge[i].weight < ans[edge[i].end]) {
                    ans[edge[i].end] = ans[edge[i].start] + edge[i].weight;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (ans[edge[i].start] != Long.MAX_VALUE &&
                    ans[edge[i].start] + edge[i].weight < ans[edge[i].end]) {
                System.out.println("-1");
                return;
            }
        }
        for (int i = 2; i <= n; i++) {
            if (ans[i] == Long.MAX_VALUE) {
                System.out.println("-1");
            } else {
                System.out.println(ans[i]);
            }
        }
    }
}






