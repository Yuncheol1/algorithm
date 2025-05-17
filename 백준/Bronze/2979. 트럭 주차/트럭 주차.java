import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int[] x = new int[101];
        int a1 = sc.nextInt();
        int a2 = sc.nextInt();
        int b1 = sc.nextInt();
        int b2 = sc.nextInt();
        int c1 = sc.nextInt();
        int c2 = sc.nextInt();
        x[a1] += 1;
        x[a2] += -1;
        x[b1] += 1;
        x[b2] += -1;
        x[c1] += 1;
        x[c2] += -1;
        int cnt = 0;
        int ans = 0;
        int max = Math.max(a2, Math.max(b2, c2));
        for (int i = 1; i <= max; i++) {
            cnt += x[i];
            if (cnt == 1) {
                ans += A;
            }
            if (cnt == 2) {
                ans += (B*2);
            }
            if (cnt == 3) {
                ans += (C*3);
            }

        }

        System.out.print(ans);

    }
}