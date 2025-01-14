import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = Math.abs(n - 100);
        boolean[] button = new boolean[10];
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            button[sc.nextInt()] = true;
        }
        for (int i = 0; i <= 999999; i++) {
            String now = String.valueOf(i);
            boolean check = true;
            for (int j = 0; j < now.length(); j++) {
                if (button[now.charAt(j) - '0']) {
                    check = false;
                    break;
                }
            }
            if (check) {
                int res = Math.abs(n - i) + now.length();
                ans = Math.min(ans, res);
            }
        }
        System.out.print(ans);

    }
}