package rough;

public class INVERSE {

    public static int getIndex(int a){
//        System.out.println(a);
        int mod;
        if(a==3)return 0;
        else if(a==-1)return 2;
        else return a;
    }

    public static void main(String[] args) {
        int [][] inv=new int[3][3];
        int[][] a=
                {{17, 17, 5 },
                        {21, 18, 21},
                        { 2, 2, 19}};
        float det=
                ((a[0][0]*(a[1][1]*a[2][2]-a[1][2]*a[2][1]))-(a[0][1]*(a[1][0]*a[2][2]-a[2][0]*a[1][2]))+(a[0][2]*(a[1][0]*a[2][1]-a[2][0]*a[1][1])))%26;
        if(det<0)det=det+26;
        System.out.println(det);
        int c=1;
        Boolean cont=true;
        int count=0;
        while(cont){
            if((det*count)%26==1%26){
                cont=false;
            }else {
                count++;
            }
        }
        System.out.println(count);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
//                System.out.println(getIndex(i-1)+" "+getIndex(i+1)+" "+getIndex(j-1)+" "+getIndex(j+1));
                float b=(
                        (a[getIndex(i-1)][getIndex(j-1)]*a[getIndex(i+1)][getIndex(j+1)]-   (a[getIndex(i-1)][getIndex(j+1)]*a[getIndex(i+1)][getIndex(j-1)])))%26;
                if(b<0){b=b+26;};
                inv[j][i]=(int)b*count%26;
            }
            System.out.println();
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(inv[i][j]+",");
            }
            System.out.println();
        }
    }
}
