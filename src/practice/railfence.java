package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class railfence {
    public static void main(String []args){
        System.out.println("Enter pt:");
        Scanner sc=new Scanner(System.in);
        String pt=sc.nextLine();
        System.out.println("Enter depth");
        int depth=sc.nextInt();
        ArrayList<ArrayList<Character>> rail=new ArrayList<>();
        for(int i=0;i<depth;i++){
            ArrayList<Character> a=new ArrayList<>();
            rail.add(a);
        }
        String dir="for";
        int count=0;
        for(int i=0;i<pt.length();i++){
//            System.out.println(pt.charAt(i));
            rail.get(count).add(pt.charAt(i));
            if(dir=="for"){
                count++;
            }else{
                count--;
            }
            if(count==depth-1){
                dir="bac";
            }else if(count==0){
                dir="for";
            }
        }
        for(int i=0;i<rail.size();i++){
            for(int j=0;j<rail.get(i).size();j++){
                System.out.print(rail.get(i).get(j));
            }
            System.out.println();
        }
        for(int i=0;i<rail.size();i++){
            for(int j=0;j<rail.get(i).size();j++){
                System.out.print(rail.get(i).get(j));
            }
//            System.out.println();
        }
    }
}
