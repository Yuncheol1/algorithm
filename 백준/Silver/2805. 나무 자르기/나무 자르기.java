import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int min = 0;
        int max = 0;
        int[] tree = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, tree[i]);
        }
        Arrays.sort(tree);
        while (min <= max) {
            long sum = 0;
            int mid = (min + max) / 2;
            for (int i = 0; i < n; i++) {
                if (tree[i] - mid > 0) {
                    sum += tree[i] - mid;
                }
            }
            if (sum >= m) {
                min = mid + 1;
            } else if (sum < m) {
                max = mid - 1;
            }
        }
        System.out.println(max);

    }
}