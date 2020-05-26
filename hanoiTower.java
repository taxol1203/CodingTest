import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
    public static void main(String []args) throws IOException {        
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
    	int size = Integer.parseInt(bf.readLine());
       	 hanoi(size, 1, 3, 2);
     }
    
    static void hanoi(int n, int from, int to, int using) {
	//옮겨 질 개수가 하나이면 바로 옮긴다.
    	if(n == 1) {
    		System.out.println(from + " " + to);
    		return;
    	}
	//n-1개를 to를 이용하여 using(2번째 장소)에 놓는다.
    	hanoi(n-1, from, using, to);
	//첫번째 위치에 하나밖에 안남았으므로 3번째 위치로 옮긴다.
    	System.out.println(from + " " + to);
	//2번째 위치에 있는 원반들을 목적지인 3번째에 옮긴다.
    	hanoi(n-1, using, to, from);
    	
    }
    
    
}





