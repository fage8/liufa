import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 全排列，[1,2,3]
 * 输出[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class QuanPaiLie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String[] s = scanner.nextLine().split(",");
            int nums[] = new int[s.length];
            for(int i = 0; i < s.length; i++){
                nums[i] = Integer.valueOf(s[i]);
            }
            System.out.println(permute(nums));
        }
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        backtrack(res, list, nums);
        return res;
    }

    public static void backtrack(List<List<Integer>> res, ArrayList<Integer> list, int[] nums){
        if(list.size() == nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!list.contains(nums[i])){
                list.add(nums[i]);
                //只要list大小等于数组长度则返回空，执行下面一行代码
                backtrack(res, list, nums);
                list.remove(list.size() - 1);
            }
        }
    }
}
