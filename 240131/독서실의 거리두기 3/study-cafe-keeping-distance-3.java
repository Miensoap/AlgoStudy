import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String input = sc.nextLine();
        int result = 0;
        List<Integer> inters = calcInter(input);

        if(inters.get(0)>=2) {
            inters.add(inters.get(0)/2);
            inters.add(inters.get(0)%2);
            inters.sort(Integer::compareTo);
        }
        result = inters.get(0);
        System.out.println(result+1);
    }

    private static List<Integer> calcInter(String input) {
        List<Integer> inters = new ArrayList<>();
        int inter = 0;

        for(int i = 1; i< input.length(); i++){
            if (input.charAt(i)=='0') inter+=1;
            else {
                inters.add(inter);
                inter=0;
            }
        }
        inters.sort(Integer::compareTo);
        Collections.reverse(inters);
        return inters;
    }
}