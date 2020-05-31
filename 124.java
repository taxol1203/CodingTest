static class Solution {
        public String solution(int n) {
            String answer = "";
            while(n > 0){
                switch(n % 3){
                    case 1:
                        answer = "1" + answer;
                        break;
                    case 2:
                        answer = "2" + answer;
                        break;
                    case 0:
                        answer = "4" + answer;
                        n -= 3;			//자리올림을 하지 않으므로 3을 뺀다.
                        break;
                }
                n = n / 3;
                
            }
            return answer;
        }
        public String best_solution(int n) {
        	String answer = "";
        	String[] number = {"4","1","2"};
        	while(n > 0) {
        		answer = number[n % 3] + answer;
        		n = (n-1) / 3;
        	}
        	return answer;
        }
        
    }