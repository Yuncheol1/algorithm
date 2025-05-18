import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= 'a' && ch[i] <= 'z') {
                ch[i] = (char) ((ch[i] - 'a' + 13) % 26 + 'a');
            } else if (ch[i] >= 'A' && ch[i] <= 'Z') {
                ch[i] = (char) ((ch[i] - 'A' + 13) % 26 + 'A');
            }
        }
        System.out.println(new String(ch));


    }
}