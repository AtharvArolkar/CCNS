import java.util.Scanner;
public class PlayFairCipher {
    public static void main(String[] args) {
        char [][]mat =new char[5][5];
        int z=0;
        char let='A';
        String plain="";
        System.out.println("Enter the Key:");
        Scanner sc=new Scanner(System.in);
        String key=sc.nextLine();
        Boolean put=false;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                put=false;
                if(z<key.length()){
                    while(z<key.length() && alreadyPresent(mat,key.charAt(z))){
                        z++;
                    }
                    if(z<key.length()){
                        mat[i][j]=key.charAt(z);
                        put=true;
                        z++;
                    }
                }else{
                    while(alreadyPresent(mat,(char)(let))){
                        let++;
                    }put=true;
                    mat[i][j]=let;
                }
                if(!put){
                   j--;
                }
            }
        }
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){

                System.out.print(mat[i][j]+",");
            }
            System.out.println();
        }
        System.out.println("Enter The PlainText:");
        String Text=sc.nextLine();
        String PlainText="";
        for(int i=0;i<Text.length();i++){
            if(Text.charAt(i)=='J'){
                PlainText+='I';
            }else{
                PlainText+=Character.toUpperCase(Text.charAt(i));
            }
        }
        System.out.println(PlainText);
        String cipher=encrpytText(PlainText,mat);
        System.out.println();
        System.out.println("The Encrypted Text Is:"+cipher);
    }
    public static boolean alreadyPresent(char[][] mat, char s) {
        boolean present = false;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(mat[i][j]==s){
                    present=true;
                }
            }
        }
        if(s=='J'){
            present=true;
        }
        return present;
    }
    public static String encrpytText(String PT, char[][] mat){
        String cipher="";
        char[] bogusLetter=new char[]{'X','Y','Z'};
        char bogusLetterChose=0;
        int z=0;
        Boolean calulate=false;
        char a = 0,b=0;
        for(int i=0;i<PT.length();i++){
            if(PT.charAt(i)==' '){
//                cipher+=' ';
            }else{
                if(z==0){
                    a=PT.charAt(i);
                    z=1;
                }else if(z==1){
                    if(PT.charAt(i)!=a){
                        b=PT.charAt(i);
                    }else{
                        int c=0;
                        while(PT.charAt(i)==bogusLetter[c]){
                            c++;
                        }
                        b=bogusLetter[c];
                        bogusLetterChose=b;
                        i--;
                    }
                    z=0;
                    calulate=true;
                    System.out.println("A:"+a+",B:"+b);
                }
            }
            if(calulate){
                cipher=calculateCipher(cipher,mat,a,b);
                calulate=false;
                System.out.println(cipher);
            }
        }
        if(z==1){
            int c=0;
            while(c!=3){
                if(a!=bogusLetter[c]){
                    if(bogusLetter[c]!=bogusLetterChose){
                        b=bogusLetter[c];
                        break;
                    }
                }
                c++;
            }
            b=bogusLetter[c];
            System.out.println("A:"+a+",B:"+b);
            cipher=calculateCipher(cipher,mat,a,b);
        }
        return cipher;
    }
    public static String calculateCipher(String cipher, char[][] mat ,char a, char b) {
        int index1x=0,index1y=0,index2x=0,index2y=0;
        for(int j=0;j<5;j++){
            for(int k=0;k<5;k++){
                if(mat[j][k]==a){
                    index1x=j;
                    index1y=k;
                }
                if(mat[j][k]==b){
                    index2x=j;
                    index2y=k;
                }
            }
        }
        if(index1x==index2x){
            if(index1y==4){
                cipher+=mat[index1x][0];
            }else{
                cipher+=mat[index1x][index1y+1];
            }
            if(index2y==4){
                cipher+=mat[index2x][0];
            }else{
                cipher+=mat[index1x][index2y+1];
            }
        }else if(index1y==index2y){
            if(index1x==4){
                cipher+=mat[0][index1y];
            }else{
                cipher+=mat[index1x+1][index1y];
            }
            if(index2x==4){
                cipher+=mat[0][index2y];
            }else{
                cipher+=mat[index2x+1][index2y];
            }
        }else{
            cipher+=mat[index1x][index2y];
            cipher+=mat[index2x][index1y];
        }
        return cipher;
    }
}
