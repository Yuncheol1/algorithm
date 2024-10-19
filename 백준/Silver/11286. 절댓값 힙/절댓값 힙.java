//package homework;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
PriorityQueue<Integer> pq=new PriorityQueue<>((o1,o2)->{
	int first_abs=Math.abs(o1);
	int second_abs=Math.abs(o2);
	if(first_abs==second_abs) 
		return o1>o2?1:-1;
	else 
		return first_abs-second_abs;	
});

int n;
int input;
BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
n=Integer.parseInt(br.readLine());
for(int i=0;i<n;i++) {
	input=Integer.parseInt(br.readLine());
	if(input==0) {
		if(pq.isEmpty())System.out.println(0);
		else System.out.println(pq.poll());	 
	}
	else pq.add(input);
	
}



		
	}
}
