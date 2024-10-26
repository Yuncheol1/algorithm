import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int j = 1;
        while (true) {
            int cnt = 0;
            String str = sc.next();
            Stack<Character> s = new Stack<>();
            if (str.contains("-")) {
                return;
            }
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '{') {
                    s.push(c);
                } else {
                    if (s.isEmpty()) {
                        s.push('{');
                        cnt++;
                    } else if (s.peek() == '{') {
                        s.pop();
                    }
                }
            }
            System.out.println(j + ". " + ((s.size()/2)+cnt));
            j++;
        }
    }
}