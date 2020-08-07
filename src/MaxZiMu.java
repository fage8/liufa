import java.util.Scanner;

/**
 * 在字符串中找到最大的字母，并在其后面加上(max)
 */
public class MaxZiMu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.next();
            char flag = 'A';
            //找到最大字母
            for(int i = s.length() - 1; i >= 0; i--){
                if(s.charAt(i) > flag){
                    flag = s.charAt(i);
                }
            }
            //在最大字母后面加上(max)
            StringBuffer stringBuffer = new StringBuffer(s);
            for(int i = s.length() - 1; i >= 0; i--){
                if(stringBuffer.charAt(i) == flag){
                    stringBuffer.insert(i+1,"(max)");
                }
            }
            System.out.println(stringBuffer.toString());
        }
    }
}

