import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int size;
	static int boundNum;
	static Stack<Integer> stack;
    public static void main(String []args) throws IOException {        
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
    	String s = bf.readLine();
    	StringTokenizer st = new StringTokenizer(s);
    	int cardNum = Integer.parseInt(st.nextToken());
    	boundNum = Integer.parseInt(st.nextToken());
    	s = bf.readLine();
    	st = new StringTokenizer(s);
    	String array[] = s.split(" ");
    	size = array.length;
    	int[] blackNum = new int[size];
    	for(int i = 0; i < size; i++)
    		blackNum[i] = Integer.parseInt(array[i]);
    		
    	int[] out = new int[3];
    	int[] visited = new int[size];
    	stack = new Stack<Integer>();
    	BlackJack(blackNum,out,visited,0,size, 3, boundNum);
	// 바운드 보다 작은 수 중에서 제일 큰 수를 뽑는다.
    	System.out.print(Collections.max(stack));
     }
    
    static void BlackJack(int arr[],int out[], int visited[],  int depth, int size, int r, int boundNum){
    	//깊이가 출력하고자 하는 개수와 같을 때 == 가져오려는 갯수와 out에 입력 된 개수와 같을 때 
    	if(depth == r) {
    		CloseBound(out, boundNum);
    		return;
    	}
    	//depth는 출력에 들어갈 값의 위치를 나타내며 깊이이다.
    	for(int i = 0; i < size; i++) {
    		if(visited[i] == 0) {
    			visited[i] = 1;
    			out[depth] = arr[i];
    			//깊이를 한 단계 아래로 내려간다. 
    			BlackJack(arr, out, visited, depth + 1, size, r, boundNum);
    			visited[i] = 0;
    		}
    	}
    }
    static void CloseBound(int arr[], int boundNum) {
    	int sum = 0;
    	for(int i = 0; i < arr.length; i++)
    		sum += arr[i];
    	if(sum <= boundNum)
    		stack.add(sum);
    }
}






