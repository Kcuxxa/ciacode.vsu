public class Main {
    static int n;
    static boolean[] flag;
    static int m;

    static void generate(int count, double p) {
        n=count;
        flag=new boolean[n];
        for(int i=0;i<n;i++){
            flag[i]=Math.random()<p;
        }
    }
    public static void main(String[] args) {

        System.out.printf("Hello and welcome!");

    }
}