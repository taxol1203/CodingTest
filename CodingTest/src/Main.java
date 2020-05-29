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
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //����
   
//    	String s = bf.readLine();
//    	StringTokenizer st = new StringTokenizer(s);
//    	size = Integer.parseInt(st.nextToken());
//    	
//    	//������ Ǯ ���� ����
//    	int[][] consult = new int[size][2];
//    	//
//    	
//    	//�� �� �� �޾Ƽ� �迭�� ����
//    	String[] arraybuf;
//    	for(int i = 0; i < size; i++) {
//    		s = bf.readLine();
//        	st = new StringTokenizer(s);
//        	arraybuf = s.split(" ");
//        	for(int j = 0; j < arraybuf.length; j++)
//        		consult[i][j] = Integer.parseInt(arraybuf[j]);
//    	}
//    	// ����� �������� test
//    	for(int i = 0; i < 2; i++) {
//    		System.out.print(consult[5][i] + " ");
//    	}
//    	
//    	Consulting(consult);
    	
    	
    	String s = bf.readLine();
    	StringTokenizer st = new StringTokenizer(s);
    	size = Integer.parseInt(st.nextToken());
    	
    	//������ Ǯ ���� ����
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
    	
    	//�� �� �� �޾Ƽ� �迭�� ����
    	String[] arraybuf;
    	for(int i = 0; i < size; i++) {
    		s = bf.readLine();
        	st = new StringTokenizer(s);
        	arraybuf = s.split(" ");
        	for(int j = 0; j < arraybuf.length; j++)
        		player_stat[i][j] = Integer.parseInt(arraybuf[j]);
    	}
    	// ����� �������� test
//    	for(int i = 0; i < 9; i++) {
//    		System.out.print(player_stat[0][i]);
//    	}
    		
    	//���� �Լ� ����
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
    	//���̰� ����ϰ��� �ϴ� ������ ���� �� == ���������� ������ out�� �Է� �� ������ ���� �� 
    	if(depth == r) {
    		int tmpScore = GetScore(out);
    		if(bestScore < tmpScore) {
    			bestScore = tmpScore;
    		};
    		return;
    	}
    	
    	//depth�� ��¿� �� ���� ��ġ�� ��Ÿ���� �����̴�.
    	//ù��° Ÿ�ڴ� 4��°��� ������ �����Ƿ� �ι�° Ÿ�ں��� ������ ����Ѵ�.
    	for(int i = 1; i < size; i++) {
    		if(depth == 3)
    			Entry(arr, out, visited, depth + 1, size, r);
    		else if(visited[i] == 0) {
    			visited[i] = 1;
    			out[depth] = arr[i];
    			//���̸� �� �ܰ� �Ʒ��� ��������. 
    			Entry(arr, out, visited, depth + 1, size, r);
    			visited[i] = 0;
    		}
    	}
    	
    }
    //��Ʈ���� �ް� �̴��� ���� �� ���� ������ ����Ѵ�.
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
    	//���̰� ����ϰ��� �ϴ� ������ ���� �� == ���������� ������ out�� �Է� �� ������ ���� �� 
    	if(depth == r) {
    		print(out);
    		return;
    	}
    	//depth�� ��¿� �� ���� ��ġ�� ��Ÿ���� �����̴�.
    	for(int i = 0; i < size; i++) {
    		if(visited[i] == 0) {
    			visited[i] = 1;
    			out[depth] = arr[i];
    			//���̸� �� �ܰ� �Ʒ��� ��������. 
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




