import java.util.*;
import java.io.*;

public class Main {
    static int ans=0;
    static boolean visited[][];
    static int[]dx={-1,0,1,0};
    static int[]dy={0,1,0,-1};
    static int n,m;
    static int[][]x;
    static int[][]x2;
    static int[][]wall=new int[3][2];
    static ArrayList<int[]>arr=new ArrayList<>();
    static Queue<int[]>qq=new LinkedList<>();
    static Queue<int[]>q;
    public static void main(String[] args) throws IOException {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st=new StringTokenizer(br.readLine());
    n=Integer.parseInt(st.nextToken());
    m=Integer.parseInt(st.nextToken());
    x=new int[n][m];
    for(int i=0;i<n;i++){
        st=new StringTokenizer(br.readLine());
        for(int j=0;j<m;j++){
            x[i][j]=Integer.parseInt(st.nextToken());
            if(x[i][j]==0){
                arr.add(new int[]{i,j});
            }
            if(x[i][j]==2)qq.add(new int[]{i,j});
        }
    }
    backtracking(0,0);
    System.out.print(ans);
    }
    static void bfs(){
        q=new LinkedList<>();
        for( var t:qq)q.add(t.clone());
        x2=new int[x.length][];
        for(int i=0;i<x.length;i++){
            x2[i]=x[i].clone();
        }
        visited=new boolean[n][m];
        while(!q.isEmpty()){
            int[]now=q.poll();
            visited[now[0]][now[1]]=true;
            for(int i=0;i<4;i++){
                int nx=now[0]+dx[i];
                int ny=now[1]+dy[i];
                if(nx>=0&&ny>=0&&nx<n&&ny<m&&!visited[nx][ny]&&x2[nx][ny]==0){
                    q.add(new int[]{nx,ny});
                    x2[nx][ny]=2;
                    visited[nx][ny]=true;
                }
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(x2[i][j]==0)cnt++;
            }
        }
        ans=Math.max(ans,cnt);
        return;
    }
    static void backtracking(int depth,int start){
                if(depth==3){
                    bfs();
                    return;
                }
                if(start>=arr.size())return;
        for(int i=start;i<arr.size();i++){
            x[arr.get(i)[0]][arr.get(i)[1]]=1;
            backtracking(depth+1,i+1);
            x[arr.get(i)[0]][arr.get(i)[1]]=0;
        }
    }
}
