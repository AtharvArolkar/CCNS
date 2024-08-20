import java.util.ArrayList;
import java.util.Scanner;

public class RailFenceCipher {
    public static void main(String[] args) {
        System.out.print("Enter the depth: ");
        Scanner sc=new Scanner(System.in);
        int depth=sc.nextInt();
        System.out.print("Enter the plaintext: ");
        sc.nextLine();
        String plaintext=sc.nextLine();
        ArrayList<ArrayList<Character>> railFence=new ArrayList<>();
        for(int i=0;i<depth;i++){
            ArrayList<Character> a=new ArrayList<>();
            railFence.add(a);
        }
        int count=0;
        int listCounter=0;
        String dir="for";
        while(count<plaintext.length()){
            if(listCounter==0){
                dir="for";
            }else if(listCounter==depth-1){
                dir="bac";
            }
            char letter=plaintext.charAt(count);
            if(letter==' '){
                railFence.get(listCounter).add(' ');
            }else{
                railFence.get(listCounter).add(letter);
            }
            if(dir=="for"){
                listCounter++;
            }else{
                listCounter--;
            }
            count++;
        }
        System.out.print("The Encrypted Text is: ");
        for(int i=0;i<railFence.size();i++){
            for(int j=0;j<railFence.get(i).size();j++){
                System.out.print(railFence.get(i).get(j));
            }
        }
    }
}
