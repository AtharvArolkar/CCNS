package practice;

import java.util.Scanner;

public class bfb {
    public static char[][] keyMat=new char[5][5];
    public static void main(String[] args) {
        System.out.println("Enter the key");;
        Scanner sc =new Scanner (System.in);
        String key=sc.nextLine();
        System.out.println("Enter the plaintext:");
        String pt=sc.nextLine();
        getMat(key);
        for(int i=0;i<keyMat.length;i++){
            for(int j=0;j<keyMat[i].length;j++){
                System.out.print(keyMat[i][j]+",");
            }
            System.out.println();
        }
        String cipher=getCipher(pt);
        System.out.println(cipher);
    }
    public static void getMat(String key){
        int keyCounter=0;
        for(int i=0;i<keyMat.length;i++){
            for(int j=0;j<keyMat[i].length;j++){
                if(keyCounter<key.length()){
                    while(keyCounter<key.length() && checkAlready(key.charAt(keyCounter))){
                        keyCounter++;
                    }
                    if(keyCounter<key.length()){
                        keyMat[i][j]=key.charAt(keyCounter);
                        keyCounter++;
                    }else{
                        j--;
                    }
                }else{
                    for(int a=0;a<26;a++){
                        if(!checkAlready((char)('a'+a))){
                            keyMat[i][j]=(char)('a'+a);
                            break;
                        }
                    }
                }
            }
        }
    }
    public static Boolean checkAlready(char a){
        Boolean present=false;
        for(int i=0;i<keyMat.length;i++){
            for(int j=0;j<keyMat[i].length;j++){
                if(keyMat[i][j]==a || a=='j'){
                    present =true;
                }
            }
        }
        return present;
    }

    public static String getCipher(String pt){
        String cipher="";
        char[] put=new char[]{'x','y'};
        for(int i=0;i<pt.length();i=i+2){
            char a=pt.charAt(i);
            char b=0;
            if((i+1)<pt.length()){
                if(a!=pt.charAt(i+1)){
                    b=pt.charAt(i+1);
                }else{
                    if(a!=put[0])b=put[0];
                    else b=put[1];
                }
            }else{
                if(a!=put[0])b=put[0];
                else b=put[1];
            }
            int ax=0,ay=0,bx=0,by=0;
            for(int j=0;j< keyMat.length;j++){
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
