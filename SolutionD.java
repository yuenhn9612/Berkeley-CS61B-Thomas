import java.util.Arrays;
import java.util.Scanner;

public class SolutionD {
    static Scanner in = new Scanner(System.in);

    private static void solve(){
        int n = in.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        double[][] dp = new double[n][n];
        dp[0][0]=0;
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= i; j++){
                if(j==0){
                    dp[i][j] = (dp[i-1][j]+1 + dp[i-1][j]*(i-1)) / (i*1.0);
                } else if(j==i){
                    dp[i][j] = (dp[i-1][j-1]+1 + dp[i-1][j-1]*(i-1)) / (i*1.0);
                } else {
                    dp[i][j] = (dp[i-1][j]+1 + dp[i-1][j-1]+1 +dp[i-1][j]*(i-1-j) + dp[i-1][j-1]*(j-1)) / (i*1.0);
                }
            }
        }
        double ans = 0;
        for(int i = 0; i < n; i++){
            ans += arr[i]*dp[n-1][i];
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int T = in.nextInt();
        for(int i = 0; i < T; i++){
            System.out.printf("Case #%d: ", i+1);
            solve();
        }
    }
}
