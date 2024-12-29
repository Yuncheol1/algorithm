import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] ans;

    static void union(int a, int b) {
        int A = find(a);
        int B = find(b);
        if (A < B) {
            ans[B] = A;
        } else if (A > B) {
            ans[A] = B;
        }
    }

    static int find(int a) {
        if (a == ans[a]) {
            return a;
        } else {
            return ans[a] = find(ans[a]);
        }
    }

    static boolean checksame(int a, int b) {
        int A = find(a);
        int B = find(b);
        if (A == B) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (q == 0) {
                union(a, b);
            } else {
                if (checksame(a, b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }

    }
}




