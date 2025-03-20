import java.io.*;
import java.util.*;

public class Main {
    private static int[]dx={-1,0,1,0};
    private static int[]dy={0,1,0,-1};
    private static int[][]distance;
    private static int[][]cave;
    private static boolean[][]visited;
    private static final int MAX=99999999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int a=1; ;a++){
            int n=Integer.parseInt(br.readLine());
            if(n==0)break;
            cave=new int[n][n];
            distance=new int[n][n];
            visited=new boolean[n][n];
            for(int i=0;i<n;i++){
                st=new StringTokenizer(br.readLine());
                for(int j=0;j<n;j++){
                    cave[i][j]=Integer.parseInt(st.nextToken());
                }
            }
           for(int i=0;i<n;i++){
               for(int j=0;j<n;j++){
                   distance[i][j]=MAX;
               }
           }
            distance[0][0]=cave[0][0];
            PriorityQueue<int[]>q=new PriorityQueue<>((o1,o2)->{
                return o1[2]-o2[2];
            });
            q.add(new int[]{0,0,distance[0][0]});
            while(!q.isEmpty()){
                int[] now=q.poll();
                int x=now[0];
                int y=now[1];
                if(visited[x][y])continue;
                visited[x][y]=true;
                for(int k=0;k<4;k++){
                    int nx=dx[k]+x;
                    int ny=dy[k]+y;
                    if(nx>=0&&ny>=0&&nx<n&&ny<n){
                        if(distance[nx][ny]>distance[x][y]+cave[nx][ny]){
                            distance[nx][ny]=distance[x][y]+cave[nx][ny];
                            q.add(new int[]{nx,ny,distance[nx][ny]});
                        }
                    }
                }

            }

            System.out.printf("Problem %d: %d\n",a,distance[n-1][n-1]);


        }


    }
}