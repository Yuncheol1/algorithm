

import java.io.*;
import java.nio.Buffer;
import java.util.*;
import java.io.*;

public class Main {
    static class node implements Comparable<node> {
        int v;
        int d;

        public node(int v, int d) {
            this.v = v;
            this.d = d;
        }

        @Override
        public int compareTo(node o) {
            return this.d - o.d;
        }
    }

    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static ArrayList<node>[] graph;
    static int[] dist;
    static int[] prev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("Case #" + t + ": ");
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            graph = new ArrayList[m];
            dist = new int[m];
            prev = new int[m];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[0] = 0;
            for (int i = 0; i < m; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                graph[x].add(new node(y, z));
                graph[y].add(new node(x, z));
            }
            dijkstra(0);
            if (dist[m - 1] == Integer.MAX_VALUE) {
                sb.append(-1 + "\n");
            } else {
                Stack<Integer> stack = new Stack<>();
                for (int i = m - 1; i != 0; i = prev[i]) {
                    stack.push(prev[i]);
                }
                while (!stack.isEmpty()) {
                    sb.append(stack.pop()).append(" ");
                }
                sb.append(m - 1).append("\n");
            }

        }
        System.out.println(sb);


    }

    static void dijkstra(int start) {
        PriorityQueue<node> pq = new PriorityQueue<>();
        pq.offer(new node(start, 0));
        while (!pq.isEmpty()) {
            node now = pq.poll();
            int nv = now.v;
            int nd = now.d;
            if (dist[nv] < nd) {
                continue;
            }
            for (var t : graph[nv]) {
                if (dist[t.v] > nd + t.d) {
                    dist[t.v] = nd + t.d;
                    pq.offer(new node(t.v, dist[t.v]));
                    prev[t.v] = nv;
                }
            }

        }
    }

}