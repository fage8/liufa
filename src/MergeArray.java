import java.util.ArrayList;
import java.util.Arrays;

/**
 * 输入[3,1,2],[2,5,4]
 * 输出[1,2,2,3,4,5]
 */
public class MergeArray {
        public static void main(String[] args) {
            int[] a = new int[]{3,1,2};
            int[] b = new int[]{2,5,4};
            int[] res = merge(a, b);
            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i]);

            }
        }
        /**
         *
         * @param one int整型一维数组 数组一
         * @param two int整型一维数组 数组二
         * @return int整型一维数组
         */
        public static int[] merge (int[] one, int[] two) {
            // write code here
            ArrayList<Integer> list = new ArrayList<>();
            Arrays.sort(one);
            Arrays.sort(two);
            if(one.length == 0) return two;
            if(two.length == 0) return one;
            int i = 0, j = 0;
            while(i < one.length || j < two.length){
                if(i < one.length && j < two.length){
                    if(one[i] < two[j]){
                        list.add(one[i]);
                        i++;
                    }else{
                        list.add(two[j]);
                        j++;
                    }
                }else if(i < one.length){
                    list.add(one[i]);
                    i++;
                }else if(j < two.length){
                    list.add(two[j]);
                    j++;
                }
            }

            int[] res = new int[list.size()];
            for(int k = 0; k < res.length; k++){
                res[k] = list.get(k);
            }
            return res;
        }
    }


