package BaekJ.P1316_그룹단어;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        int num = 0;
        for(int i=0; i<n; i++){
            String word = scanner.nextLine();
            if(isGroupWord(word)) num ++;
        }
        System.out.println(num);
    }

    private static boolean isGroupWord(String word) {
        List<Character> characters = word.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        Set<Character> set = new HashSet<>(characters);

        Character now = characters.get(0);
        for(Character character : characters){
            if(!set.contains(character)) return false;

            if(!now.equals(character)) {
                set.remove(now);
                now = character;
            }
        }

        return true;
    }
}
