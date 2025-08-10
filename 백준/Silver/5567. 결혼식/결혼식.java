import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int m=Integer.parseInt(br.readLine());
        int cnt=0;
        ArrayList<Integer>[]friend=new ArrayList[n+1];
        boolean[]visited=new boolean[n+1];
        visited[1]=true;
        for(int i=1;i<=n;i++)friend[i]=new ArrayList<>();
        StringTokenizer st;
        for(int i=0;i<m;i++) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            friend[a].add(b);
            friend[b].add(a);
        }
        if(friend[1].size()==0) {
            System.out.println(0);
        }
        else {
            Queue<Integer>q=new ArrayDeque<>();
            for(int t:friend[1]) {
                q.offer(t);
               cnt++;
                visited[t]=true;
            }
            while(!q.isEmpty()) {
                int now=q.poll();
                for(int t:friend[now]) {
                    if(!visited[t]){
                    cnt++;
                    visited[t]=true;
                    }
                }
            }
            System.out.println(cnt);
        }

    }


}
