import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] x;
    static int n;
    static boolean[][] v;
    static int max;
    static int min;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = new int[n][n];
        max=0;
        min=101;
        cnt=0;
        int maxcnt=1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                x[i][j] = Integer.parseInt(st.nextToken());
                if(max<x[i][j])max=x[i][j];
            }
        }
        for(int m=max-1;m>=1;m--){
            v = new boolean[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(x[i][j]>m&&!v[i][j]){
                       bfs(i,j,m);
                       cnt++;
                    }
                }
            }
            if(maxcnt<cnt)maxcnt=cnt;
            cnt=0;
        }
        System.out.println(maxcnt);
    }

    static void bfs(int i, int j,int m) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        v[i][j] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];
                if (nx < n && nx >= 0 && ny < n && ny >= 0 && x[nx][ny] >m && !v[nx][ny]) {
                    q.add(new int[]{nx, ny});
                    v[nx][ny] = true;
                    
                }
            }
        }
    }
}
