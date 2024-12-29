import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[] x = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            x[i] = sc.nextInt();
            sum += x[i];
        }
        Arrays.sort(x);
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - (x[i] + x[j]) == 100) {
                    for (int s = 0; s < 9; s++) {
                        if (s != i && s != j) {
                            System.out.println(x[s]);
                        }
                    }
                    return;
                }
            }
        }
    }
}




