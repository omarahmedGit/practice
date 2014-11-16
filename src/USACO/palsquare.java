package USACO;
/*
ID: omarahm1
LANG: JAVA
TASK: palsquare
*/


import java.util.*;
import java.io.*;

public class palsquare {

    

    public static void main(String args[]) throws FileNotFoundException, IOException {
        Scanner sc=new Scanner(new FileReader("palsquare.in"));
        game(sc.nextInt());
        sc.close();
    }

    private static boolean ispoly(String x) {
        char[] y = x.toCharArray();
        for (int i = 0, j = x.length() - 1; i < j; i++, j--) {
            if (y[i] != y[j]) {
                return false;
            }
        }
        return true;
    }
    
    private static char[] digits={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K'};
    private static String change_base(int x,int base){
        int rem; String result="";
        while(x>0){
            rem=x%base;
            result=digits[rem]+result;
            x/=base;
        }
        
        return result;
    }
    private static void game(int base) throws IOException{
        PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
        if(base==10){
            int sq;
            for(int i=1;i<=300;i++){
                sq=i*i;
                if(ispoly(sq+"")==true){
                    pw.println(i+" "+sq);
                }
            }
        }else{
            String num,sq; int numsq;
            for(int i=1;i<=300;i++){
                numsq=i*i;
                sq=change_base(numsq,base);
                if(ispoly(sq)==true){
                    num=change_base(i,base);
                    pw.println(num+" "+sq);
                }
            }
        }
        pw.close();
    }
}
