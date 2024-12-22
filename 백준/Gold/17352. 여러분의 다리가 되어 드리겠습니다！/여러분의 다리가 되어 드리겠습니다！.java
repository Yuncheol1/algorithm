import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        //연결된 섬
        for (int i = 0; i < N - 2; i++) {
            st = new StringTokenizer(br.readLine());
            union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (find(i) == i) {
                System.out.print(i + " ");
            }
        }
    }

    static void union(int a, int b) {
        int ar = find(a);
        int br = find(b);

        if (ar == br) {
            return;
        }

        parents[br] = ar;
    }

    static int find(int a) {
        if (parents[a] == a) {
            return a;
        }

        return parents[a] = find(parents[a]);
    }
}