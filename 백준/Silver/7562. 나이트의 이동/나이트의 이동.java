import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int[][] chess;
    static boolean[][] visited;
    static int targetx, targety, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int asdf = 0; asdf < T; asdf++) {
            n = Integer.parseInt(br.readLine());
            chess = new int[n][n];
            visited = new boolean[n][n];
            st = new StringTokenizer(br.readLine());
            int nightx = Integer.parseInt(st.nextToken());
            int nighty = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            targetx = Integer.parseInt(st.nextToken());
            targety = Integer.parseInt(st.nextToken());
            System.out.println(bfs(nightx, nighty));
        }
    }

    static int bfs(int x, int y) {
        if (x == targetx && y == targety) {
            return 0;
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        int cnt = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                    chess[nx][ny] = chess[now[0]][now[1]] + 1;
                    if (nx == targetx && ny == targety) {
                        return chess[nx][ny];
                    }
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }

        }
        return 0;
    }
}