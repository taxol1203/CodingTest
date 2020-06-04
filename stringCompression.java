import java.util.*;

class Solution {
        public int solution(String s) {
            int answer = 0;
            String zipStr = "";
            String currStr = "";
            String nextStr = "";
            int count = 1;
            Stack<Integer> stack = new Stack<Integer>();
            if(s.length() == 1)
                return 1;
            for(int i = 1; i <= s.length()/2; i++) {
            	//나눌 개수마다 문자열을 분해 시킨다.
            	for(int j = 0; j < s.length()/i; j++) {
                    //현재 자른 문자열
            		currStr = s.substring(j * i,(j + 1)*i);
                    //다음 자를 문자열인데, 다음 자를 문자열이 범위를 벗어나면 예외처리
            		if((j+2) * i > s.length()) {
            			nextStr = "";
            			}else {
            			nextStr = s.substring((j+1) * i,(j + 2)*i);
            		}
                    //현재 문자열과 다음 문자열이 같으면 갯수를 늘린다
            		if(currStr.equals(nextStr)) {
            			count++;
            		}else {
                        //다음 문자열과 다른데 count가 1이면 1을 생략
            			if(count == 1) {
            				zipStr += currStr;
            			}else {
            				zipStr += count;
            				zipStr += currStr;
            				count = 1;
            			}
            			
            		}
            	}
            	//나눌 개수로 나누어 떨어지지 않는 문자열을 위한 조건문
            	if(s.length() % i != 0) {
            		currStr = s.substring(s.length() - s.length() % i, s.length());
            		zipStr += currStr;
            	}
                //나온 결과 문자열의 길이를 스택에 넣는다.
            	stack.add(zipStr.length());
            	zipStr = "";
            }
            //최솟값 출력
            answer = Collections.min(stack);
            return answer;
        }
    }