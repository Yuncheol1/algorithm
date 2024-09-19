//package algorithm;
import java.io.*;
import java.util.*;
import java.util.Scanner;
class graph{
    int num;
    ArrayList<LinkedList<Integer>> adj;
boolean[] visited;
    public graph(int num){
    this.num=num;
    adj=new ArrayList<>(num);
    visited=new boolean[num];
    for(int i=0;i<num;i++)
     adj.add(new LinkedList<>());
  }
void addEdge(int v,int e){
adj.get(v).add(e);
adj.get(e).add(v);
}
void dfs(int vertex){
        visited[vertex]=true;
   //     System.out.print(vertex);
        for(int i: adj.get(vertex)){
            if(!visited[i]){
                dfs(i);
            }
        }

}
    public void printGraph() {
        for (int i = 0; i < num; i++) {
            System.out.print("Vertex " + i + ": ");
            for (Integer neighbor : adj.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st=new StringTokenizer(br.readLine());
        int n,m,v,e;
       n=Integer.parseInt(st.nextToken());
       m=Integer.parseInt(st.nextToken());
        graph g=new graph(n+1);
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            v=Integer.parseInt(st.nextToken());
            e=Integer.parseInt(st.nextToken());
            g.addEdge(v,e);
        }
        int cnt=0;
        for(int i=1;i<n+1;i++){
            if(!g.visited[i]){
                cnt++;
                g.dfs(i);
            }
        }
        System.out.print(cnt);
    }
}