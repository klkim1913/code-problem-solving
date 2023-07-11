import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<players.length;i++){
            map.put(players[i],i);
        }
        for(int i=0;i<callings.length;i++){
            int idx=map.get(callings[i]);
            map.put(callings[i],idx-1);
            map.put(players[idx-1],idx);
            players[idx]=players[idx-1];
            players[idx-1]=callings[i];
        }
        return players;
    }
}