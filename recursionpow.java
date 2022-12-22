import java.util.Scanner;

import java.util.Scanner;
//Рекурссия
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double x = in.nextDouble(); // основание 
        double y = in.nextDouble(); // степень
       System.out.println( pow(x, y));
    }
    public static double pow (double n, double t) {
        if (t>1) //положительная степень
            return n*pow(n, t-1);
        else if (t<-1) {
            return 1/n*pow(n, t+1); // отрицательная степень 
        }
        else if (t==0)
            return 1;
        else if (t == -1) // случай с отрицательной, если просто -1
            return 1/n;
        else return n;
    }
}