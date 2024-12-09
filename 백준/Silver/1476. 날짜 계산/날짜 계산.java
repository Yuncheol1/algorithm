import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int e, s, m;
        int a = 0;
        int b = 0;
        int c = 0;
        e = sc.nextInt();
        s = sc.nextInt();
        m = sc.nextInt();
        int cnt = 0;
        while (a != e || b != s || c != m) {
            a++;
            b++;
            c++;
            cnt++;
            if (a > 15) {
                a = 1;
            }
            if (b > 28) {
                b = 1;
            }
            if (c > 19) {
                c = 1;
            }

        }
        System.out.println(cnt);
    }
}