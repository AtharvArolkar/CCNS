package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class columnar {
    public static void main(String []args) {
        ArrayList<ArrayList<Character>> col=new ArrayList<>();

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the plaintext:");
        String plaintext=sc.nextLine();
        System.out.println("Enter the key");
        int key=sc.nextInt();

        String keyString=Integer.toString(key);
        for(int i=0;i<keyString.length();i++){
            ArrayList<Character> a=new ArrayList<>();
            col.add(a);
        }

        int count=0;
        for(int i=0;i<plaintext.length();i++){
            char a=plaintext.charAt(i);
            col.get(count).add(a);
            count++;
            if(count==col.size()){
                count=0;
            }
        }

        for(int i=0;i<col.get(0).size();i++){
            for(int j=0;j<col.size();j++){
                if(i<col.get(j).size()){
                    System.out.print(col.get(j).get(i)+",");}
            }
            System.out.println();
        }

        for(int i=0;i<keyString.length();i++){
            int j=Integer.parseInt(""+keyString.charAt(i));
            for(int z=0;z<col.get(j-1).size();z++){
                System.out.print(col.get(j-1).get(z));
            }
        }

    }
}
