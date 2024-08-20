package practice;

import java.util.Scanner;

public class Caeser {
    public static void main(String[] args) {
        System.out.println("Enter the plaintext:");
        Scanner sc=new Scanner(System.in);
        String pt=sc.nextLine();
        String cipher="";

        for(int i=0;i<pt.length();i++){
            int a=((pt.charAt(i)+3)-97)%26;
            cipher+=(char)('a'+a);
        }
        System.out.println(cipher);
    }
}
