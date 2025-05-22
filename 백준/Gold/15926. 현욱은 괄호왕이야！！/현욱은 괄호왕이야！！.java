import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] f = new boolean[n];
        String str = br.readLine();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '(') {
                st.push(i);
            } else {
                if (!st.isEmpty()) {
                    int a = st.pop();
                    f[a] = true;
                    f[i] = true;
                }
            }
        }
        int max = 0;
        int cnt = 0;
        for (var t : f) {
            if (t) {
                cnt++;
            }
            if (!t) {
                max = Math.max(max, cnt);
                cnt = 0;
            }
        }
        max=Math.max(max,cnt);
        System.out.print(max);

    }
}
