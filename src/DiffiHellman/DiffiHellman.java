package DiffiHellman;

import java.util.Scanner;

public class DiffiHellman {
    public static void main(String[] args) {
        int n,a,Xa,Xb,Ya,Yb;
        Scanner sc =new Scanner(System.in);
        System.out.print("n=");
        n=sc.nextInt();
        System.out.print("alpha=");
        a=sc.nextInt();
        System.out.print("Enter Key for user A:");
        Xa=sc.nextInt();
        System.out.print("Enter Key for user B:");
        Ya=sc.nextInt();
        Xb=getKey(Xa,a,n);
        Yb=getKey(Ya,a,n);
        int Ka=getKey(Xa,Yb,n);
        int Kb=getKey(Ya,Xb,n);
        System.out.println("The Key For A is :"+Ka);
        System.out.println("The Key For B is :"+Kb);
    }

    private static int getKey(int key, int a, int n) {
        return (int) (Math.pow(a,key)%n);
    }
}
