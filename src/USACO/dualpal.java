package USACO;

/*
ID: omarahm1
LANG: JAVA
TASK: dualpal
*/
import java.util.*;
import java.io.*;

public class dualpal {
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(new FileReader("dualpal.in"));
        game(sc.nextInt(),sc.nextInt());
    }
    
    private static void game(int n,int low) throws IOException{
        int inc=0;
        PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
        for(int i=low+1;inc<n;i++){
            if(checkduel(i)==true){
                inc++;
                pw.println(i);
            }
        }
        pw.close();
    }
    private static boolean checkduel(int x){
        int number=0; String num; 
        if(ispoly(x+"")==true){number++;}
        for(int i=2;i<10;i++){
            num=change_base(x,i);
            if(ispoly(num)==true){
                number++;
            }
            if(number==2){return true;}
        }
        return false;
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
}
