import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] di={-2,-1,1,2,2,1,-1,-2};
        int[] dj={1,2,2,1,-1,-2,-2,-1};
        StringBuilder sb=new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            int N=Integer.parseInt(br.readLine());
            StringTokenizer st=new StringTokenizer(br.readLine(), " ");
            int startI=Integer.parseInt(st.nextToken());
            int startJ=Integer.parseInt(st.nextToken());
            st=new StringTokenizer(br.readLine(), " ");
            int destI=Integer.parseInt(st.nextToken());
            int destJ=Integer.parseInt(st.nextToken());
            ArrayDeque<int[]> q=new ArrayDeque<>();
            boolean[][] v=new boolean[N][N];
            v[startI][startJ]=true;
            q.offer(new int[]{startI,startJ,0});
            while(!q.isEmpty()){
                int[] ijd=q.poll();
                int i=ijd[0];
                int j=ijd[1];
                int dis=ijd[2];
                if(i==destI&&j==destJ){
                    sb.append(dis).append('\n');
                    break;
                }
                for (int d = 0; d < 8; d++) {
                    int ni=i+di[d];
                    int nj=j+dj[d];
                    if(0<=ni&&ni<N&&0<=nj&&nj<N&&!v[ni][nj]){
                        v[ni][nj]=true;
                        q.offer(new int[]{ni,nj,dis+1});
                    }
                }
            }
        }
        System.out.print(sb);
        br.close();
    }
}
