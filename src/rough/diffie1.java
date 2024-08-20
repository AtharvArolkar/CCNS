package rough;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class diffie1 {
    public static void main(String[] args) {
        try{
            Scanner sc=new Scanner(System.in);
            ServerSocket serverSocket=new ServerSocket(8888);
            System.out.println("Server created");
            Socket server=serverSocket.accept();
            DataOutputStream out=new DataOutputStream((server.getOutputStream()));
            DataInputStream in=new DataInputStream((server.getInputStream()));

            System.out.println("Enter the private key(xa)");
            int xa=sc.nextInt();
            int q=Integer.parseInt(in.readUTF());
            int alpha=Integer.parseInt(in.readUTF());
            double yb=Double.parseDouble(in.readUTF());
            double ya= Math.pow(alpha,xa)%q;
            out.writeUTF(Double.toString(ya));
            double key=Math.pow(yb,xa)%q;
            System.out.println("Key Generated:"+key);
            server.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
