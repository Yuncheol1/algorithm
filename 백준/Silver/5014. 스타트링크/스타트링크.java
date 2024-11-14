import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int F;
    static int S;
    static int G;
    static int[] dir = new int[2];
    static int[] count;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        F = sc.nextInt();//건물 높이
        S = sc.nextInt();//현재 층
        G = sc.nextInt();//사무실 있는 층
        dir[0] = sc.nextInt();//올라가는 버튼
        dir[1] = -sc.nextInt();//내려가는 버튼
        count = new int[F + 1];
        bfs(S);
    }

    static void bfs(int S) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[F + 1];
        q.add(S);
        visited[S] = true;
        count[S] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == G) {
                System.out.println(count[cur]);
                return;
            }
            for (int i = 0; i < 2; i++) {
                if (cur + dir[i] > F || cur + dir[i] < 1) {
                    continue;
                }
                if (!visited[cur + dir[i]]) {
                    visited[cur + dir[i]] = true;
                    q.add(cur + dir[i]);
                    count[cur + dir[i]] = count[cur] + 1;
                }
            }
        }

        System.out.println("use the stairs");
    }
}