import java.util.Scanner;

public class CaeserCipher {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the Plaintext:");
        String plaintext= sc.nextLine();
        System.out.println("Enter the Key:");
        int key=sc.nextInt();
        String cipherText="";
        for(int i=0;i<plaintext.length();i++){
            char is_caps=plaintext.charAt(i);
            int letter=(is_caps+key);
            int a=0;
            if(Character.isLowerCase(is_caps)){
                a=97;
            }else{
                a=65;
            }
            if(letter>=a+26){
                letter=letter-26;
            }
            cipherText +=(char)letter;
        }
        System.out.println(cipherText);
    }
}
