public class Main {
    static int n;
    static boolean[] flag;
    static int m;
    static long sink;

    static void generate(int count, double p) {
        n=count;
        flag=new boolean[n];
        for(int i=0;i<n;i++){
            flag[i]=Math.random()<p;
        }
    }
    static boolean checkGroup(int lo,int hi){
        boolean found=false;
        for(int i=lo;i<hi;i++){
            if(flag[i]){
                found=true;
            }
            for(int k=0;k<m;k++){
                sink +=k;
            }
        }
        return found;
    }
    static int metodA(){
        int count=0;
        for(int i=0;i<n;i++){
            if(checkGroup(i,i+1)){
                count++;
            }
        }
        return count;
    }
    static int metodB(int lo,int hi){
        if(lo >=hi){
            return 0;
        }
        if(!checkGroup(lo,hi)){
            return 0;
        }
        if(hi-lo==1){
            return 1;
        }
        int mid=(lo+hi)/2;
        return metodB(lo,mid)+metodB(mid,hi);
    }
    public static void main(String[] args) {
        m=100;
        generate(20,0.3);
        sink=0;
        int foundA=metodA();

        sink=0;
        int foundB=metodB(0,n);
        System.out.println(+foundA);
        System.out.println(+foundB);
        System.out.println(foundA==foundB);


    }
}