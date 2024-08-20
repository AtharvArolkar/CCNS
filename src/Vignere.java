import java.util.Scanner;
public class Vignere {
    public static void main(String[] args) {
        System.out.print("Enter the key: ");
        Scanner sc=new Scanner(System.in);
        String key=sc.nextLine();
        System.out.print("Enter the plaintext: ");
//        sc.nextLine();
        String plaintext=sc.nextLine();
        int keyCounter=0;
        String cipherText="";
        System.out.print("Key:");
        for(int i=0;i<plaintext.length();i++){
            System.out.print(key.charAt(i%key.length()));
        }
        System.out.println();
        System.out.print("CipherText:");
        for(int i=0;i<plaintext.length();i++){
            char letter=plaintext.charAt(i);
            char keyLet=key.charAt(keyCounter);
            if(letter!=' '){
                cipherText+=(char)('A'+(((letter-checkCaps(letter))+(keyLet-checkCaps(keyLet)))%26));
                keyCounter++;
                if(keyCounter==key.length()){
                    keyCounter=0;
                }
            }
        }
        System.out.println(cipherText);
    }
    public static char checkCaps(char letter) {
        char a = 0;
        if (Character.isLowerCase(letter)) {
            a = 'a';
        } else {
            a = 'A';
        }
        return a;
    }
}
