import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int[]room;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int q=Integer.parseInt(st.nextToken());
		room=new int[n];
		int[][]info=new int[5001][3];
		String order;
		int a,b;
		int idx=1;
		for(int asdf=0;asdf<q;asdf++) {
			st=new StringTokenizer(br.readLine());
			order=st.nextToken();
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			if(order.equals("new")) {
				//연속된 b개의 빈공간이 있는지 왼쪽부터 찾은후, 
				//있으면 최초발견한곳에 a넣고 방정보 입력
				//배열 다돌때까지 없으면 REJECTED출력
				int cnt=0;
				boolean check=false;
				for(int i=0;i<n;i++) {
					if(room[i]==0)cnt++;
					else cnt=0;
					if(cnt==b) {
						check=true;
						for(int k=i-b+1;k<=i;k++) {
							room[k]=a;
						}
						info[idx][0]=i-cnt+1;
						info[idx][1]=i;
						info[idx][2]+=a;
						idx++;
						System.out.println(i-cnt+2 +" "+(i+1));
						break;
					}
				}
				if(!check)System.out.println("REJECTED");
			}
			
			else if(order.equals("in")) {
				for(int i=info[a][0];i<=info[a][1];i++) {
					room[i]+=b;
				}
				
			}
			
			else if(order.equals("out")) {
				boolean flag=false;
				for(int i=info[a][0];i<=info[a][1];i++) {
					room[i]-=b;
					if(room[i]==0)flag=true;
				}
				if(flag) {
					System.out.println("CLEAN"+" "+(info[a][0]+1)+" "+(info[a][1]+1));
				}
			}
			/*for(int i=0;i<n;i++)System.out.print(room[i]+" ");
			System.out.println();*/
		}
		
		
		
		
		
		

	}

}
