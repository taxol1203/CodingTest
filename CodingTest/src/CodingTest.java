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
        //�߿䵵�� queue�� ����
        while(!queue.isEmpty()){           
            curr_num = queue.poll();
        	if(queue.isEmpty()) {
        		answer = print_num;
        		break;
        	}
            if(curr_num < Collections.max(queue)) {        		
        		//���� �迭�� ù��° ���ڰ� location�� ����Ű��, �켱 ������ �и���, ���� �ڷ� ������ location(���ð�)�� ���� �ڷ� �и���.
        		if(location == 0) {
        			location = queue.size();
        		}else {
        			location--;				
        		}
        		queue.add(curr_num);
        	}else {
        		//�켱 ������ ���� ���� �Ҵ� �ǰ�, ó�� ������ ������ ���� ��(���ð��� 0�̶� �ڱ� ������ ��)
        		if(location == 0) {
        			answer = print_num;
        			break;
        		}else {		//�ƴϸ� location�� ���̰�(���ð� �ϳ� ����) 1���� ��� ������ �ø�
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

