import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[][] x;
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {-1, 0, 1, 0};
    public static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // n과 m의 순서를 올바르게 설정
        m = Integer.parseInt(st.nextToken());  // 열
        n = Integer.parseInt(st.nextToken());  // 행
        x = new int[n][m];

        // 입력 처리 및 시작점(익은 토마토) 설정
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                x[i][j] = Integer.parseInt(st.nextToken());
                if (x[i][j] == 1) {
                    q.add(new int[]{i, j});  // 익은 토마토는 큐에 삽입
                }
            }
        }

        // BFS 수행
        bfs();

        // 배열 출력 (디버깅용)
/*
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(x[i][j] + " ");
            }
            System.out.println();
        }
*/

        // 결과 계산
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (x[i][j] == 0) {  // 익지 않은 토마토가 있는 경우
                    System.out.print(-1);
                    return;
                }
                max = Math.max(max, x[i][j]);  // 가장 큰 값(최대 일수)
            }
        }

        // 최대 일수에서 1을 빼서 출력 (처음에 1로 시작했기 때문에)
        System.out.print(max - 1);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];

                // 범위 내에서 익지 않은 토마토(0)만 갱신
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && x[nx][ny] == 0) {
                    x[nx][ny] = x[now[0]][now[1]] + 1;  // 1일씩 증가
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}
