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
                ans[depth] = i;
                BackTracking(depth + 1,i);
            }
        }
        
    }

