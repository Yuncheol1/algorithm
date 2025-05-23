import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<int[]> home = new ArrayList<>();
    static ArrayList<int[]> chicken = new ArrayList<>();
    static int[][] ans;
    static int min = 10000000;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = new int[m][2];
        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    home.add(new int[]{i, j});
                } else if (x == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }
        dfs(m, 0,0);
        System.out.print(min);
    }

    static void dfs(int m, int depth,int start) {
        if (depth == m) {
            int a = chickenRoad();
            min = Math.min(min, a);
            return;
        }
        if(start>=chicken.size())return;
        for (int i = start; i < chicken.size(); i++) {
                ans[depth][0] = chicken.get(i)[0];
                ans[depth][1] = chicken.get(i)[1];
                dfs(m, depth + 1,i+1);
        }
    }

    static int chickenRoad() {
        int cnt = 0;
        for (var t : home) {
            int distance = 100000000;
            for (int k = 0; k < m; k++) {
                distance = Math.min(distance, (Math.abs(ans[k][0] - t[0]) + Math.abs(ans[k][1] - t[1])));
            }
            cnt += distance;
        }
        return cnt;
    }
}
