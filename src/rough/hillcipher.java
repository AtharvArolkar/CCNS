package rough;

import java.util.Locale;
import java.util.Scanner;

public class hillcipher {
    public static int[][] keyMat = new int[3][3];

    public static void main(String[] args) {
        System.out.println("Enter the key:");
        Scanner sc = new Scanner(System.in);
        String key = sc.nextLine();
        System.out.println("Enter the plaintext:");
        String pt = sc.nextLine();
        getMat(key.toLowerCase(Locale.ROOT));
        String cipher = getCipher(pt.toLowerCase(Locale.ROOT));
        System.out.println(cipher.substring(0, pt.length()));
        System.out.println(getPt(cipher).substring(0, pt.length()));
    }

    public static void getMat(String key) {
        int keyCounter = 0;
        for (int i = 0; i < keyMat.length; i++) {
            for (int j = 0; j < keyMat[i].length; j++) {
                int a = key.charAt(keyCounter) - 97;
                keyMat[i][j] = a;
                System.out.print(a + ",");
                keyCounter++;
            }
            System.out.println();
        }
    }

    public static String getCipher(String pt) {
        String cipher = "";
        int[][] vec = new int[][]{{24}, {24}, {24}};
        int vecCounter = 0;
        for (int i = 0; i < pt.length(); i++) {
            vec[vecCounter][0] = pt.charAt(i) - 97;
            vecCounter++;
            if (vecCounter == 3) {
                cipher += matMul(vec, keyMat);
                vec = new int[][]{{24}, {24}, {24}};
                vecCounter = 0;
            }
        }
        if (vecCounter < 3 && vecCounter != 0) {
            cipher += matMul(vec, keyMat);
        }
        return cipher;
    }

    public static String matMul(int[][] vec, int[][] mat) {
        String cipher = "";
        int a = 0;

//        int[][] mat=Mat;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 1; j++) {
                for (int k = 0; k < 3; k++) {
                    a += mat[i][k] * vec[k][j];
                }
                cipher += (char) ('a' + (a % 26));
            }
            a = 0;
        }
        return cipher;
    }

    public static String getPt(String cipher) {
        String pt = "";
        int[][] inv = getInv();
        int counter = 0;
        int[][] vec = new int[][]{{24}, {24}, {24}};
        System.out.println();
        for (int i = 0; i < cipher.length(); i++) {
            int a = cipher.charAt(i) - 97;
            vec[counter][0] = a;
            counter++;
            System.out.print(a + " ");
            if (counter == 3) {
                System.out.println();
                counter = 0;
                pt += matMul(vec, inv);
                vec = new int[][]{{24}, {24}, {24}};
            }
        }
        return pt;
    }

    public static int[][] getInv() {
        int[][] inv = new int[3][3];
        int a = 0;
        float d = 0;
//        int b=1;
        for (int i = 0; i < keyMat.length; i++) {
//            System.out.println("b:"+b);
            int c = (keyMat[a][i] * ((keyMat[getIndex(a + 1)][getIndex(i + 1)] * keyMat[getIndex(a + 2)][getIndex(i + 2)]) -
                    (keyMat[getIndex(a + 1)][getIndex(i + 2)] * keyMat[getIndex(a + 2)][getIndex(i + 1)])));
            d += c;

//            System.out.println("c"+d);c=0;
        }
        System.out.println("d:" + d % 26);
        int count = 1;
        while (true) {
            if ((count * d) % 26 == 1 % 26) {
                break;
            } else {
                count++;
            }
        }
//        System.out.println("d-1"+count);
        int f = 1;
        int e = 0;
        for (int i = 0; i < keyMat.length; i++) {
            for (int j = 0; j < keyMat[i].length; j++) {
                e =
                        ((keyMat[getIndex(i + 1)][getIndex(j + 1)] * keyMat[getIndex(i + 2)][getIndex(j + 2)]) -
                                (keyMat[getIndex(i + 1)][getIndex(j + 2)] * keyMat[getIndex(i + 2)][getIndex(j + 1)])) % 26;
                if (e < 0) e = e + 26;
                inv[j][i] = (count * e) % 26;
            }

        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(inv[i][j] + ",");
            }
            System.out.println();
        }
        return inv;
    }

    public static int getIndex(int i) {
        return i % 3;
    }
}
