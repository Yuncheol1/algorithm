import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[][] x;
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {-1, 0, 1, 0};
    public static int danjicnt=0;
    public static ArrayList<Integer> arr=new ArrayList<>();
    public static boolean visited[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = new int[n][n];
        visited=new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                x[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(x[i][j]==1){
                    danjicnt++;
                    bfs(i,j);
                }
            }
        }
        System.out.println(danjicnt);
        Collections.sort(arr);
        for(int i=0;i<arr.size();i++)System.out.printf("%d\n", arr.get(i));
    }

    static void bfs(int i,int j) {
        Queue<int[]>q=new LinkedList<>();
        visited[i][j]=true;
        q.add(new int[]{i,j});
        int cnt=1;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            x[now[0]][now[1]]=2;
            for (int k = 0; k < 4; k++) {
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && x[nx][ny] == 1&&!visited[nx][ny]) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny]=true;
                    cnt++;
                }
            }
        }
        arr.add(cnt);
    }
}
