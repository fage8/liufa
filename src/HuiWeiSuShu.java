import java.util.Scanner;

/**
 * 去掉一个位数是回文素数，求M至N之间的回文素数个数
 * 110 120
 * 输出10
 */
public class HuiWeiSuShu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            System.out.println(huiwensushu(m,n));
        }
    }
    public static int huiwensushu(int m, int n){
        int sum = 0;
        for(int i = m; i <= n; i++){
            String s = String.valueOf(i);
            //加上位数大于1的判断，个位数肯定不是回文素数
            if(s.length() > 1) {
//            if(s.substring(0,1).equals("0")) s = s.substring(1, s.length());
                if (huiWen(s.substring(1, s.length())) && sushu(Integer.valueOf(s.substring(1, s.length())))) {
                    sum++;
                    //必须加上，不然会进后面的for循环
                    continue;
                }
                if (huiWen(s.substring(0, s.length() - 1)) && sushu(Integer.valueOf(s.substring(0, s.length() - 1)))) {
                    sum++;
                    //必须加上，不然会进后面的for循环
                    continue;
                }
                for (int j = 1; j < s.length() - 1; j++) {
                    String newstr = s.substring(0, j) + s.substring(j + 1, s.length());
                    if (huiWen(newstr) && sushu(Integer.valueOf(newstr))) {
                        sum++;
                        break;
                    }
                }
            }
        }
        return sum;
    }

    //判断一个字符串是不是回文串
    public static boolean huiWen(String s){
        StringBuffer stringBuffer = new StringBuffer(s);
        //判断内容必须用equals
        return (s.equals(stringBuffer.reverse().toString()));
    }
    //素数
    public static boolean sushu(int a) {
        int k = (int) Math.sqrt(a);
        //0和1必须都考虑
        if(a <= 1) return false;
        for (int i = 2; i <= k; i++){
            if (a % i == 0)
                return  false;

        }
        return true;
    }
}
