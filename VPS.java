import java.util.*;
import java.io.IOException;

public class Main {

    static int inNum;
	static String[] VPS;
    public static void main(String []args) throws IOException {        
        
        Scanner scan = new Scanner(System.in);
        
        int step;
        step = scan.nextInt();
        
        String[] VPS = new String[step];

        for(int i = 0; i < step; i++){
        	VPS[i] = scan.next();
        }
        
        int vpsSize;
        int left = 0;
        int right = 0;
        boolean flag = false;
        int cal = 0;
        for(int i = 0; i < step; i++) {
        	vpsSize = VPS[i].length();
        	
        	for(int j = 0; j < vpsSize; j++) {
        		if(VPS[i].charAt(j) == '(') {
        			left++;
        			cal++;
        		}
        		if(VPS[i].charAt(j) == ')') {
        			right++;
        			cal--;
        		}
        		//만약 왼쪽보다 오른쪽이 많이 나오면, no 이다.
        		if(cal < 0) {
        			System.out.println("NO");
        			flag = true;
        			cal = 0;
        			break;
        		}
        	}
        	cal = 0;
        	if(flag) {
        		flag = false;
        		left = 0;
            	right = 0;
        		continue;
        	}
        	//왼쪽 괄호와 오른쪽 괄호의 개수가 같으면 Yes else NO
        	if(left == right) {
        		System.out.println("YES");
        	}else {
        		System.out.println("NO");
        	}
        	
        	left = 0;
        	right = 0;
        	
        }
        
        scan.close();
     }
    
    
    
}


