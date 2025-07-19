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
    static int findnode=1;
    static int ans=0;
    static ArrayList<node>[]tree;
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
        for(int i=0;i<n;i++){
            String[]input=br.readLine().split(" ");
            for(int j=1;j<input.length;j+=2){
                if(Integer.parseInt(input[j])==-1||Integer.parseInt(input[j+1])==-1)break;
                tree[Integer.parseInt(input[0])].add(new node(Integer.parseInt(input[j]),Integer.parseInt(input[j+1])));
            }
        }
        dfs(1,0,1);
        Arrays.fill(visited,false);
        dfs(findnode,0,findnode);
        System.out.println(ans);



    }
    static void dfs(int start,int sum,int now){
        if(tree[start].size()==1&&start!=now){//루트노드와 연결된 노드가 한개인예외 처리
            if(ans<sum){
                ans=sum;
                findnode=start;
            }
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


}
/*
4
1 2 1
2 3 100
2 4 100
 */