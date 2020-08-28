import javax.xml.bind.SchemaOutputResolver;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 第一个只出现一次的字符
 */
public class FirstOnceChar {
    public static void main(String[] args) {
        char res = firstUniqChar("leetcode");
        System.out.println(res);
    }
    public static char firstUniqChar(String s) {
        if(s == "") return ' ';
        //LinkedHashMap 才是按照加入的顺序遍历
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }else{
                map.put(s.charAt(i), 1);
            }
        }
        for(Character key : map.keySet()){
//            System.out.println(key + " " + map.get(key));
            if(map.get(key) == 1){
                return key;
            }
        }
        return ' ';
    }
}
