import java.io.*;
import java.util.*;

public class Main {
    public static boolean v[][];
    public static boolean v2[][];
    public static char x[][];
    public static int n;
    public static int cnt=0;
    public static int cnt2=0;
    public static int dx[]={-1,0,1,0};
    public static int dy[]={0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = new char[n][n];
        v=new boolean[n][n];
        v2=new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                x[i][j] = line.charAt(j);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!v[i][j]){
                    bfs(i,j,x[i][j],1);
                    cnt++;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(x[i][j]=='R')x[i][j]='G';
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!v2[i][j]){
                    bfs(i,j,x[i][j],2);
                    cnt2++;
                }
            }
        }
        System.out.printf("%d %d",cnt,cnt2);

    }
    static void bfs(int i,int j,char ch,int a){

        Queue<int[]>q=new LinkedList<>();
       if(a==1)v[i][j]=true;
       else v2[i][j]=true;
        q.add(new int[]{i,j});
        while(!q.isEmpty()){
            int []now=q.poll();
            for(int k=0;k<4;k++){
                int nx=now[0]+dx[k];
                int ny=now[1]+dy[k];
                if(a==1&&nx>=0&&ny>=0&&nx<n&&ny<n&&x[nx][ny]==ch&&!v[nx][ny]){
                    q.add(new int[]{nx,ny});
                    v[nx][ny]=true;
                }
                if(a==2&&nx>=0&&ny>=0&&nx<n&&ny<n&&x[nx][ny]==ch&&!v2[nx][ny]){
                    q.add(new int[]{nx,ny});
                    v2[nx][ny]=true;
                }
            }
        }
    }
}
