import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    long B;
    long depth;

    Node(long B, long depth) {
        this.B = B;
        this.depth = depth;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(A, 0));
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.B == B) {
                System.out.println(node.depth + 1);
                return;
            }
            if (node.B * 2 <= B) {
                q.add(new Node(node.B * 2, node.depth + 1));
            }
            if (node.B * 10 + 1 <= B) {
                q.add(new Node(node.B * 10 + 1, node.depth + 1));
            }
        }
        System.out.print(-1);
    }


}