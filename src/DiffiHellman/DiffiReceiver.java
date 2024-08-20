package DiffiHellman;

import java.net.*;
import java.io.*;
import java.util.Scanner;
public class DiffiReceiver {
    public static void main(String[] args) {
        try {
            String pstr, gstr, Astr;
            String serverName = "localhost";
            int port = 8088;
            int q;
            int alpha;
            int b;
            double Bdash, ya;
            System.out.println("Connecting to " + serverName + " on port " + port);
            Socket client = new Socket(serverName, port);
            System.out.println("Just connected to " + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            System.out.println("From Client : Enter Client Private Key Xb = ");
            Scanner xb = new Scanner(System.in);
            b = xb.nextInt();
            DataInputStream in = new DataInputStream(client.getInputStream());
            System.out.println("From Client : Enter q = ");
            Scanner sq = new Scanner(System.in);
            q = sq.nextInt();
            pstr = Integer.toString(q);
            out.writeUTF(pstr);
            System.out.println("From Client : Enter alpha = ");
            Scanner alp = new Scanner(System.in);
            alpha = alp.nextInt();
            gstr = Integer.toString(alpha);
            out.writeUTF(gstr);
            double A = ((Math.pow(alpha, b)) % q);
            Astr = Double.toString(A);
            out.writeUTF(Astr);
            ya = Double.parseDouble(in.readUTF());
            System.out.println("From Server : Server Public Key Ya= " + ya);
            Bdash = ((Math.pow(ya, b)) % q); // calculation of Adash
            System.out.println("Secret Key to perform Symmetric Encryption = " + Bdash);
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
