import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }
        for (int i = n - 1; i >= 0; i--) {
            ans.add(input[i], i + 1);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}