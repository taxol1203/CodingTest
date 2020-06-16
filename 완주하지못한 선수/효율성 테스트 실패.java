static class Solution {
        public String solution(String[] participant, String[] completion) {
            String answer = "test";
            HashMap<Integer, String> parti_map = new HashMap<Integer,String>();
            HashMap<Integer, String> compl_map = new HashMap<Integer,String>();
            int i = 0;
            for(String str : participant) {
            	parti_map.put(i, str);
            	i++;
            }
            i = 0;
            for(String str : completion) {
            	compl_map.put(i, str);
            	i++;
            }
            int key;
            //완주자들을 하나씩 돌리기 위한 iterator
            Set<?> set = parti_map.entrySet();
            Iterator<?> it = set.iterator();
            while(it.hasNext()) {
            	Entry<Integer,String> e = (Entry<Integer,String>)it.next();
            	//System.out.println(e.getValue());
            	if(!compl_map.containsValue(e.getValue())) {
            		answer = e.getValue();
            	}else {
            		for (Entry<Integer, String> entry : compl_map.entrySet()) {
            	        if (Objects.equals(e.getValue(), entry.getValue())) {
            	            key = entry.getKey();
                    		compl_map.remove(key);
                    		break;
            	        }
            	    }
            	}
            }
            
            
            return answer;
        }
    }