package problemSolve5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

class song implements Comparable<song> {
    int no;
    String genre;
    int play;
    public song(int no, String genre, int play) {
        this.no = no;
        this.genre = genre;
        this.play = play;
    }
    
    @Override 
    public int compareTo(song o) {

        // ��� Ƚ���� ������ ��ȣ ��������
        if(this.play == o.play) {
            return this.no - o.no;
        }
        // �ٸ��� ��� Ƚ�� ���� ����
        return o.play - this.play;

    }
}
public class PM_42579 {
	// PM / 42579�� / ����Ʈ�ٹ� / �ؽ�, ���� / Level3
	public static void main(String[] args) {
		
		solution(new String[] {"classic", "pop", "classic", "classic", "pop"}, new int[] {500, 600, 150, 800, 2500});

	}
    public static int[] solution(String[] genres, int[] plays) {
        
        HashMap<String,Integer> genreList = new HashMap<>();
        HashMap<String, Integer> genreChk = new HashMap<>();
        ArrayList<song> songList = new ArrayList<>();
        ArrayList<Integer> bestAlbum = new ArrayList<>();
        
        for(int i=0; i<genres.length; i++) {
            genreList.put(genres[i], genreList.getOrDefault(genres[i], 0)+plays[i]);
        }

        for(int i=0; i<genres.length; i++) {
            songList.add(new song(i, genres[i], plays[i]));
        }
    
        Collections.sort(songList, new Comparator<song>() {
            @Override
            public int compare(song s1, song s2) {
                // �帣�� ������ compareTo �޼ҵ�� 
                if(s1.genre.equals(s2.genre)) {
                    return s1.compareTo(s2);
                }
                // �帣�� �ٸ��� �帣�� �� ���Ƚ�� ��������
                else {
                    return -(genreList.get(s1.genre) - genreList.get(s2.genre));
                }
            }
        });
        // �帣�� 2������ ����Ʈ������ �־��ش�.
        for(song s : songList) {
            if(genreChk.containsKey(s.genre)&&genreChk.get(s.genre) == 2) continue;
            genreChk.put(s.genre, genreChk.getOrDefault(s.genre, 0)+1);
            
            bestAlbum.add(s.no);
        }
        int [] answer = new int[bestAlbum.size()];
        for(int i=0; i<bestAlbum.size(); i++) {
            answer[i] = bestAlbum.get(i);
        }
        return answer;
    }
}
