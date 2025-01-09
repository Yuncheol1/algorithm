import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n];
        arr = new int[m];
        dfs(0, 0);
        System.out.println(sb);

    }

    static void dfs(int depth, int start) {
        if (depth == m) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}