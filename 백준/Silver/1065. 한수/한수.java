import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (i < 100) {
                cnt++;
                continue;
            }
            String str = String.valueOf(i);
            int[] x = new int[str.length()];
            for (int j = 0; j < x.length; j++) {
                x[j] = str.charAt(j) - '0';
            }
            int diff = x[1] - x[0];
            boolean check = true;
            for (int j = 2; j < x.length; j++) {
                if (x[j] - x[j - 1] != diff) {
                    check = false;
                    break;
                }
            }
            if (check) {
                cnt++;
            }

        }
        System.out.println(cnt);
    }
}