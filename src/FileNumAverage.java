import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 从文件中逐行读取成绩，求平均成绩
 */
public class FileNumAverage {
    public static void main(String[] args) throws IOException {
        //字符流
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\liufa116\\IdeaProjects\\grade.txt"));
        double sum = 0;
        int count = 0;
//        System.out.println(bufferedReader.readLine());
        String s;
        while ((s = bufferedReader.readLine()) != null) {//必须要赋值给一个字符串
            String[] strings = s.split(" ");//如果再次执行bufferedReader.readLine()会在读取下一行
            int i = 0;
            while (i < strings.length) {
                sum += Double.valueOf(strings[i]);
                i++;
            }
            count++;//记录行数
        }
        System.out.println(sum/count);//求所有成绩的平均数
    }
}
