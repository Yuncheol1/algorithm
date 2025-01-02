import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    static ArrayList<ArrayList<Integer>> tree;
    static boolean[] visited;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        visited = new boolean[n + 1];
        ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tree.get(v).add(e);
            tree.get(e).add(v);
        }
        dfs(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(ans[i]);
        }
    }

    static void dfs(int num) {
        visited[num] = true;
        for (int i : tree.get(num)) {
            if (!visited[i]) {
                ans[i] = num;
                dfs(i);
            }
        }
    }
}




