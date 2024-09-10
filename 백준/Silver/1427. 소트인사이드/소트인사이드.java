//package algorithm;
import java.io.*;
import java.util.*;
import java.util.Scanner;
public class Main {
  public static  void selectionsort(int[] x, int n){
int max=x[0];
int maxidx=0;
int tmp;
while(n>0){
    for(int i=0;i<n;i++){
        if(max>x[i]){
            max=x[i];
            maxidx=i;
        }
    }
    tmp=x[n-1];
    x[n-1]=max;
    x[maxidx]=tmp;
    max=x[0];
    maxidx=0;
    n--;
}
    }
    public static void main(String[] args) throws IOException {
     Scanner sc=new Scanner(System.in);
 String str=sc.next();
 int[] x =new int[str.length()];
 for(int i=0;i<x.length;i++){
     x[i]=Integer.parseInt(str.substring(i,i+1));
 }
selectionsort(x,str.length());
for(int i=0;i<x.length;i++)System.out.print(x[i]);
 }
}