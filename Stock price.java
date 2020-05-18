import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int sec;        //주식가격이 떨어질 때 까지 최대한 버티는 시간
        for(int i = 0; i < prices.length; i++) {
            sec = 0;
        	for(int j = i + 1; j < prices.length; j ++) {
        		 sec++; //일단 1초는 버틴다.
                if(prices[i] > prices[j]){
                    break;      //주식 가격이 떨어져버리면 더 이상 못버틴 것으로 간주
                }
        	}
            answer[i] = sec;
        }
        return answer;
    }
}