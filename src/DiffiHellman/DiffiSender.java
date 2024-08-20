package DiffiHellman;

import java.net.*;
import java.io.*;
import java.util.Scanner;
public class DiffiSender {
    public static void main(String[] args) throws IOException {
        try {
            int port = 8088;
            int a;
            double q, alpha, yb, A, Adash;
            String Bstr;
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
            Socket server = serverSocket.accept();
            System.out.println("Just connected to " + server.getRemoteSocketAddress());
            System.out.println("From Server : Enter Server Private Key Xa = ");
            Scanner xa = new Scanner(System.in);
            a = xa.nextInt();
            DataInputStream in = new DataInputStream(server.getInputStream());
            q = Integer.parseInt(in.readUTF());
            System.out.println("From Client : Enter q = ");
            Scanner sq = new Scanner(System.in);
            q = sq.nextInt();
            alpha = Integer.parseInt(in.readUTF()); // to accept g
            System.out.println("From Client : Enter alpha = ");
            Scanner alp = new Scanner(System.in);
            alpha = alp.nextInt();
            yb = Double.parseDouble(in.readUTF()); // to accept A
            System.out.println("From Client : Client Public Key Yb= " + yb);
            A = ((Math.pow(alpha, a)) % q); // calculation of B
            Bstr = Double.toString(A);
            OutputStream outToclient = server.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToclient);
            out.writeUTF(Bstr); // Sending B
            Adash = ((Math.pow(yb, a)) % q); // calculation of Bdash
            System.out.println("Secret Key to perform Symmetric Encryption = " + Adash);
            server.close();
        } catch (SocketTimeoutException s) {
            System.out.println("Socket timed out!");
        } catch (IOException e) {
        }
    }
}

