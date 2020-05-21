import java.util.*;
import java.io.IOException;

public class Main {

    static int inNum;
	static String[] VPS;
    public static void main(String []args) throws IOException {        
        
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Character> queue = new LinkedList<>();
        
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
        	//처음 괄호가 반대 일 경우
        	if(VPS[i].charAt(0) == ')') {
        		System.out.println("NO");
        		continue;
        	}
        	//마지막 괄호가 반대 일 경우
        	vpsSize = VPS[i].length();
        	if(VPS[i].charAt(vpsSize - 1) == '(') {
        		System.out.println("NO");
        		continue;
        	}
        	for(int j = 0; j < vpsSize; j++) {
        		if(VPS[i].charAt(j) == '(') {
        			left++;
        			cal++;
        		}
        		if(VPS[i].charAt(j) == ')') {
        			right++;
        			cal--;
        		}
        		if(cal < 0) {
        			System.out.println("NO");
        			flag = true;
        			break;
        		}
        	}
        	if(flag) {
        		flag = false;
        		continue;
        	}
        	
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


