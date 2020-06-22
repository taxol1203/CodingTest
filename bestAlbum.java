class Solution {
		public int[] solution(String[] genres, int[] plays) {
			int[] answer = {};
			HashMap<String, Integer> hash = new HashMap<>();
			for (int i = 0; i < genres.length; i++) {
				if (hash.get(genres[i]) == null) {
					hash.put(genres[i], 0);
				}
				int temp = hash.get(genres[i]);
				hash.put(genres[i], temp + plays[i]);
			}
			
			// Map.Entry 리스트 작성
			List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(hash.entrySet());
			// 비교함수 Comparator를 사용하여 오름차순으로 정렬
			Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
				// compare로 값을 비교
				public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
					// 오름 차순 정렬
					return obj2.getValue().compareTo(obj1.getValue());
				}
			});
			
			ArrayList<Integer> arr = new ArrayList<Integer>();
			HashMap<Integer, Integer> song;
			
			//노래 들은 횟수의 총 합이 많은 장르를 정렬하여 하나씩 가져온다.
			for(Entry<String, Integer> entry : list_entries) {
				song = new HashMap<>();
				for(int i = 0; i < plays.length; i++) {
					//모든 노래를 하나씩 가져와 해당하는 장르와 같으면
					if(genres[i].equals(entry.getKey())){
						//만약 plays가 중복이 되면 1회 차감한다.
						if(song.get(plays[i]) != null) {
							song.put(plays[i] - 1, i);
						}
						else{
							song.put(plays[i], i);
						}
						
					}
				}
				//key 정렬
				Object[] mapkey = song.keySet().toArray();
				Arrays.sort(mapkey,Collections.reverseOrder());

				//해당하는 key의 고유 번호를 넣는다. 하나밖에 없으면 하나만 넣음.
				if(mapkey.length == 1) {
					arr.add(song.get((Integer)mapkey[0]));
				}
				else {
					arr.add(song.get((Integer)mapkey[0]));
					arr.add(song.get((Integer)mapkey[1]));
				}
				
			}
			
			answer = new int[arr.size()];
			return answer;
		}
	}