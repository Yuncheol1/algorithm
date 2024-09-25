//package algorithm;
import java.io.*;
import java.util.*;
import java.util.Scanner;
public class Main {
    public static int n,m,k;
public static int[][]x;
public static int[][]c;
public static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(br.readLine());
        for(int asdf=0;asdf<t;asdf++) {
            int cnt=0;
            StringTokenizer st = new StringTokenizer(br.readLine());
             n=Integer.parseInt(st.nextToken());
             m=Integer.parseInt(st.nextToken());
             k=Integer.parseInt(st.nextToken());
            x=new int[n][m];
            c=new int[k][2];
            visited=new boolean[n][m];
            for(int q=0;q<k;q++){
                StringTokenizer str = new StringTokenizer(br.readLine());
                int i=Integer.parseInt(str.nextToken());
                int j=Integer.parseInt(str.nextToken());
                x[i][j]=1;
                c[q][0]=i;
                c[q][1]=j;
            }
            for(int i=0;i<k;i++){
                if(!visited[c[i][0]][c[i][1]]){
                    cnt++;
                    bfs(c[i][0],c[i][1]);
                }
            }
            System.out.println(cnt);
        }


    }
static void bfs(int i,int j){
        Queue<int[]>q=new LinkedList<>();
        visited[i][j]=true;
        q.add(new int[]{i,j});
        while(!q.isEmpty()){
            int[] now = q.poll();
            int r = now[0];
            int c = now[1];
            if (r < n && c - 1 < m && r >= 0 && c - 1 >= 0 && x[r][c - 1] != 0 && !visited[r][c - 1]) {
                visited[r][c - 1] = true;

                q.add(new int[]{r, c - 1});
            }
            if (r < n && c + 1 < m && r >= 0 && c + 1 >= 0 && x[r][c + 1] != 0 && !visited[r][c + 1]) {
                visited[r][c + 1] = true;
                q.add(new int[]{r, c + 1});
            }
            if (r - 1 < n && c < m && r - 1 >= 0 && c >= 0 && x[r - 1][c] != 0 && !visited[r - 1][c]) {
                visited[r - 1][c] = true;
                q.add(new int[]{r - 1, c});
            }
            if (r + 1 < n && c < m && r + 1 >= 0 && c >= 0 && x[r + 1][c] != 0 && !visited[r + 1][c]) {
                visited[r + 1][c] = true;
                q.add(new int[]{r + 1, c});
            }

        }
}

}