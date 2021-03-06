import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sum24 {

    final static double PRECISION = 1E-6;
    final static int NUM = 4;
    final static int RESULT = 24;

    static double number[];
    static String[] expression;

    static boolean circule(int n)
    {
        if(n == 1)
        {
            if(Math.abs(number[0] - RESULT) < PRECISION)
            {
                System.out.println(expression[0]);
                return true;
            }
            else
            {
                return false;
            }
        }

        for(int i=0; i<n; ++i)
            for(int j=i+1; j<n; ++j)
            {
                double numi,numj;
                String expi,expj;

                numi = number[i];
                numj = number[j];
                number[j] = number[n-1];

                expi = expression[i];
                expj = expression[j];
                expression[j] = expression[n-1];

                //加的处理
                if(n > 2)
                    expression[i] = "(" + expi + "+" + expj + ")";
                else
                    expression[i] = expi + "+" + expj;
                number[i] = numi + numj;
                if(circule(n-1))
                    return true;

                //减的处理，有两种情况expi-expj,expj-expi
                if(n > 2)
                    expression[i] = '(' + expi + '-' + expj + ')';
                else
                    expression[i] = expi + '-' + expj;
                number[i] = numi - numj;
                if(circule(n-1))
                    return true;

                if(n > 2)
                    expression[i] = '(' + expj + '-' + expi + ')';
                else
                    expression[i] = expj + '-' + expi;
                number[i] = numj - numi;
                if(circule(n-1))
                    return true;

                //乘的处理
                expression[i] = expi + "*" + expj;
                number[i] = numi * numj;
                if(circule(n-1))
                    return true;

                //除的处理，有两种情况expi/expj,expj/expi
                if(numj > PRECISION)
                {
                    expression[i] = expi + '/' + expj;
                    number[i] = numi / numj;
                    if(circule(n-1))
                        return true;
                }

                if(numi > PRECISION)
                {
                    expression[i] = expj + '/' + expi;
                    number[i] = numj / numi;
                    if(circule(n-1))
                        return true;
                }

                //恢复数组
                number[i] = numi;
                number[j] = numj;
                expression[i] = expi;
                expression[j] = expj;

            }

        return false;
    }

    static void input() throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<NUM; ++i)
        {
            System.out.println("输入第" + (i+1) + "个数:");
            expression[i] = reader.readLine();
            number[i] = Double.parseDouble(expression[i]);
        }
    }

    public static void main(String[] args)
    {
        // TODO 自动生成方法存根
        number = new double[NUM];
        expression = new String[NUM];

        try
        {
            input();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }

        if(circule(NUM))
        {
            System.out.println("true");
        }
        else
        {
            System.out.println("false");
        }
    }

}
