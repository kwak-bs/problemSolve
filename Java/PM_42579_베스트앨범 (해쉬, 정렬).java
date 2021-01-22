package problemSolve;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class PM_42579 {
	//PM(���α׷��ӽ�) / 42579�� / ����Ʈ �ٹ�
	
	class Song implements Comparable<Song> {
		int id, play;
		String genre;
		
		public Song(int id, int play, String genre) {
			this.id = id;
			this.play = play;
			this.genre = genre;
		}
		
		// compareTo ������
		// ���Ƚ���� ������ id ��������
		@Override
		public int compareTo(Song o) {
			
			if(this.play == o.play) {
				return this.id - o.id;
			}
			// �ٸ��� ���Ƚ�� ��������
			else {
				return o.play - this.play;
			}
		}
	}
	public static void main(String[] args) {
		
		PM_42579 c = new PM_42579();
		
		String genres [] = {"classic","pop","classic","classic","pop"};
		int plays [] = {500,600,150,800,2500};
		
		c.solution(genres, plays);

	}
	
    public int[] solution(String[] genres, int[] plays) {

        
        ArrayList<Song> songList = new ArrayList<>();
        ArrayList<Integer> bestAlbum = new ArrayList<>();
        HashMap<String, Integer> genreMap = new HashMap<>();
        HashMap<String, Integer> albumMap = new HashMap<>();
        
        // songList�� song��ü ������� �־��ְ� genreMap�� �帣�� playȽ�� count.
        for(int i=0; i<genres.length; i++) {
        	int id = i;
        	int play = plays[i];
        	String genre = genres[i];
        	
        	songList.add(new Song(id, play, genre));
        	
        	if(genreMap.containsKey(genres[i])) {
        		genreMap.put(genre, genreMap.get(genre) + play);
        	}
        	else {
        		genreMap.put(genre, play);
        	}
        }
        
        Collections.sort(songList, new Comparator<Song>() {

			@Override
			public int compare(Song o1, Song o2) {
				// �帣�� ������ Song���� ������ compareTo �޼ҵ�� ����.
				// ��, ���� �帣�� ���Ƚ�� -> ������ȣ ������ ��
				if(o1.genre.equals(o2.genre)) {
					return o1.compareTo(o2);
				}
				// �ٸ� �帣�� map�� ����Ǿ� �ִ� �帣�� ���Ƚ�� ��������
				else {
					return -(genreMap.get(o1.genre) - genreMap.get(o2.genre));
				}
			}	
		});
        

        int count = 1;
        for(Song song : songList) {
        	// albumMap�� �帣�� ���ʷ� �����ϰ�  bestAlbum�� index�� �����Ѵ�.
        	// albumMap�� �� �帣�� ������ ���� 2�̸� �ش� �帣 ������ ���߰� ���� �帣�� �Ѿ��.
        	if(!albumMap.containsKey(song.genre)) {
        		albumMap.put(song.genre, 1);
        		bestAlbum.add(song.id);
        		
        	}
        	else {
        		if(albumMap.get(song.genre) == 2) {
        			continue;
        		}
        		albumMap.put(song.genre, albumMap.get(song.genre) + 1);
        		bestAlbum.add(song.id);
        	}
        }
        int[] answer = new int [bestAlbum.size()];

        for(int i=0; i<bestAlbum.size(); i++) {
        	answer[i] = bestAlbum.get(i);
        }
        
        // ���� Ȯ��
        for(int i=0; i<answer.length; i++) {
        	System.out.println(answer[i]);
        }
        
        return answer;
    }
    

}
