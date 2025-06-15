import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int s = sc.nextInt();
            sum += s * s;
        }
        System.out.print(sum % 10);
    }
}
