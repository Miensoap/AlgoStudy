import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int a;
        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();
        for(int i=0; i<n; i++){
            a = (sc.nextInt());
            if(a>0) plus.add(a);
            else minus.add(a);
        }
        plus.sort(Integer::compareTo);
        minus.sort(Integer::compareTo);
        Collections.reverse(plus);

        //case 1 ppp
        int result1 = plus.get(0)*plus.get(1)*plus.get(2);
        // case 2 pmm
        int result2 = plus.get(0)*minus.get(0)*minus.get(1);

        System.out.println(Math.max(result1,result2));
    }
}