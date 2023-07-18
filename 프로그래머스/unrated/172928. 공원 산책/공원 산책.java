import java.util.*;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int row=park.length;
        int col=park[0].length();
        int[][] map=new int[row][col];
        int si=0,sj=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(park[i].charAt(j)=='S'){
                    si=i;
                    sj=j;
                } else if(park[i].charAt(j)=='X'){
                    map[i][j]=1;
                }
            }
        }
        // System.out.println(Arrays.deepToString(map));
        to: for(int i=0;i<routes.length;i++){
            char op=routes[i].charAt(0);
            int n=routes[i].charAt(2)-'0';
            int ni=si;
            int nj=sj;
            if(op=='N'){
                for(int j=1;j<=n;j++){
                    ni=si-j;
                    nj=sj;
                    if(0>ni||map[ni][nj]==1)
                        continue to;
                }
                si=ni;
                sj=nj;
            }
            else if(op=='S'){
                for(int j=1;j<=n;j++){
                    ni=si+j;
                    nj=sj;
                    if(row<=ni||map[ni][nj]==1)
                        continue to;
                }
                si=ni;
                sj=nj;
            } else if(op=='W'){
                for(int j=1;j<=n;j++){
                    ni=si;
                    nj=sj-j;
                    if(0>nj||map[ni][nj]==1)
                        continue to;
                }
                si=ni;
                sj=nj;
            } else if(op=='E'){
                for(int j=1;j<=n;j++){
                    ni=si;
                    nj=sj+j;
                    if(col<=nj||map[ni][nj]==1)
                        continue to;
                }
                si=ni;
                sj=nj;
            }
        }
        int[] answer=new int[]{si,sj};
        return answer;
    }
}