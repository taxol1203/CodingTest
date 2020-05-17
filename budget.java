import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d); //배열을 내림차순으로 정리
        
        for(int i = 0; i < d.length; i++){
            budget -= d[i];
            //예산이 0보다 작으면 break
            if(budget < 0){
                break;
            }
            answer++;            
        }
        return answer;
    }
}