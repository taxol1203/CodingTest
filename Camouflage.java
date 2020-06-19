static class Solution {
        public int solution(String[][] clothes) {
            int answer = 0;
            HashMap<String,Integer> hm = new HashMap<String,Integer>();
            for(String str[] : clothes) {
            	if(hm.get(str[1]) == null)
            		hm.put(str[1],0);
            	int temp = hm.get(str[1]);
            	hm.put(str[1], temp + 1);
            }
	//집합 경우의 수를 구하는 방법을 생각하면 된다.
	//각 옷의 개수와 그 옷을 안고르는 경우의 수 +1씩 더하고 다 곱한다.
	//이후 다 고르지 않는 1을 빼주면 됨.
            int cal = 1;
            for(String key : hm.keySet()) {
            	int clothNum = hm.get(key);
            	cal = cal * (clothNum + 1);
            }
            cal -= 1;
            answer = cal;
            return answer;
        }
}