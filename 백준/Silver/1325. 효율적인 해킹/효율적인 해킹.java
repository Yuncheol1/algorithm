import java.io.*;
import java.util.*;


public class Main {
    static ArrayList<Integer>[] adj;
    static int n, m;
    static boolean[] visited;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int max = 0;
        adj = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }
        ans = new int[n + 1];
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            adj[v].add(e);
        }
        for (int i = 1; i < n + 1; i++) {
            bfs(i);
        }
        for (int i = 1; i < n + 1; i++) {
            max = Math.max(max, ans[i]);
        }
        for (int i = 1; i < n + 1; i++) {
            if (max == ans[i]) {
                System.out.print(i+" ");
            }
        }

    }

    static void bfs(int v) {
        Queue<Integer> q = new ArrayDeque<>();
        visited = new boolean[n + 1];
        visited[v] = true;
        q.offer(v);
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i : adj[now]) {
                if (!visited[i]) {
                    q.offer(i);
                    ans[i]++;
                    visited[i] = true;
                }
            }
        }
    }
}
