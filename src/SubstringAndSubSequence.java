import java.util.ArrayList;
import java.util.Scanner;

/**
 * 即为s的子串又是t的子序列的不同字符串（位置不同也是不同）个数
 * (不能加入正则判断，多加了输出的语句导致有问题)
 */
public class SubstringAndSubSequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int a = in.nextInt();
            int b = in.nextInt();
            in.nextLine();
            String s = in.nextLine();
            String t = in.nextLine();
            ArrayList<String> list = new ArrayList<>();
            for(int i = 0; i < s.length(); i++){
                for(int j = i+1; j <= s.length(); j++){
                    list.add(s.substring(i,j));
                }
            }
            int sum = 0;
            for(int i = 0; i < list.size(); i++){
                if(numDistinct(list.get(i), t)){
                    sum++;
                }
            }

            System.out.println(sum);
        }
    }
    public static boolean numDistinct(String s, String t) {
        int i = 0, j =0;
        while (i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }

        }
        //只要s遍历结束了就说明s为t的子序列
        if(i == s.length())
        {
            return true;
        }else {
            return false;
        }
    }


}
