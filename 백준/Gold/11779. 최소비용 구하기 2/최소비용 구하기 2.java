//package boj;

import java.util.*;
import java.io.*;

class Nodes {
	int v, w;

	public Nodes(int v, int w) {
		this.v = v;
		this.w = w;
	}
}

public class Main {
	static int start,end;
	static ArrayList<Nodes>[] graph;
	static int[] distance;
	static int[]prev;
	static ArrayList<Integer>ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ArrayList<Integer>arr=new ArrayList<>();
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		graph = new ArrayList[n + 1];
		prev=new int[n+1];
		Arrays.fill(prev, -1);
		distance = new int[n + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
			}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[s].add(new Nodes(e, w));// 단방향이구나...
		}

		st = new StringTokenizer(br.readLine());
	    start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		if(start==end) {
			System.out.println(0);
			System.out.println(1);
			System.out.println(start);
		return;
		}
		distance[start] = 0;
		dijkstra(start);
		System.out.println(distance[end]);
		Stack<Integer> route = new Stack<>();
		int cur = end;
		while (cur != -1) {
		    route.push(cur);
		    cur = prev[cur];
		}
		System.out.println(route.size());
		while (!route.isEmpty()) System.out.print(route.pop() + " ");
		
	}

	static void dijkstra(int start) {
		PriorityQueue<Nodes> q = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		q.offer(new Nodes(start, 0));
		while (!q.isEmpty()) {
			Nodes now = q.poll();
			if (distance[now.v] < now.w)
				continue;
			for (var t : graph[now.v]) {
				if (distance[t.v] > distance[now.v] + t.w) {
					distance[t.v] = distance[now.v] + t.w;
					q.offer(new Nodes(t.v, distance[t.v]));
					prev[t.v]=now.v;
				}
			}
		}
	}
	
	
}
