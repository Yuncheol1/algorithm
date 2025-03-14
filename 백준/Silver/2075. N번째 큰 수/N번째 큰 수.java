import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
PriorityQueue<Integer> pq=new PriorityQueue<>((o1,o2) -> {return o2-o1;});
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
for(int i=0;i<n*n;i++){
    pq.add(sc.nextInt());
}
for(int i=0;i<n-1;i++)pq.poll();
System.out.println(pq.poll());

    }
}