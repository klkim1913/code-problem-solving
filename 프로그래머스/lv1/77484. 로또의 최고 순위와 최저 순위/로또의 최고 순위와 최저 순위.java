import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        int blank=0;
        int same=0;
        for(int i=0;i<6;i++){
            if(lottos[i]==0){
                blank++;
                continue;
            }
            for(int j=0;j<6;j++){
                if(lottos[i]==win_nums[j]){
                    same++;
                }
            }
        }
        System.out.println("blank"+blank);
        System.out.println("same"+same);
        int lowRank=7-same;
        if(lowRank==7) lowRank=6;
        int highRank=7-same-blank;
        if(highRank==7) highRank=6;
        answer=new int[]{highRank,lowRank};
        return answer;
    }
}