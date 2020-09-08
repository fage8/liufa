import java.util.Scanner;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格,同一个单元格内的字母不允许被重复使用。
 * 输入SEE
 * 输出true
 */
public class SearchString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            char[][] board = new char[][]
            {{'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}};
            System.out.println(exist(board, s));
        }
    }
    public static boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || word == null) return false;
        //用一个数组表示某个位置上的元素是否已经使用过
        int m = board.length;
        int n = board[0].length;
        boolean[] flag = new boolean[m*n];
        //从每个位置开始遍历看是否包含此字符串。
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++){
                if(helper(board, word, i, j, flag,0)) return true;
            }
        return false;
    }
    public static boolean helper(char[][] board, String word, int i, int j, boolean[] flag, int index){
        if(index == word.length()) return true;
        if(i < 0 || i >= board.length || j<0||j >= board[0].length || board[i][j] != word.charAt(index) || flag[i * board[0].length + j]) return false;
        flag[i * board[0].length + j] = true;
        if(helper(board, word,i + 1, j, flag,index + 1) || helper(board, word,i - 1, j, flag,index + 1)
                || helper(board, word, i,j - 1, flag,index + 1) || helper(board, word, i,j + 1, flag,index + 1))
            return true;
        flag[i * board[0].length + j] = false;
        return false;

    }

}

