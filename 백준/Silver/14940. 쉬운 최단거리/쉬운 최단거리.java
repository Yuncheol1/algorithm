import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] x;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();
    static int[][] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = new int[n][m];
        ans = new int[n][m];
        visited = new boolean[n][m];
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                x[i][j] = Integer.parseInt(st.nextToken());
                if (x[i][j] == 2) {
                    ans[i][j] = 0;
                    visited[i][j] = true;
                    a = i;
                    b = j;
                }
                if (x[i][j] == 0) {
                    ans[i][j] = 0;
                    visited[i][j] = true;
                }
            }
        }
        bfs(a, b);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    ans[i][j] = -1;
                    visited[i][j] = true;
                }
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void bfs(int ia, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{ia, j});
        int qsize = 0;
        int depth = 1;
        while (!q.isEmpty()) {
            qsize = q.size();
            for (int i = 0; i < qsize; i++) {
                int[] now = q.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = dx[k] + now[0];
                    int ny = dy[k] + now[1];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && x[nx][ny] != 0) {
                        ans[nx][ny] = depth;
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
            depth++;
        }
    }
}