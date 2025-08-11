import java.io.*;
import java.util.*;
/*
 *위상정렬 문제
 *먼저 건설되어야 할 건물중에 건설시간이 가장 늦은 건물기준으로 정답배열 업데이트
 */

public class Main {
			static int w;
			static int[]res;//정답배열
			static int[]indegree;//진입차수배열
			static int[]dist;//소요시간배열
			static ArrayList<Integer>[]craft;//그래프
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int asdf=0;asdf<T;asdf++) {
			st=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			int k=Integer.parseInt(st.nextToken());
			dist=new int[n+1];
			indegree=new int[n+1];
			res=new int[n+1];
			craft=new ArrayList[n+1];
			for(int i=0;i<=n;i++) {
				craft[i]=new ArrayList<>();
			}
			st=new StringTokenizer(br.readLine());
			for(int i=1;i<=n;i++) {
				dist[i]=Integer.parseInt(st.nextToken());
			}
			for(int i=0;i<=k;i++) {
				String[]input=br.readLine().split(" ");
				if(input.length==2) {
					int x=Integer.parseInt(input[0]);
					int y=Integer.parseInt(input[1]);
					craft[x].add(y);
					indegree[y]++;
				}
				else w=Integer.parseInt(input[0]);
			}
			
			ArrayDeque<Integer>q=new ArrayDeque<>();
			for(int i=1;i<=n;i++) {
					if(indegree[i]==0)q.offer(i);
				}
			while(!q.isEmpty()) {
				int now=q.poll();
				for(int i=0;i<craft[now].size();i++) {
					res[craft[now].get(i)]=Math.max(res[craft[now].get(i)],res[now]+dist[now]);
					indegree[craft[now].get(i)]--;
					if(indegree[craft[now].get(i)]==0) {
						q.offer(craft[now].get(i));
					}
				}
				
			}
			System.out.println(res[w]+dist[w]);
		//end	
		}
		
		
	}

}
