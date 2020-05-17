import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> buf = new Stack<>();
        //move 배열의 원소를 하나씩 가져가서 시작
        for(int i = 0; i < moves.length; i++ ){
            int moveIndex  = moves[i] - 1;
            for(int r = 0; r < board.length; r++ ){
                if(board[r][moveIndex] != 0){
                    //인형을 담을 buf에 하나도 담겨있지 않을 시
                    if(buf.isEmpty()){
                        buf.push(board[r][moveIndex]);
                        board[r][moveIndex] = 0;
                        break;
                    }
                    //현재 넣을려는 인형이 버퍼에 있는 인형과 같은 거 일시
                    if(buf.peek() == board[r][moveIndex])
                    {
                        buf.pop();
                        answer += 2;
                    }else{
                        buf.push(board[r][moveIndex]);
                    }
                    board[r][moveIndex] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}