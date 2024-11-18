import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] x;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                x[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (x[i][j] == 1) {
                    x[i][j] = 0;
                    bfs(i, j);
                }
            }
        }
        if (arr.isEmpty()) {
            System.out.println(0);
            System.out.println(0);
            return;
        }
        Collections.sort(arr);
        System.out.println(arr.size());
        System.out.println(arr.get(arr.size() - 1));
    }

    static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        int cnt = 1;
        q.add(new int[]{i, j});
        visited[i][j] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && x[nx][ny] == 1) {
                    cnt++;
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    x[nx][ny] = 0;
                }
            }
        }
        arr.add(cnt);
    }
}
