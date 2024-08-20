import java.util.ArrayList;
import java.util.Scanner;

public class ColumnarTransCipher {
    public static void main(String[] args) {
        System.out.print("Enter the key: ");
        Scanner sc=new Scanner(System.in);
        int key=sc.nextInt();
        System.out.print("Enter the plaintext: ");
        sc.nextLine();
        String plaintext=sc.nextLine();
        ArrayList<ArrayList<Character>> columnar=new ArrayList<>();
        for(int i=0;i<Integer.toString(key).length();i++){
            ArrayList<Character> a=new ArrayList<>();
            columnar.add(a);
        }
        int j=0,z=0;
        for(int i=0;i<plaintext.length();i++){
            char letter=plaintext.charAt(i);
            if(plaintext.charAt(i)==' '){
                columnar.get(z).add(' ');
            }else{
                columnar.get(z).add(letter);
            }
            z++;
            if(z== Integer.toString(key).length()){
                z=0;
            }
        }
        if(z!=Integer.toString(key).length()){
            while (z!=Integer.toString(key).length()){
                columnar.get(z).add('_');
                z++;
            }
        }
        for(int i=0;i<Integer.toString(key).length();i++){
            System.out.print(Integer.toString(key).charAt(i)+" ");
        }
        System.out.println();
        for(int i=0;i<columnar.get(0).size();i++){
            for(j=0;j<columnar.size();j++){
                System.out.print(columnar.get(j).get(i)+" ");
            }
            System.out.println();
        }
        int[] keyArr=new int[Integer.toString(key).length()];
        for(int i=keyArr.length-1;i>=0;i--){
            keyArr[i]=key%10;
            key=key/10;
        }
        int min=0;
        for(int i=0;i<keyArr.length;i++){
            min=i;
            for(j=0;j<keyArr.length;j++){
                if(keyArr[j]==i+1){
                    min=j;
                }
            }
            for(z=0;z<columnar.get(min).size();z++){
                System.out.print(columnar.get(min).get(z));
            }
        }
    }
}
