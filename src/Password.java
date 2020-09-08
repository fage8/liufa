import java.util.Scanner;

/**
 * 注册网站时，需要使用包含不同类型（数字、符号、大写字母、小写字母）的字符，和特定长度。检查一个密码内容同时包含以上 4 种类型的字符，并且长度在8-120 个字符之间。符合要求，返回 0；长度不符合返回 1；类型不符合要求返还 2。
 * 可以一次输入多组密码，以空格符间隔，空格符不作为密码。
 * 输入123 12345678 123abcABC!!!
 * 输出1
 *    2
 *    0
 */
public class Password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String[] s = scanner.nextLine().split(" ");
            int[] res = new int[s.length];
            for(int i = 0; i < s.length; i++){
                if(s[i].matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[^\\w\\s]).{8,120}$")){
                    res[i] = 0;
                }else if(s[i].length() < 8 || s[i].length() > 120){
                    res[i] = 1;
                }else if(!s[i].matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[^\\w\\s]).{8,120}$")){
                    res[i] = 2;
                }
            }
            for(int i = 0; i < res.length; i++){
                System.out.println(res[i]);
            }
        }
    }
}
