import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n + 1];
        ans = new int[m];
        BackTracking(0);
        System.out.println(sb);
    }

    static void BackTracking(int depth) {
        if (depth == m) {
            for (int i : ans) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                ans[depth] = i;
                BackTracking(depth + 1);
                visited[i] = false;
            }
        }


    }

}