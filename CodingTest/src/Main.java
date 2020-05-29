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
   
//    	String s = bf.readLine();
//    	StringTokenizer st = new StringTokenizer(s);
//    	size = Integer.parseInt(st.nextToken());
//    	
//    	//문제에 풀 변수 선언
//    	int[][] consult = new int[size][2];
//    	//
//    	
//    	//한 줄 씩 받아서 배열에 넣음
//    	String[] arraybuf;
//    	for(int i = 0; i < size; i++) {
//    		s = bf.readLine();
//        	st = new StringTokenizer(s);
//        	arraybuf = s.split(" ");
//        	for(int j = 0; j < arraybuf.length; j++)
//        		consult[i][j] = Integer.parseInt(arraybuf[j]);
//    	}
//    	// 제대로 나오는지 test
//    	for(int i = 0; i < 2; i++) {
//    		System.out.print(consult[5][i] + " ");
//    	}
//    	
//    	Consulting(consult);
    	
    	
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
    	//
    	
    	//한 줄 씩 받아서 배열에 넣음
    	String[] arraybuf;
    	for(int i = 0; i < size; i++) {
    		s = bf.readLine();
        	st = new StringTokenizer(s);
        	arraybuf = s.split(" ");
        	for(int j = 0; j < arraybuf.length; j++)
        		player_stat[i][j] = Integer.parseInt(arraybuf[j]);
    	}
    	// 제대로 나오는지 test
//    	for(int i = 0; i < 9; i++) {
//    		System.out.print(player_stat[0][i]);
//    	}
    		
    	//실제 함수 구현
    	out[3] = 0;
    	//visited[0] = 1;
    	Entry(player, out, visited, 0, 9, 9);
    	System.out.print(bestScore);
        
    	
     }
    
    //Grid Search
    static void Consulting_Grid(int[][] consult) {
    	int day = 0;
    	int needD = 0;
    	int money = 0;
    	int earnM = 0;
    	while(day <= size) {
    		needD = consult[day][0];
    		money = consult[day][1];
    		if(day + needD > size)
    			break;
    		else if(day + needD == size) {
    			earnM += money;
    			break;
    		}
    		earnM += money;
    		day += needD;
    	}
    	System.out.print(earnM);
    }
    
    static void Consulting(int[][] consult) {
    	int day = 0;
    	int needD = 0;
    	int money = 0;
    	int earnM = 0;
    	while(day <= size) {
    		needD = consult[day][0];
    		money = consult[day][1];
    		if(day + needD > size)
    			break;
    		else if(day + needD == size) {
    			earnM += money;
    			break;
    		}
    			
    		earnM += money;
    		
    		day += needD;
    	}
    	System.out.print(earnM);
    }
    
    
    static void Entry(int arr[],int out[], int visited[],  int depth, int size, int r){
    	//깊이가 출력하고자 하는 개수와 같을 때 == 가져오려는 갯수와 out에 입력 된 개수와 같을 때 
    	if(depth == r) {
    		int tmpScore = GetScore(out);
    		if(bestScore < tmpScore) {
    			bestScore = tmpScore;
    		};
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
    static int GetScore(int arr[]) {
    	int score = 0;
    	int outCount = 0;
    	boolean[] base = new boolean[4];
    	int ining = 0;
    	int pon = 0; //Player Order Number
    	int curP; 		//Current Player
    	while(ining < size) {
    		curP = arr[pon];
    		switch(player_stat[ining][curP]) {
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
    			while(!queue.isEmpty()) {
    	    		if(queue.poll() == 1)
    	    			score++;
    	    	}
    			break;
    		}
    		if(outCount == 3) {
    			ining++;
    			outCount = 0;
    		}
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
    
    
    static void Permutation(int arr[],int out[], int visited[],  int depth, int size, int r){
    	//깊이가 출력하고자 하는 개수와 같을 때 == 가져오려는 갯수와 out에 입력 된 개수와 같을 때 
    	if(depth == r) {
    		print(out);
    		return;
    	}
    	//depth는 출력에 들어갈 값의 위치를 나타내며 깊이이다.
    	for(int i = 0; i < size; i++) {
    		if(visited[i] == 0) {
    			visited[i] = 1;
    			out[depth] = arr[i];
    			//깊이를 한 단계 아래로 내려간다. 
    			Permutation(arr, out, visited, depth + 1, size, r);
    			visited[i] = 0;
    		}
    	}
    	
    }
    
    
    static void print(int arr[]) {
    	for(int i = 0; i < arr.length; i++ ) {
    		System.out.print(arr[i] + " ");
    	}
    	System.out.println("");
    }
}

class Field{
	boolean first;
	boolean second;
	boolean third;
	int outCount;
	Field(){
		first = false;
		second = false;
		third = false;
		outCount = 0;
	}
}

class PlayerEntry{
	int[] player = new int[9];
	int[] order = new int[9];
	boolean[] selected = new boolean[9];
	PlayerEntry() {
		for(int i = 0; i < 9; i++)
			player[i] = i;
	}
	void SelectPlayer(int selectedPlayer, int orderPlayer){
		selected[selectedPlayer] = true;
		order[orderPlayer] = selectedPlayer;
	}
	boolean CheckSelected(int i) {
		return selected[i]; 
	}
	
}




