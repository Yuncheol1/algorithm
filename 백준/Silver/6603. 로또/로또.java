import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] x;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] input = br.readLine().split(" ");
            if (input[0].charAt(0) == '0') {
                break;
            }
            x = new int[50];
            visited = new boolean[50];
            ans = new int[6];
            for (int i = 1; i < input.length; i++) {
                x[Integer.parseInt(input[i])] = Integer.parseInt(input[i]);
            }
            Btracking(0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void Btracking(int depth, int start) {
        if (6 == depth) {
            for (int i : ans) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < 50; i++) {
            if (x[i] == 0) {
                continue;
            }
            if (!visited[i]) {

                visited[i] = true;
                ans[depth] = x[i];
                Btracking(depth + 1, i + 1);
                visited[i] = false;
            }
        }

    }
}