package rough;

import java.util.Locale;
import java.util.Scanner;

public class vigenere {
    public static void main(String[] args) {
        System.out.println("Enter the plaintext:");
        Scanner sc=new Scanner(System.in);
        String pt=sc.nextLine().toLowerCase(Locale.ROOT);
        System.out.println("Enter the key:");
        String key=sc.nextLine().toLowerCase(Locale.ROOT);
        repeatingKey(key,pt);
        autoKey(key,pt);
    }
    public static void repeatingKey(String key,String pt){
        int keyCount=0;
        String cipher="";
        for(int i=0;i<pt.length();i++){
            int a=pt.charAt(i)-97;
            int b=key.charAt(keyCount)-97;
            keyCount++;
            if(keyCount==key.length()){
                keyCount=0;
            }
            cipher+=(char)('a'+((a+b)%26));
        }
        System.out.println(cipher);
    }
    public static void autoKey(String key,String pt){
        int keyCount=0;
        String cipher="";
        for(int i=0;i<pt.length();i++){
            int a=pt.charAt(i)-97;
            int b=0;
            if(keyCount<key.length()){
                b=key.charAt(keyCount)-97;
            }else{
                b=pt.charAt(keyCount-key.length())-97;
            }
            keyCount++;
            cipher+=(char)('a'+((a+b)%26));
        }
        System.out.println(cipher);
    }
}
