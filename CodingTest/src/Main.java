import java.util.*;
import java.io.IOException;

public class Main {
	static int N, M, V;
    static int[][] arr;
    //static Stack<Integer> stack = new Stack<Integer>();
    static LinkedList<Integer> queue = new LinkedList<Integer>();
    static LinkedList<Integer> output = new LinkedList<Integer>();
    static int [] visitArr;
    
    public static void main(String []args) throws IOException {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        V = scan.nextInt();
        arr = new int[N + 1][N + 1];
        visitArr = new int[N + 1];
        for(int i = 0; i < M; i++){
        	int a = scan.nextInt();
        	int b = scan.nextInt();
            arr[a][b] = 1;
        	arr[b][a] = 1;
        }
        
        DFS(V);
        for(int i = 1; i <= N; i++) {
        	int temp = output.poll();
        	System.out.print(temp);
        	System.out.print(" ");
        }
        System.out.println();
        BFS(V);
        for(int i = 1; i <= N; i++) {
        	int temp = output.poll();
        	System.out.print(temp);
        	System.out.print(" ");
        }
        scan.close();
     }
    
    static void DFS(int start){
    	output.offer(start);
    	visitArr[start] = 1;
    	for(int i = 1; i < N+1; i++) {
    		if(visitArr[i] == 0 && arr[i][start] == 1 && arr[start][i] == 1) {
    			DFS(i);
    		}
        }
    }
    static void BFS(int start) {
    	visitArr = new int[N + 1];
    	output = new LinkedList<Integer>();
    	visitArr[start] = 1;
    	queue.offer(start);
    	while(!queue.isEmpty()) {
    		int temp = queue.poll();
    		output.offer(temp);
    		for(int i = 1; i <= N; i++) {
    			if(visitArr[i] == 0 && arr[i][temp] == 1 && arr[temp][i] ==1) {
    				queue.offer(i);
    				visitArr[i] = 1;
    			}
    		}
    	}
    }
    
}


