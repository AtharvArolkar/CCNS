import java.util.Scanner;
public class VignereAutoKeying {
    public static void main(String[] args) {
        System.out.print("Enter the key: ");
        Scanner sc=new Scanner(System.in);
        String key=sc.nextLine();
        System.out.print("Enter the plaintext: ");
        String plaintext=sc.nextLine();
        int keyCounter=0;
        String cipherText="";
        Boolean keyA=true;
        int plainKey=-1;
        String keySting="";
        for(int i=0;i<plaintext.length();i++){
            char letter=plaintext.charAt(i);
            char keyLet;
            if(letter!=' '){
                if(keyA){
                    keyLet=key.charAt(keyCounter);
                }else{
                    if(plaintext.charAt(plainKey)==' '){
                        plainKey++;
                    }
                    keyLet=plaintext.charAt(plainKey);
                }
                keySting+=keyLet;
                cipherText+=(char)('A'+(((letter-checkCaps(letter))+(keyLet-checkCaps(keyLet)))%26));
                keyCounter++;
                if(keyCounter>=key.length()){
                    keyA=false;
                    plainKey++;
                }
            }

        }
        System.out.print("Key:");
        System.out.println(keySting);
        System.out.print("CipherText:");
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
