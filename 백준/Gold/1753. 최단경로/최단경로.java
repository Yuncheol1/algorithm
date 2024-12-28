import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class edge  implements Comparable<edge> {
    int vertex;
    int weight;

    edge(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }


    @Override
    public int compareTo(edge o) {
        return this.weight-o.weight;
    }
}

public class Main {
    static PriorityQueue<edge> q = new PriorityQueue<>();
    static boolean[] visited;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<ArrayList<edge>> graph = new ArrayList<>();
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[V + 1];
        ans = new int[V + 1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[K] = 0;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new edge(v, w));
        }
        q.add(new edge(K, 0));
        while (!q.isEmpty()) {
            edge cur = q.poll();
            if (visited[cur.vertex]) {
                continue;
            }
            visited[cur.vertex]=true;
            for( var Edge:graph.get(cur.vertex)){
                int nextvertex=Edge.vertex;
                int nextweight= Edge.weight;

                if(ans[nextvertex]>ans[cur.vertex]+nextweight){
                    ans[nextvertex]=ans[cur.vertex]+nextweight;
                    q.add(new edge(nextvertex,ans[nextvertex]));
                }
            }
        }
        for(int i=1;i<=V;i++){
           if(ans[i]==Integer.MAX_VALUE){
               System.out.println("INF");
           }
           else{
               System.out.println(ans[i]);
           }
        }
    }
}
