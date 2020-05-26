import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
    public static void main(String []args) throws IOException {        
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
    	int size = Integer.parseInt(bf.readLine());
    	int[] array = new int[size];
        	int[] outarray = new int[size];
        	int[] visited = new int[size];
        	for(int i = 0; i < size; i++)
        		array[i] = i + 1;
        Permutation(array,outarray, visited, 0 , size, size);
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





