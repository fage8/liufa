import java.util.HashMap;
import java.util.Map;

public class DengCha {
    public static void main(String[] args) {
        int res = cha(2, 1, 10);
        System.out.println(res);

        //hashmap遍历
        Map<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("asa", 12);
        hashMap.put("asae", 1212);
        hashMap.put("asawe", 121);
//        for(String key:hashMap.keySet()){
//            System.out.println(key + hashMap.get(key));
//        }
        for (Map.Entry<String, Integer> entry:hashMap.entrySet()){
            System.out.println(entry.getKey() + entry.getValue());
        }
    }
    //这个是求an的不是sn
    public static int cha(int s, int a, int n){
        if(n == 1) return a;
        else return (s + cha(s, a, n -1));
    }

}
