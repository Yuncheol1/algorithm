import java.util.*;
import java.io.*;
/*
전형적인 dfs문제.
인접리스트로 관계를 표현후에 dfs
 */
public class Main {
    static boolean arrive=false;
    static boolean[]visited;
    static ArrayList<Integer>[] camp;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        camp=new ArrayList[n];
        visited=new boolean[n];
        for(int i=0;i<n;i++)camp[i]=new ArrayList<>();
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            camp[a].add(b);
            camp[b].add(a);
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
                 dfs(i,1);
                if (arrive) {
                    System.out.println(1);
                    return;
                }
            }
        }
        System.out.println(0);

    }
    static void dfs(int i,int depth){
        if(depth==5||arrive) {
        arrive=true;
            return ;

        }visited[i]=true;
        for(int j=0;j<camp[i].size();j++){
            if(!visited[camp[i].get(j)]){
                dfs(camp[i].get(j),depth+1);
            }

        }

        visited[i]=false;
    }
}
