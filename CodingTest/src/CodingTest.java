import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
    	int len = priorities.length;
    	int answer = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        int curr_num = 0;
        for(int i = 0; i < len; i++){
            queue.add(priorities[i]);
        }
        int print_num = 1;
        //중요도를 queue에 넣음
        while(!queue.isEmpty()){           
            curr_num = queue.poll();
        	if(queue.isEmpty()) {
        		answer = print_num;
        		break;
        	}
            if(curr_num < Collections.max(queue)) {        		
        		//만약 배열의 첫번째 인자가 location이 가리키고, 우선 순위에 밀리면, 제일 뒤로 보내며 location(대기시간)도 제일 뒤로 밀린다.
        		if(location == 0) {
        			location = queue.size();
        		}else {
        			location--;				
        		}
        		queue.add(curr_num);
        	}else {
        		//우선 순위가 제일 높게 할당 되고, 처음 지정한 순서가 왔을 때(대기시간이 0이라 자기 차례일 때)
        		if(location == 0) {
        			answer = print_num;
        			break;
        		}else {		//아니면 location을 줄이고(대기시간 하나 줄임) 1번의 출력 순서를 올림
        			print_num++;
        			location--;
        		}
        	}
            System.out.println(location);
        }        
        return answer;
    }
}
public class CodingTest {
	public static void main(String []args){
		int[] arr = {3,3,4,2};
		int sol;
		Solution s = new Solution();
		sol = s.solution(arr,3);
		System.out.print("Answer is: ");
		System.out.print(sol);
	}
}

