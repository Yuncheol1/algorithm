import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        if (n == 1 || n == 2) {
            System.out.println(2);
            return;
        }
        if (n % 2 == 0) {
            n++;
        }
        for (int i = n; i <= b; i += 2) {
            int j;
            boolean check = true;
            String str = Integer.toString(i);
            int left = 0;
            int right = str.length() - 1;

            while (left < right) {
                if (str.charAt(left) != str.charAt(right)) {
                    check = false;
                    break;
                } else {
                    left++;
                    right--;
                }
            }

            if (check) {
                boolean check2 = true;
                for (j = 2; j <= (int) Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        check2 = false;
                        break;
                    }
                }
                if (check2) {
                    System.out.println(i);

                }
            }
        }
        System.out.println(-1);
    }
}