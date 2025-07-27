import java.io.*;
import java.util.*;
/*
 * 반드시 지나야하는 정점이 a,b라고하면
 * 어디를 먼저 지나야하는지 판단
 * 
 */
class node{
	int v;
	int w;
	public node(int v,int w) {
		this.v=v;
		this.w=w;
	}
}
public class Main {
		static int n,e;
		static ArrayList<node>[]graph;
		static boolean[]visited;
		static int[]dist;
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		 n=Integer.parseInt(st.nextToken());
		 e=Integer.parseInt(st.nextToken());
		graph=new ArrayList[n+1];
		for(int i=0;i<=n;i++)graph[i]=new ArrayList<>();
		for(int i=0;i<e;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			graph[a].add(new node(b,c));
			graph[b].add(new node(a,c));
		}
		st=new StringTokenizer(br.readLine());
		int v1=Integer.parseInt(st.nextToken());
		int v2=Integer.parseInt(st.nextToken());
		
		int a=dijkstra(1,v1);
		int c=dijkstra(v1,v2);
		int d=dijkstra(v2,n);
		int b=dijkstra(1,v2);
		int e=dijkstra(v2,v1);
		int s=dijkstra(v1,n);
		int ans=Math.min((a+c+d), (b+e+s));
		if(ans>2000000000||ans<-2000000000)System.out.println(-1);
		else System.out.println(ans);
	}
	static int dijkstra(int start,int end) {
		PriorityQueue<node>q=new PriorityQueue<>((o1,o2)->{
	        return o1.w-o2.w;
	    });
		visited=new boolean[n+1];
		dist=new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start]=0;
		q.offer(new node(start,0));
		while(!q.isEmpty()) {
			node now=q.poll();
			if(visited[now.v])continue;
			visited[now.v]=true;
			for(node t:graph[now.v]) {
				dist[t.v]=Math.min(dist[t.v], dist[now.v]+t.w);
				q.offer(new node(t.v,dist[t.v]));
			}
		}
		return dist[end];
		
	}
	

}
