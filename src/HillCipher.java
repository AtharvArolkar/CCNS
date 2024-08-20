import java.util.Scanner;

public class HillCipher {
    public static void main(String[] args) {
        System.out.println("Enter 9 digits Key:");
        Scanner sc = new Scanner(System.in);
        String key = sc.nextLine();
        int[][] mat = new int[3][3];
        int point = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int letterToNumber = (int) key.charAt(point);
                mat[i][j] = letterToNumber - (int) checkCaps(key.charAt(point));
                point++;
            }
        }
//        GYBNQKURP gyBNqkURp
//        BEAHLCAFB  TIMETOSTUDYX  XQCHJAVRGPBT
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(mat[i][j] + ",");
            }
            System.out.println();
        }
        String plaintext = "";
        String ciphertext = "";
        System.out.println("Enter the plaintext:");
        plaintext = sc.nextLine();
        int count = 0;
        int[][] vector = new int[3][1];
        for (int i = 0; i < plaintext.length(); i++) {
            if (plaintext.charAt(i) != ' ') {
                if (count != 3) {
                    char letter = plaintext.charAt(i);
                    vector[count][0] = (int) (letter - checkCaps(letter));
                    count++;
                    if (i == plaintext.length() - 1 && count != 3) {
                        while (count != 3) {
                            vector[count][0] = 23;
                            count++;
                        }
                    }
                } else {
                    ciphertext = encrypt(ciphertext, vector, mat);
                    vector = new int[3][1];
                    i--;
                    count = 0;
                }
            }
        }
        ciphertext = encrypt(ciphertext, vector, mat);
        String cipher = getString(plaintext, ciphertext);
        System.out.println("The Encrypted Text is: " + getString(plaintext, ciphertext));
        System.out.println("\n");
        System.out.println("The Decrpyted Text is: " + getString(cipher, decrpyt(getDecryptMat(mat), ciphertext)));
    }
    public static String getString(String textComp, String text) {
        String cipher = "";
        int cipherNo = 0;
        for (int i = 0; i < textComp.length(); i++) {
            if (textComp.charAt(i) == ' ') {
                cipher += ' ';
            } else {
                if (checkCaps(textComp.charAt(i)) == 'a') {
                    cipher += Character.toLowerCase(text.charAt(cipherNo));
                } else {
                    cipher += Character.toUpperCase(text.charAt(cipherNo));
                }
                cipherNo++;
            }
        }
        return cipher;
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
    public static String encrypt(String ciphertext, int[][] vec, int[][] mat) {
        for (int i = 0; i < 3; i++) {
            int num = 0;
            for (int j = 0; j < 1; j++) {
                for (int k = 0; k < 3; k++) {
                    num += mat[i][k] * vec[k][j];
                }
                ciphertext += (char) ('A' + num % 26);
            }
        }
        return ciphertext;
    }
    //Decryption
    public static int getIndex(int a) {
        int mod;
        if (a == 3) return 0;
        else if (a == -1) return 2;
        else return a;
    }
    public static int[][] getDecryptMat(int[][] a) {
        int[][] inv = new int[3][3];
        float det =
                ((a[0][0] * (a[1][1] * a[2][2] - a[1][2] * a[2][1])) - (a[0][1] * (a[1][0] * a[2][2] - a[2][0] * a[1][2])) + (a[0][2] * (a[1][0] * a[2][1] - a[2][0] * a[1][1]))) % 26;
        if (det < 0) det = det + 26;
        System.out.println("Determinant:" + det);
        int c = 1;
        Boolean cont = true;
        int count = 0;
        while (cont) {
            if ((det * count) % 26 == 1 % 26) {
                cont = false;
            } else {
                count++;
            }
        }
        System.out.println("Determinant Inverse:" + count);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                float b = (
                        (a[getIndex(i - 1)][getIndex(j - 1)] * a[getIndex(i + 1)][getIndex(j + 1)] - (a[getIndex(i - 1)][getIndex(j + 1)] * a[getIndex(i + 1)][getIndex(j - 1)]))) % 26;
                if (b < 0) {
                    b = b + 26;
                }
                inv[j][i] = (int) b * count % 26;

            }
        }
        System.out.println("Inverse Matrix:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(inv[i][j] + ",");
            }
            System.out.println();
        }
        return inv;
    }
    public static String decrpyt(int[][] invMat, String cypertext) {
        String plaintext = "";
        int count = 0;
        while (count < cypertext.length()) {
            int[][] vector = new int[3][1];
            int count1 = 0;
            while (count1 != 3) {
                char letter = cypertext.charAt(count);
                vector[count1][0] = (int) (letter - checkCaps(letter));
                count1++;
                count++;
//                System.out.print(letter);
            }
//            System.out.println();
            for (int i = 0; i < 3; i++) {
                int num = 0;
                for (int j = 0; j < 1; j++) {
                    for (int k = 0; k < 3; k++) {
                        num += invMat[i][k] * vector[k][j];
                    }
                    plaintext += (char) ('A' + num % 26);
                }
            }
        }
        return plaintext;
    }
}
