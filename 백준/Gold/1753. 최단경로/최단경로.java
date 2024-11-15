import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int vertex; // 현재 정점
    int edge;   // 현재 정점까지의 거리

    Node(int vertex, int edge) {
        this.vertex = vertex;
        this.edge = edge;
    }

    @Override
    public int compareTo(Node other) {
        return this.edge - other.edge; // 거리 기준으로 오름차순 정렬
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); // 정점 개수
        int E = Integer.parseInt(st.nextToken()); // 간선 개수
        int K = Integer.parseInt(br.readLine()); // 시작 정점

        // 그래프 초기화
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        
        int[] distance = new int[V + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[K] = 0; 

        
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, e)); // u에서 v로 가는 간선
        }

        // 우선순위 큐 초기화
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(K, 0)); // 시작 정점을 큐에 추가

        boolean[] visited = new boolean[V + 1]; // 방문 여부

        // 다익스트라 알고리즘
        while (!q.isEmpty()) {
            Node now = q.poll();

            if (visited[now.vertex]) {
                continue; // 이미 방문한 정점은 무시
            }
            visited[now.vertex] = true;

            // 현재 정점과 연결된 정점들 확인
            for (Node neighbor : graph.get(now.vertex)) {
                int nextVertex = neighbor.vertex;
                int weight = neighbor.edge;

                // 더 짧은 경로 발견 시 갱신
                if (distance[now.vertex] + weight < distance[nextVertex]) {
                    distance[nextVertex] = distance[now.vertex] + weight;
                    q.add(new Node(nextVertex, distance[nextVertex])); // 갱신된 거리로 큐에 추가
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }
}
