import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static ArrayDeque<Integer> stack=new ArrayDeque<>();
    static boolean[]visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        graph=new ArrayList[n+1];
        visited=new boolean[n+1];
        for(int i=0;i<n+1;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=1;i<=m;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        int cnt=0;
        for(int i=1;i<n+1;i++){
            if(!visited[i]){
                stack.push(i);
                visited[i]=true;
                dfs();
                cnt++;
            }
        }
        System.out.println(cnt);


    }
    static void dfs(){
        while(!stack.isEmpty()){
            int now=stack.pop();
            for(int i=0;i<graph[now].size();i++){
                if(!visited[graph[now].get(i)]){
                    stack.push(graph[now].get(i));
                    visited[graph[now].get(i)]=true;
                }
            }


        }




    }
}
