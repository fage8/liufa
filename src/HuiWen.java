import java.util.Scanner;

public class HuiWen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.next();
            System.out.println(huiWen(s));
        }
    }
    //判断一个字符串是不是回文串
    public static boolean huiWen(String s){
        StringBuffer stringBuffer = new StringBuffer(s);
        //判断内容必须用equals
        return (s.equals(stringBuffer.reverse().toString()));
    }
}
