import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int[] ans;
    static int[] x;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        x = new int[n + 1];
        visited = new boolean[n + 1];
        ans = new int[m];
        for (int i = 1; i <= n; i++) {
            x[i] = sc.nextInt();
        }
        Arrays.sort(x);
        BackTracking(0,1);
        System.out.println(sb);
    }

    static void BackTracking(int depth,int start) {
        if (depth == m) {
            for (int i : ans) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                ans[depth] = x[i];
                BackTracking(depth + 1,i+1);
                visited[i] = false;
            }
        }
    }

}

