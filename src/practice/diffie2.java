package practice;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class diffie2 {
    public static void main(String[] args) {
        try{
            Scanner sc=new Scanner(System.in);
            Socket client=new Socket("localhost",8888);
            System.out.println("Connected");

            DataOutputStream out=new DataOutputStream(client.getOutputStream());
            DataInputStream in =new DataInputStream(client.getInputStream());
            System.out.println("Enter private key xb");
            int xb=sc.nextInt();

            System.out.println("Enter q");
            int q=sc.nextInt();
            out.writeUTF(Integer.toString(q));
            System.out.println("Enter alpha");
            int alpha=sc.nextInt();
            out.writeUTF(Integer.toString(alpha));

            double yb=Math.pow(alpha,xb)%q;
            out.writeUTF(Double.toString(yb));

            double ya=Double.parseDouble(in.readUTF());

            double key=Math.pow(ya,xb)%q;
            System.out.println("Key Generated:"+key);
            client.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
