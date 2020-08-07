public class LongToInt {
    public static void main(String[] args) {
        long a = 1l;
        long b = 2147483647l;
        long c = 9876543210l;
        long d = 123456789123456789l;
        System.out.println(a<b);
        System.out.println(c>b);
        System.out.println(d>c);
//        System.out.println(a>c);
    }
}

