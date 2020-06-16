static class Solution {
        public String solution(String[] participant, String[] completion) {
            String answer = "test";
            HashMap<String,Integer> hm = new HashMap<>();
	//참가자를 한 명 씩 받는데, 없으면 1을 넣고 있으면 중복이므로 1을 더하여 넣는다.
            for(String part : participant) {
            	if(hm.get(part) == null) {
            		hm.put(part,1);
            	}else{
            		int val = hm.get(part) + 1;
            		hm.put(part, val);
            	}
            }
	완주자를 하나씩 받아 해당하는 key의 값을 1씩 내린다.
            for(String comp : completion) {
            	int val = hm.get(comp) - 1;
            	hm.put(comp, val);
            }
            만약 value가 1이면 그 key는 완주 못했다는 뜻이므로 그 key가 선수이다.
            for(String key : hm.keySet()) {
            	if(hm.get(key) == 1) {
            		answer = key;
            	}
            }
       
            return answer;
        }
    }