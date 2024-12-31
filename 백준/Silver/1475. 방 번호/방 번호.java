import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        int[] x = new int[10];
        for (int i = 0; i < n.length(); i++) {
            int a = n.charAt(i) - '0';
            if (a == 9) {
                x[6]++;
            } else {
                x[a]++;
            }
        }
        if (x[6] % 2 == 0) {
            x[6] = x[6] / 2;
        } else {
            x[6] = x[6] / 2 + 1;
        }
        int max = Arrays.stream(x).max().getAsInt();
        System.out.print(max);
    }
}




