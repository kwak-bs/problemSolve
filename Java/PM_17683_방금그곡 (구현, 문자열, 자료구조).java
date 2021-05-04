package problemSolve5;

import java.util.Comparator;
import java.util.LinkedList;

public class PM_17683 {
	// PM / 17683�� / ��ݱװ� / ����, ���ڿ� / Level2 / 2018 īī�� ����ε� ä��
	public void main(String[] args) {
		solution("ABCDEFG", new String[] {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"});
	}
	
    public String solution(String m, String[] musicinfos) {
        String mem = convertedMelody(m);
        LinkedList<Music> musics = new LinkedList<>();
        
        for(int i=0; i<musicinfos.length; i++) {
            String[] t = musicinfos[i].split(",");
            Music music = new Music(i, getDiffSec(t[0], t[1]), t[2],
                                   convertedMelody(t[3]));
            // ����� ��ε� ���� ���� ��ε�(���� �ݺ� ����)�� �� ũ��
            // ����� ��ε� ���� ��ε� ���ԵǸ� �߰�
            if(music.totalMelody.length() >= mem.length() &&
              music.totalMelody.contains(mem)) {
                musics.add(music);
            }
        }
        // ã�� ���� 1�� �̻��� ���
        if(musics.size() > 0) {
            musics.sort(new Comparator<Music>(){
                @Override
                public int compare(Music o1, Music o2) {
                    // ����ð��� �� ��, �ε����� ���� ��
                    if(o1.duration == o2.duration) {
                        return o1.idx - o2.idx;
                    }
                    return o2.duration - o1.duration;
                }
            });
            // ���� �տ� �ִ� ���� ��
            Music ans = musics.pollFirst();
            return ans.title;
        }
        else return "(None)"; // ���� �˻����� ���� ���
    }
    
    private int getDiffSec(String t1, String t2) {
        String time1[] = t1.split(":");
        String time2[] = t2.split(":");
        // �ð� ������
        if(time1[0].equals(time2[0])) {
            return Integer.parseInt(time2[1]) - Integer.parseInt(time1[1]);
        }
        int h = Integer.parseInt(time2[0]) - Integer.parseInt(time1[0]);
        return (60 * h + Integer.parseInt(time2[1])) - Integer.parseInt(time1[1]);
    }
    
    private String convertedMelody(String m) {
        m = m.replaceAll("C#","c");
        m = m.replaceAll("D#","d");
        m = m.replaceAll("F#","f");
        m = m.replaceAll("G#","g");
        m = m.replaceAll("A#","a");
        m = m.replaceAll("E#","e");
        return m;
    }
}

class Music {
    int idx; // �Է� ����
    int duration; // ��� �ð�(��)
    String title; // ����
    String totalMelody; // ����ð��� ���� ��ε�
    
    public Music(int idx, int duration, String title, String melody) {
        this.idx = idx;
        this.duration = duration;
        this.title = title;
        this.totalMelody = makeFullMelody(melody, this.duration);
    }
    
    private String makeFullMelody(String mel, int d) {
        // Ʋ���� �������� ���� ��ε� ������ �� ũ�� �׳� �ڸ�
        if(mel.length() >= d) {
            return mel.substring(0,d);
        }
        
        StringBuilder sb = new StringBuilder();
        // Ʋ���� ������ �� ũ�� ���� ��ε� ������ ��� ���� 
        while(sb.length() < d) {
            sb.append(mel);
        }
        // ��ȯ�� ���� Ʋ���� ���������� ��ȯ
        return sb.toString().substring(0,d);
    }
}
