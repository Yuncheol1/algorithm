import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int vertex;
    int weight;

    Edge(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return weight - o.weight;
    }
}

public class Main {
    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        distance = new int[n + 1];
        visited = new boolean[n + 1];
        Arrays.fill(distance, 200000000);
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i <= m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Edge(end, weight));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        distance[s] = 0;
        pq.add(new Edge(s, 0));
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (visited[edge.vertex]) {
                continue;
            }
            visited[edge.vertex] = true;
            for (var a : graph.get(edge.vertex)) {
                int nextvertex = a.vertex;
                int nextweight = a.weight;
                if (distance[nextvertex] > distance[edge.vertex] + nextweight) {
                    distance[nextvertex] = distance[edge.vertex] + nextweight;
                    pq.add(new Edge(nextvertex, distance[nextvertex]));
                }
            }
        }
        System.out.print(distance[e]);
    }
}






