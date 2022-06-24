package dataStructure.linear.PracticeProblem.LinearDS_14_2;

import java.util.*;

class Song {
    int no;
    String genres;
    int play;
    PlayGenre playGenre;

    public Song(int no, String genres, int play, PlayGenre playGenre) {
        this.no = no;
        this.genres = genres;
        this.play = play;
        this.playGenre = playGenre;
    }

    @Override
    public String toString() {
        return "Song{" +
                "no=" + no +
                ", genres='" + genres + '\'' +
                ", play=" + play +
                ", playGenre=" + playGenre +
                '}'+'\n';
    }
}
/* int를 다루는 class를 만들어서 같은 객체의 값 동기화
* */
class PlayGenre {
    int play;

    public PlayGenre(int play) {
        this.play = play;
    }

    public int sum(int a) {
        return play += a;
    }

    @Override
    public String toString() {
        return play+"";
    }
}

/*
 * 매핑 데이터가 여러개일땐 클래스를 만들자
 * */
public class Practice3 {
    public static void solution(String[] genres, int[] plays) {
        ArrayList<Song> songs = new ArrayList<>();
        HashMap<String, PlayGenre> mapGenres = new HashMap<>();

        for (int i = 0; i < plays.length; i++) {
            if (mapGenres.get(genres[i]) == null)
                mapGenres.put(genres[i], new PlayGenre(plays[i]));
            else
                mapGenres.get(genres[i]).sum(plays[i]);
            songs.add(new Song(i, genres[i], plays[i], mapGenres.get(genres[i])));
        }

        songs.sort(((o1, o2) -> o2.play - o1.play));
        // 기준 -> 양수면 맞는 순서 (o1 -> o2 순)
        songs.sort(((o1, o2) -> o2.playGenre.play - o1.playGenre.play));
        System.out.println(songs);

        int cnt = 0;
        String preGenre = "";
        for (Song song : songs) {
            preGenre = song.genres;
            cnt = preGenre.equals(song.genres) ? cnt + 1 : 1;

            if (cnt <= 2)
                System.out.print(song.no + " ");
        }
    }

    public static void main(String[] args) {
        // Test code
        String[] genres = {"classic", "pop", "classic", "classic", "pop", "classic"};
        int[] plays = {500, 600, 150, 800, 2500, 500};
        solution(genres, plays);

    }
}