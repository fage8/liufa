import java.io.*;

public class MySerializable implements Serializable {
    String id;
    String name;
    String sex;

    public MySerializable(String id, String name, String sex) throws IOException {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //将对象写入文件中，字节流
        MySerializable mySerinizable = new MySerializable("1202112", "liufa", "男");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:\\Users\\liufa116\\IdeaProjects\\student.txt"));
        out.writeObject(mySerinizable);
        //从文件中读出对象
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\Users\\liufa116\\IdeaProjects\\student.txt"));
        Object o = in.readObject();
        System.out.println(o);
    }
}
