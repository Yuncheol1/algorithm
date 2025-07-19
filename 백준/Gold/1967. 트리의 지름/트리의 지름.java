/*
dfs문제
트리의 특징에 대해서 생각해보자.
가장 긴 길이가 되려면 리프노드에서 리프노드까지 가야 한다.
그외에는 지름이 나올수없음.
리프노드를 구한후에, 리프노드에서만 dfs를 출발하자.
*/
import java.util.*;
import java.io.*;
class node{
    int v;
    int w;
    public node(int v,int w){
        this.v=v;
        this.w=w;
    }

}
public class Main {
    static int ans=0;
    static ArrayList<node>[]tree;
    static ArrayList<Integer>leaf=new ArrayList<>();
    static boolean[]visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n=Integer.parseInt(br.readLine());
        if(n==1){
            System.out.println(0);
            return;
        }
        tree=new ArrayList[n+1];
        visited=new boolean[n+1];
        for(int i=0;i<n+1;i++)tree[i]=new ArrayList<>();
        for(int i=0;i<n-1;i++){
            st=new StringTokenizer(br.readLine());
            int p=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            tree[p].add(new node(c,w));
            tree[c].add(new node(p,w));
        }
        bfs(1);

        for(int now:leaf){
            Arrays.fill(visited,false);
            dfs(now,0,now);
        }
        System.out.println(ans);





    }
    static void dfs(int start,int sum,int now){
        if(tree[start].size()==1&&start!=now){//루트노드와 연결된 노드가 한개인예외 처리
            ans=Math.max(ans,sum);
            visited[start]=true;
            return;
        }
        visited[start]=true;
        for(int i=0;i<tree[start].size();i++){
            if(!visited[tree[start].get(i).v]){
                dfs(tree[start].get(i).v,sum+tree[start].get(i).w,now);
            }
        }


    }
    static void bfs(int start){
        visited[start]=true;
        ArrayDeque<Integer>q=new ArrayDeque<>();
        q.offer(start);
        while(!q.isEmpty()){
            int now=q.poll();
            if(tree[now].size()==1&&now!=1){
                leaf.add(now);
                visited[now]=true;
                continue;
            }
            for(int i=0;i<tree[now].size();i++){
                if(!visited[tree[now].get(i).v]){
                    q.offer(tree[now].get(i).v);
                    visited[tree[now].get(i).v]=true;
                }
            }
        }
    }

}
/*
4
1 2 1
2 3 100
2 4 1004
1 2 1
2 3 100
2 4 100
 */