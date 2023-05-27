import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        
        int []a = new int[5];
        int sum=0;
        Scanner scanner = new Scanner(System.in);

        for(int i=0;i<5;i++){
            a[i] = scanner.nextInt();
            sum += a[i];
        }
        System.out.println(sum);
        
    }
  }