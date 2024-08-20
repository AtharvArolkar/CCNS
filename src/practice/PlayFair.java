package practice;

import java.util.Locale;
import java.util.Scanner;

public class PlayFair {
    public static char[][] keyMat=new char[5][5];
    public static void main(String[] args) {
        System.out.println("Enter the key:");
        Scanner sc =new Scanner(System.in);
        String key=sc.nextLine();
        System.out.println("Enter the plaintext:");
        String plaintext=sc.nextLine();
        makeMat(key);
        for(int i=0;i<keyMat.length;i++){
            for(int j=0;j<keyMat[i].length;j++){
                System.out.print(keyMat[i][j]+",");
            }
            System.out.println();
        }
        System.out.println(getCipher(plaintext.toLowerCase(Locale.ROOT)));
    }
    public static void makeMat(String key) {
        int keyCounter = 0;
        for (int i = 0; i < keyMat.length; i++) {
            for (int j = 0; j < keyMat[i].length; j++) {
                Boolean enter=false;
                if (keyCounter < key.length()) {
                    if (!checkAlready(key.charAt(keyCounter))) {
                        keyMat[i][j] = key.charAt(keyCounter);
                        enter =true;
                    }
                    keyCounter++;
                } else {
                    for (int z = 0; z < 26; z++) {
                        char c = (char) ('a' + z);
                        if (!checkAlready(c)) {
                            keyMat[i][j] = c;
                            System.out.println(c);
                            enter =true;
                            break;
                        }
                        keyCounter++;

                    }
                }
                if(!enter){
                    j--;
                }
            }
        }
    }
    public static Boolean checkAlready(char c){
        Boolean present =false;
        for(int i=0;i<keyMat.length;i++){
            for(int j=0;j<keyMat[i].length;j++){
                if(keyMat[i][j]==c || c=='j'){
                    present=true;
                }
            }
        }
        return present;
    }
    public static String getCipher(String pt){
        String cipher="";
        char sub1='x',sub2='y';
        for(int i=0;i<pt.length();i=i+2){
            char a,b;
            if(i+1<pt.length()){
                if(pt.charAt(i)!=pt.charAt(i+1)){
                    a=pt.charAt(i);
                    b=pt.charAt(i+1);
                }else{
                    a=pt.charAt(i);
                    if(a!=sub1)
                        b=sub1;
                    else
                        b=sub2;
                    i--;
                }
            }else{
                a=pt.charAt(i);
                if(a!=sub1)
                    b=sub1;
                else
                    b=sub2;
            }
            int ai=0,aj=0,bi=0,bj=0;
            for(int j=0;j<keyMat.length;j++){
                for(int z=0;z<keyMat[j].length;z++){
                    if(keyMat[j][z]==a){
                        ai=j;
                        aj=z;
                    }
                    if(keyMat[j][z]==b){
                        bi=j;
                        bj=z;
                    }
                }
            }
            System.out.println(a+","+b+",");
            System.out.println(ai+","+aj+","+bi+","+bj+",");
            if(ai==bi){
                cipher+=keyMat[ai][(aj+1)%5];
                cipher+=keyMat[bi][(bj+1)%5];
            }else if(aj==bj){
                cipher+=keyMat[(ai+1)%5][aj];
                cipher+=keyMat[(bi+1)%5][bj];
            }else{
                cipher+=keyMat[ai][bj];
                cipher+=keyMat[bi][aj];
            }

        }
        return cipher;
    }
}
