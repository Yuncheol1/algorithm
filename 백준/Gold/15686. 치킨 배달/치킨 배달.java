import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<int[]> home = new ArrayList<>();
    static ArrayList<int[]> chicken = new ArrayList<>();
    static int[][] ans;
    static boolean visited[];
    static int min = 10000000;
    static int m;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        m = sc.nextInt();
        ans = new int[m][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                if (x == 1) {
                    home.add(new int[]{i, j});
                } else if (x == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }
        visited = new boolean[chicken.size()];
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
            if (!visited[i]) {
                ans[depth][0] = chicken.get(i)[0];
                ans[depth][1] = chicken.get(i)[1];
                visited[i] = true;
                dfs(m, depth + 1,i+1);
                visited[i] = false;
            }
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
