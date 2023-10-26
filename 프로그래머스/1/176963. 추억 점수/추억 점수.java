import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<name.length;i++){
            map.put(name[i],yearning[i]);
        }
        for(int i=0;i<photo.length;i++){
            int sum=0;
            for(int j=0;j<photo[i].length;j++){
                Integer sc=map.get(photo[i][j]);
                if(sc!=null)
                    sum+=map.get(photo[i][j]);
            }
            answer[i]=sum;
        }
        return answer;
    }
}