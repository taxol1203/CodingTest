static class Solution {
        public boolean solution(String[] phone_book) {
            boolean answer = true;
            for(int i = 0; i < phone_book.length -1; i++) {
            	for(int j = i + 1; j < phone_book.length; j++) {
            		//해당하는 접두사가 존재 할 시 false
            		if(phone_book[j].startsWith(phone_book[i])) {
            			answer = false;
            		}else if(phone_book[i].startsWith(phone_book[j])) {
            			answer = false;
            		}
            	}
            	
            }
            return answer;
        }
    }