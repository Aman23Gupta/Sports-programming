import java.io.*;
import java.util.*;

//solution classes here

public class Code {

    //main solution here
    static int mod = 1000000007;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t-->0) {
            long n = sc.nextLong();
            long dp[][] = {{2,3,1,0},{1,0,0,0},{0,0,2,3},{0,0,1,0}};
            long[][] res = {{1,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,1}};
            --n;
            while(n>0) {
                if((n&1)==1) res=mul(res,dp);
                dp = mul(dp,dp);
                n>>=1;
            }
            long ans = (res[0][0]*2+res[0][1]*1+res[0][2]*5+res[0][3])%mod;
            out.println(ans);

        }


        out.flush();
        out.close();
    }

    public static long[][] mul(long a[][],long b[][]) {

        long mat[][] = new long[4][4];
        for(int i=0;i<4;i++) {
            for(int j=0;j<4;j++) {
                for(int k=0;k<4;k++) {
                    mat[i][j] = (mat[i][j]%mod+(a[k][j]%mod*b[i][k]%mod)%mod)%mod;
                }
            }
        }
        return mat;
    }

    //solution functions here

    /*
     * ******************************************************************************************************************************
     * ******************************************************************************************************************************
     * ******************************************************************************************************************************
     * #########  #######  ######   ########  ##  ###   ##  ##    ##   #######  ##    ##   #######  ##   ##  #######   ########
     * ##    ###  ##       ##       ########  ##  ## #  ##   ##  ##    ##       ##    ##   ##       ##  ##   ##        ##    ##
     * ##    ###  #######  ######      ##     ##  ##  # ##     ##      #######  ##    ##   ##       ####     #######   ########
     * ##    ###  ##           ##      ##     ##  ##   ###     ##      ##       ##    ##   ##       ##  ##   ##        ##   ##
     * #########  #######  ######      ##     ##  ##    ##     ##      ##       ########   #######  ##   ##  #######   ##     ##
     *******************************************************************************************************************************
     *******************************************************************************************************************************
     *******************************************************************************************************************************
     */

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(FileReader fileReader) {
            br = new BufferedReader(fileReader);
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public double nextDouble() throws  IOException{
            return Double.parseDouble(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public boolean ready() throws IOException {
            return br.ready();
        }
    }
}

/* *****************************************************************************************************************************
 * I'M NOT IN DANGER, I'M THE DANGER!!!
 * *****************************************************************************************************************************
 */
