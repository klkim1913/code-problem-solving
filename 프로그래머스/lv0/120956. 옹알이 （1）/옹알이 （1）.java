class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] balum={"aya", "ye", "woo", "ma"};
        for(int i=0;i<babbling.length;i++){
            String s=babbling[i];
            for(int j=0;j<4;j++){
                s=s.replaceFirst(balum[j],".");
            }
            if(s.replace(".","").equals("")) answer++;
        }
        return answer;
    }
}