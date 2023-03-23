import java.util.*;

class Solution {
    public String solution(int[] food) {
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<food.length;i++){
            for(int j=0;j<food[i]/2;j++){
                sb.append(i);
            }
        }
        sb.append(0);
        int rev=sb.length()-2;
        for(int i=rev;i>=0;i--){
            sb.append(sb.toString().charAt(i));
        }
        return sb.toString();
    }
}