package rough;

import java.util.Scanner;

public class bfb {
    public static char[][] keyMat=new char[5][5];
    public static void main(String[] args) {
        System.out.println("Enter the key:");
        Scanner sc=new Scanner(System.in);
        String key=sc.nextLine();
        System.out.println("Enter the plaintext:");
        String pt=sc.nextLine();

        getkeyMat(key);
        for(int i=0;i<keyMat.length;i++){
            for(int j=0;j<keyMat[i].length;j++){
                System.out.print(keyMat[i][j]+",");
            }
            System.out.println();
        }
        String cipher=getCipher(pt);
        System.out.println(cipher);
    }
    public static void getkeyMat(String key){
        int keyCounter=0;
        for(int i=0;i<keyMat.length;i++){
            for(int j=0;j<keyMat[i].length;j++){
//                Boolean put=false;
                if(keyCounter<key.length()){
                    char a=key.charAt(keyCounter);
                    while(checkAlready(a) && keyCounter<key.length()){
                        a=key.charAt(keyCounter);
                        keyCounter++;
                    }
                    if(keyCounter<key.length()){
                        keyMat[i][j]=a;
//                        put=false;
                    }else{
                        j--;
                    }
                }else{
//                    System.out.println(i+" "+j);
                    for(int k=0;k<26;k++){
                        char a=(char)('a'+k);
//                        System.out.print(a);
                        if(!checkAlready(a)){
                            keyMat[i][j]=a;
//                            System.out.println();
                            break;
                        }
                    }
//                    System.out.println();
                }
            }
        }
    }
    public static boolean checkAlready(char a){
            boolean present=false;
        for(int i=0;i<keyMat.length;i++){
            for(int j=0;j<keyMat[i].length;j++){
                if(keyMat[i][j]==a || a=='j'){
                    present=true;
                }
            }
        }
        return present;
    }
    public static String getCipher(String pt){
        String cipher="";
        char[] c=new char[]{'x','y'};
        pt=pt.replace('j','i');
        for(int i=0;i<pt.length();i=i+2){
            char a=pt.charAt(i);
            char b=0;
            if((i+1)<pt.length()){
                b=pt.charAt(i+1);
            }else{
                if(a!=c[0])b=c[0];
                else b=c[1];
            }
            if(a==b){
                if(a!=c[0])b=c[0];
                else b=c[1];
                i--;
            }
            System.out.println(a+" "+b);
            int ax=0,ay=0,bx=0,by=0;
            for(int j=0;j<keyMat.length;j++){
                for(int z=0;z<keyMat[j].length;z++){
                    if(keyMat[j][z]==a){
                        ax=j;
                        ay=z;
                    }
                    if(keyMat[j][z]==b){
                        bx=j;
                        by=z;
                    }
                }
            }
            if(ax==bx){
                cipher+=keyMat[ax][(ay+1)%5];
                cipher+=keyMat[bx][(by+1)%5];
            }else if(ay==by){
                cipher+=keyMat[(ax+1)%5][ay];
                cipher+=keyMat[(bx+1)%5][by];
            }else{
                cipher+=keyMat[ax][by];
                cipher+=keyMat[bx][ay];
            }
        }
        return cipher;
    }
}
