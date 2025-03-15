import java.util.*;
import java.util.stream.*;

class Solution {
    
    class Music {
        int play;
        int index;
        public Music(int play , int index) {
            this.play = play;
            this.index = index;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genre_play = new HashMap<>();
        Map<String, List<Music>> genre_musics = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int total = genre_play.getOrDefault(genre , 0);
            
            genre_play.put(genre, total + plays[i]);
            
            List<Music> musics = genre_musics.getOrDefault(genre, new ArrayList<>());
            musics.add(new Music(plays[i], i));
            genre_musics.put(genre, musics);
        }
        
        
        List<String> sorted_genres = genre_play.entrySet().stream()
            .sorted((a,b) -> b.getValue() - a.getValue())
            .map((entry) -> entry.getKey())
            .collect(Collectors.toList());

        for(List<Music> musics : genre_musics.values()) {
            musics.sort(Comparator
            .comparingInt((Music m) -> m.play).reversed()
            .thenComparingInt((m) -> m.index));
        }

        List<Integer> result = new ArrayList<>();

        for(String genre : sorted_genres) {
            List<Music> musics = genre_musics.get(genre);
            for(int i = 0; i < Math.min(2, musics.size()); i++) {
                result.add(musics.get(i).index);
            }
        }

        int[] array = result.stream().mapToInt(Integer::intValue).toArray();
        return array;
    }
}