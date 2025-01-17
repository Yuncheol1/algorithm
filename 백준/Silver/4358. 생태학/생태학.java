import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> tree = new TreeMap<>();
        String input;
        while (true) {
            input = br.readLine();
            if (input == null || input.length() == 0) {
                break;
            }
            if (tree.containsKey(input)) {
                tree.put(input, tree.get(input) + 1);
            } else {
                tree.put(input, 1);
            }
        }
        int total = 0;
        for (var i : tree.values()) {
            total += i;
        }
        //    System.out.println("total = " + total);
        for (var i : tree.entrySet()) {
            double percent = ((double) i.getValue() / total) * 100;
            System.out.printf("%s %.4f\n", i.getKey(), percent);
        }
    }
}