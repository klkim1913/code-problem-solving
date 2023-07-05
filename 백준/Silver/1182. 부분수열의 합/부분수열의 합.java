import java.util.*;
import java.io.*;
 
public class Main {
    static int N, S, count=0;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <N ; i++) {
            arr[i] =  Integer.parseInt(st.nextToken());
        }
 
        dfs(0,0);
 
        if(S==0){
            count--;
            System.out.println(count);
        }else {
            System.out.println(count);
        }
        br.close();
 
 
    }
 
    private static void dfs(int v , int su){
        if(v==N){
            if(su == S){
                count++;
            }
            return;
        }
        dfs(v+1, su+arr[v]); 
        dfs(v+1, su); 
    }
}