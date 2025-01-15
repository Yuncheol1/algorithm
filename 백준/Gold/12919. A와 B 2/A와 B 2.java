import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String S;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        String T = br.readLine();
        dfs(T);
        if (ans == 0) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }

    static void dfs(String t) {
        if (S.length() == t.length()) {
            if (S.equals(t)) {
                ans++;
            }
            return;
        }
        if (t.endsWith("A")) {
            dfs(t.substring(0, t.length() - 1));
        }
        if (t.startsWith("B")) {
            dfs(new StringBuilder(t.substring(1)).reverse().toString());
        }
    }
}