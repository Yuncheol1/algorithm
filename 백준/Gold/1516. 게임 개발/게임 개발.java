/*
위상정렬 : 그래프에 포함된 노드들을 방향성을 거스르지 않으면서 일렬로 나열하는 방법
먼저, 각노드의 진입차수를 저장하는 배열을 설정한다.
그다음, 진입차수가 0(시작점)노드를 정렬 배열에 넣고 선택된 노드가 가리키는 노드들의 진입차수를 1씩뺀다.
위의 과정을 모든 노드가 정렬될때까지 반복
선후관계가 명확한 작업등에 사용된다. ex) a과목을 듣기 전에 b과목을 들어야 한다.
 */

import java.nio.Buffer;
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n=Integer.parseInt(br.readLine());
        int[]x=new int[n+1];
        ArrayList<Integer>[]y=new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            y[i]=new ArrayList<>();
        }
        int[] indegree=new int[n+1];
        for(int i=1;i<=n;i++){
           st=new StringTokenizer(br.readLine());
           x[i]=Integer.parseInt(st.nextToken());
           while(st.hasMoreTokens()){
                int tmp=Integer.parseInt(st.nextToken());
                if(tmp!=-1){
                    y[tmp].add(i);
                    indegree[i]++;
                }
           }
        }

        ArrayDeque<Integer>q=new ArrayDeque<>();
        for(int i=1;i<=n;i++)if(indegree[i]==0)q.offer(i);
        int[]res=new int[n+1];
        while(!q.isEmpty()){
            int now=q.poll();
            for(int i=0;i<y[now].size();i++){
                indegree[y[now].get(i)]--;
                res[y[now].get(i)]=Math.max(res[y[now].get(i)],res[now]+x[now]);
                if(indegree[y[now].get(i)]==0){
                    q.offer(y[now].get(i));

                }
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.println(res[i]+x[i]);
        }


    }

}