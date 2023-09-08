import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        // 신고된 유저와 신고한 유저들
        HashMap<String,HashSet<String>> reportedWho = new HashMap<>();
        // 받을 메일 수
        HashMap<String,Integer> rCount = new HashMap<>();
        for(int i=0; i<id_list.length; i++){
            reportedWho.put(id_list[i],new HashSet<>());
            rCount.put(id_list[i],0);
        }
        for(String s:report){
            StringTokenizer st=new StringTokenizer(s," ");
            String from = st.nextToken();
            String to = st.nextToken();
            reportedWho.get(to).add(from);
        }
        for(int i=0;i<id_list.length;i++){
            HashSet<String> set = reportedWho.get(id_list[i]);
            if(set.size()>=k){
                for(String user:set){
                    rCount.put(user,rCount.get(user)+1);
                }
            }
        }
        for(int i=0;i<id_list.length;i++){
            answer[i]=rCount.get(id_list[i]);
        }
        return answer;
    }
}