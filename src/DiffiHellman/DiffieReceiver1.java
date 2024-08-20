
package DiffiHellman;
import java.lang.*;
import java.util.*;
import java.net.Socket;
import java.io.*;

class DeffieReceive1{
    public static void main(String args[]){
        try{
            Scanner scanner = new Scanner(System.in);

            String serverName = "localhost";
            int port = 8088;

            System.out.println("Connecting to " + serverName + " at port: " + port);

            Socket client = new Socket(serverName, port);
            System.out.println("Connected to " + client.getRemoteSocketAddress());

            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            DataInputStream in = new DataInputStream(client.getInputStream());

            System.out.print("Client: Enter Xb: ");
            int xb = scanner.nextInt();

            System.out.print("Client: Enter q: ");
            int q = scanner.nextInt();
            out.writeUTF(Integer.toString(q));

            System.out.print("Client: Enter alpha: ");
            int alpha = scanner.nextInt();
            out.writeUTF(Integer.toString(alpha));

            double yb = Math.pow(alpha, xb) % q;
            out.writeUTF(Double.toString(yb));


            double ya = Double.parseDouble(in.readUTF());

            System.out.println("Server Public Key: " + ya);

            double k2 = Math.pow(ya, xb) % q;

            System.out.println("Secret key to perform encryption: " + k2);
            client.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
