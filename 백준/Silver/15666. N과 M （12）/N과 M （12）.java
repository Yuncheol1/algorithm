import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
    static int n, m;
    static boolean[] visited;
    static int[] ans;
    static int[] x;
    static LinkedHashSet<String> hash = new LinkedHashSet<>();
    ;

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
        BackTracking(0, 1);
        for (var i : hash) {
            System.out.println(i);
        }
    }

    static void BackTracking(int depth, int start) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int i : ans) {
                sb.append(i).append(" ");
            }
            hash.add(sb.toString());
            return;
        }

        for (int i = start; i <= n; i++) {
       //     if (!visited[i]) {
                visited[i] = true;
                ans[depth] = x[i];
                BackTracking(depth + 1, i);
                visited[i] = false;
      //      }
        }
    }

}

