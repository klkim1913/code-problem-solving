import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String S=br.readLine();
        int N=Integer.parseInt(br.readLine());
        char[] arr=S.toCharArray();
        System.out.print(arr[N-1]);
        br.close();
    }
}