public class zhibishu {

    int main()
    {

        return 0;
    }
    public int GetCoinCount (int N) {
        // write code here
        int M;
        M=1024-N;

        int dp[] = new int[1024];
        for(int i=1;i<=M;i++)
            dp[i]=100001;
        dp[0]=0;
        int W[]= new int[]{1,4,16,64};
        for(int i=0;i<4;i++)
        {
            for(int j=W[i];j<=M;j++)
            {
                dp[j]=Math.min(dp[j],dp[j-W[i]]+1);
            }
        }
        return dp[M];
    }
}
