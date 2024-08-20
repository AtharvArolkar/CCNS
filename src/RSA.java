import java.math.BigInteger;
import java.util.Scanner;

public class RSA {
    public static void main(String[] args) {
        int p,q,e,M,C;
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter p and q");
        System.out.print("p=");
        p=sc.nextInt();
        System.out.print("q=");
        q=sc.nextInt();
        System.out.print("e=");
        e=sc.nextInt();
        System.out.print("message=");
        M=sc.nextInt();
        int n=p*q;
        int piN=(p-1)*(q-1);
        RSA rsa=new RSA();
        int  d=rsa.getD(piN,e);
        System.out.println("d:"+d);
        if(d<0){d=d+piN;}
        BigInteger encrypt=BigInteger.valueOf(M);
        encrypt=encrypt.pow(e).mod(BigInteger.valueOf(n));
        System.out.println("Encrypted Text is:"+encrypt);
        BigInteger decrypt = encrypt.pow(d).mod(BigInteger.valueOf(n));
        System.out.println("Decrypted Text is:"+decrypt);
    }
    public int getD(int piN,int e){
        int[] gcd=new int[]{1,0,piN,0,1,e};
        System.out.printf("%5s |%5s |%5s |%5s |%5s |%5s |%5s |","n","a1","a2","a3","b1","b2","b3");
        System.out.println();
        for(int i=0;i<50;i++){
            System.out.print("-");
        }
        System.out.println();
        System.out.printf("%5d |%5d |%5d |%5d |%5d |%5d |%5d |",gcd[2]/gcd[5],gcd[0],gcd[1],gcd[2],gcd[3],gcd[4],
                gcd[5]);
        System.out.println();
        while(gcd[5]!=1){
            int[] arr=new int[gcd.length];
            int n=gcd[2]/gcd[5];
            arr[0]=gcd[3];
            arr[1]=gcd[4];
            arr[2]=gcd[5];
            arr[3]=gcd[0]-(n*gcd[3]);
            arr[4]=gcd[1]-(n*gcd[4]);
            arr[5]=gcd[2]-(n*gcd[5]);
//            System.out.println(n+"|"+arr[0]+"|"+arr[1]+"|"+arr[2]+"|"+arr[3]+"|"+arr[4]+"|"+arr[5]+"|");
            System.out.printf("%5d |%5d |%5d |%5d |%5d |%5d |%5d |",arr[2]/arr[5],arr[0],arr[1],arr[2],arr[3],arr[4],
                    arr[5]);
            System.out.println();
            gcd=arr;
        }
        return gcd[4];
    }
}
