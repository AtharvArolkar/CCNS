package practice;

import java.math.BigInteger;
import java.util.Scanner;

public class rsa {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter p");
        int p=sc.nextInt();
        System.out.println("Enter q");
        int q=sc.nextInt();
        System.out.println("Enter the e");
        int e=sc.nextInt();
        System.out.println("Enter the message:");
        int m=sc.nextInt();
        int n=p*q;
        int piN=(p-1)*(q-1);
        int d=getD(piN,e);
        System.out.println("d"+d);
        BigInteger M=BigInteger.valueOf(m);
        BigInteger C=M.pow(e).mod(BigInteger.valueOf(n));
        System.out.println("Encrypt:"+C);
        System.out.println("Decrypt:"+C.pow(d).mod(BigInteger.valueOf(n)));
    }
    public static int getD(int piN,int e){
        int[] arr=new int[]{1,0,piN,0,1,e};
        while(arr[5]!=1){
            int[] mat=new int[arr.length];
            int n=arr[2]/arr[5];
            mat[0]=arr[3];
            mat[1]=arr[4];
            mat[2]=arr[5];
            mat[3]=arr[0]-(n*arr[3]);
            mat[4]=arr[1]-(n*arr[4]);
            mat[5]=arr[2]-(n*arr[5]);
            System.out.println(n);
            arr=mat;
        }
        int d=arr[4];
        if(d<0)d=d+piN;
        return d;
    }
}
