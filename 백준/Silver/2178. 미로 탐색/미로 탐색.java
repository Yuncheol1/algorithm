//package algorithm;

import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Main {
    static int[][] x;
    static boolean[][] visited;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < m; j++) {
                x[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }
        bfs(0, 0);
        System.out.print(x[n - 1][m - 1]);

    }

    public static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        visited[i][j] = true;
        q.add(new int[]{i, j});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int r = now[0];
            int c = now[1];
            if (r < n && c - 1 < m && r >= 0 && c - 1 >= 0 && x[r][c - 1] != 0 && !visited[r][c - 1]) {
                visited[r][c - 1] = true;
                x[r][c - 1] = x[r][c] + 1;
                q.add(new int[]{r, c - 1});
            }
            if (r < n && c + 1 < m && r >= 0 && c + 1 >= 0 && x[r][c + 1] != 0 && !visited[r][c + 1]) {
                visited[r][c + 1] = true;
                x[r][c + 1] = x[r][c] + 1;
                q.add(new int[]{r, c + 1});
            }
            if (r - 1 < n && c < m && r - 1 >= 0 && c >= 0 && x[r - 1][c] != 0 && !visited[r - 1][c]) {
                visited[r - 1][c] = true;
                x[r - 1][c] = x[r][c] + 1;
                q.add(new int[]{r - 1, c});
            }
            if (r + 1 < n && c < m && r + 1 >= 0 && c >= 0 && x[r + 1][c] != 0 && !visited[r + 1][c]) {
                visited[r + 1][c] = true;
                x[r + 1][c] = x[r][c] + 1;
                q.add(new int[]{r + 1, c});
            }
        }
    }
}