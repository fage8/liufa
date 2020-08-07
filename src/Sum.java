import java.util.Scanner;

/**
 * 数列求和 1/5-1/10+1/15-1/20+...+1/(2n-1)-1/2n
 */
public class Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            //四舍五入保留4位小数
            System.out.println(String.format("%.4f", summ(n)));
        }
    }
    public static double summ(int n){
        double res = 0;
        for(int i = 1; i <= n; i++){
            res += (double) 1/(10*i*(2*i-1));
        }

        return res;
    }
}
