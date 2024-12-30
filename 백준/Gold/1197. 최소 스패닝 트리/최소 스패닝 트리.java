import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int start;
    int end;
    int weight;

    Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}

public class Main {
    static int[] ans;

    static void union(int a, int b) {
        int A = find(a);
        int B = find(b);
        if (A < B) {
            ans[B] = A;
        } else if (A > B) {
            ans[A] = B;
        }
    }

    static int find(int a) {
        if (a == ans[a]) {
            return a;
        }
        return ans[a] = find(ans[a]);
    }

    static boolean checksame(int a, int b) {
        int A = find(a);
        int B = find(b);
        if (A == B) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        ans = new int[V + 1];
        for (int i = 1; i < V; i++) {
            ans[i] = i;
        }
        PriorityQueue<Edge> q = new PriorityQueue<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            q.add(new Edge(A, B, C));
        }
        int sum = 0;
        int cnt = 0;
        while (cnt != V - 1) {
            Edge edge = q.poll();
            if (checksame(edge.start, edge.end)) {
                continue;
            }
            union(edge.start, edge.end);
            cnt++;
            sum += edge.weight;
        }
        System.out.print(sum);
    }
}




