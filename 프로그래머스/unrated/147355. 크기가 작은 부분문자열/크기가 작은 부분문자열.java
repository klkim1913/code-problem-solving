import java.util.*;
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long pn=Long.parseLong(p);
        int length=p.length();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<length;i++){
            sb.append(t.charAt(i));
        }
        if(Long.parseLong(sb.toString())<=pn){
            answer++;
        }
        for(int i=length;i<t.length();i++){
            sb.deleteCharAt(0).append(t.charAt(i));
            if(Long.parseLong(sb.toString())<=pn){
                answer++;
            }
        }
        return answer;
    }
}