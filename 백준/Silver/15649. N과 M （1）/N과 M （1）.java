import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static int n, m;
    public static boolean[] visited;
    public static int[] ans;

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n];
        ans = new int[m];
        BackTracking(0);
        System.out.println(sb);

    }

    public static void BackTracking(int depth) {
        if (depth == m) {
            for (int i : ans) {
                sb.append(i).append(" ");

            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                ans[depth] = i + 1;
                BackTracking(depth + 1);
                visited[i] = false;
            }
        }

    }
}
