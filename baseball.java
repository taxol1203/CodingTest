import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int size;
	static int[][] player_stat;
	static int bestScore; 
	static Stack<Integer> stack;
	static Queue<Integer> queue;
    public static void main(String []args) throws IOException {           	
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
 	
       	String s = bf.readLine();
    	StringTokenizer st = new StringTokenizer(s);
    	size = Integer.parseInt(st.nextToken());
    	
    	//문제에 풀 변수 선언
    	stack = new Stack<Integer>();
    	queue = new LinkedList<Integer>();
    	player_stat = new int[size][9];
    	int[] out = new int[9];
    	int[] visited = new int[9];
    	int[] player = new int[9];
    	bestScore = 0;
    	for(int i = 0; i < 9; i++)
			player[i] = i;
    	//한 줄 씩 받아서 배열에 넣음
    	String[] arraybuf;
    	for(int i = 0; i < size; i++) {
    		s = bf.readLine();
        	st = new StringTokenizer(s);
        	arraybuf = s.split(" ");
        	for(int j = 0; j < arraybuf.length; j++)
        		player_stat[i][j] = Integer.parseInt(arraybuf[j]);
    	}
    	//실제 함수 구현
    	out[3] = 0;
    	Entry(player, out, visited, 0, 9, 9);
    	System.out.print(bestScore);
        
    	
     }
    
    static void Entry(int arr[],int out[], int visited[],  int depth, int size, int r){
    	//깊이가 출력하고자 하는 개수와 같을 때 == 가져오려는 갯수와 out에 입력 된 개수와 같을 때 
    	if(depth == r) {
    		int tmpScore = GetScore(out);
    		if(bestScore < tmpScore) 
    			bestScore = tmpScore;
    		return;
    	}
    	
    	//depth는 출력에 들어갈 값의 위치를 나타내며 깊이이다.
    	//첫번째 타자는 4번째라고 정해져 있으므로 두번째 타자부터 순열을 계산한다.
    	for(int i = 1; i < size; i++) {
    		if(depth == 3)
    			Entry(arr, out, visited, depth + 1, size, r);
    		else if(visited[i] == 0) {
    			visited[i] = 1;
    			out[depth] = arr[i];
    			//깊이를 한 단계 아래로 내려간다. 
    			Entry(arr, out, visited, depth + 1, size, r);
    			visited[i] = 0;
    		}
    	}
    	
    }
    //엔트리를 받고 이닝이 끝날 때 까지 점수를 계산한다.
    //주자는 queue로 표현하였다. 주자가 1루타를 치면 1을 추가하고 2추타를 치면 1과 0을 넣어 0은 빈 공간으로 표현하였다.
    //만약 queue 사이즈가 4가 되고 홈에 들어온 값이 1이면 홈인을 한 주자이므로 1점을 추가한다.
    static int GetScore(int arr[]) {
    	int score = 0;
    	int outCount = 0;
    	int ining = 0;
    	int pon = 0; //Player Order Number
    	int curP; 		//Current Player
    	while(ining < size) {
    		curP = arr[pon];
    		int s = player_stat[ining][curP];
    		switch(s) {
    		case 0:
    			outCount++;
    			break;
    		case 1:
    			queue.add(1);
    			score += HomeIn();
    			break;
    		case 2:
    			queue.add(1);
    			queue.add(0);
    			score += HomeIn();
    			break;
    		case 3:
    			queue.add(1);
    			queue.add(0);
    			queue.add(0);
    			score += HomeIn();
    			break;
    		case 4:
    			queue.add(1);
    			while(!queue.isEmpty()) {
    	    		if(queue.poll() == 1)
    	    			score++;
    	    	}
    			break;
    		}
    		if(outCount == 3) {
    			ining++;
    			outCount = 0;
    			//이닝이 끝나면 주자를 다 없앤다.
    			while(!queue.isEmpty()) {
    				queue.poll();
    	    	}
    		}
    		pon++;
    		if(pon == 9)
    			pon = 0;
    		
    	}
    	return score;
    }
    
    static int HomeIn() {
    	int score = 0;
    	while(queue.size() > 3) {
    		if(queue.poll() == 1)
    			score++;
    	}
    	return score;
    }

}