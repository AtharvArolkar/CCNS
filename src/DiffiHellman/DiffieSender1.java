package DiffiHellman;
import java.lang.*;
import java.util.*;
import java.io.*;
import java.net.*;

class DiffieSender1{
    public static void main(String args[]){
        try{
            Scanner scanner = new Scanner(System.in);

            int port = 8088;

            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Waiting for client on port: " + serverSocket.getLocalPort());


            Socket server = serverSocket.accept();
            System.out.println("Connected to " + server.getRemoteSocketAddress());

            System.out.print("Server: Enter Xa: ");
            int xa = scanner.nextInt();

            DataInputStream in = new DataInputStream(server.getInputStream());
            DataOutputStream out = new DataOutputStream(server.getOutputStream());

            int q = Integer.parseInt(in.readUTF());
            System.out.println("Client: q is " + q);

            int alpha = Integer.parseInt(in.readUTF());
            System.out.println("Client: alpha is " + alpha);

            double yb = Double.parseDouble(in.readUTF());
            System.out.println("Client: Public Key yb is " + yb);

            double ya = Math.pow(alpha, xa) % q;
            out.writeUTF(Double.toString(ya));

            double k1 = Math.pow(yb, xa) % q;
            System.out.println("Secret key is: " + k1);
            server.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}