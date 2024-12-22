package BaekJ.P2751_수정렬;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
           list.add(sc.nextInt());
        }
        Collections.sort(list);

        StringJoiner sj = new StringJoiner("\n");
        list.forEach(num -> sj.add(num.toString()));
        System.out.println(sj);
    }
}
