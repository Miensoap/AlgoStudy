import java.util.*;

class Bridge {
    private Queue<Integer> trucks;
    private int currentWeight;
    private final int maxWeight;
    
    public Bridge(int length, int maxWeight) {
        this.trucks = new ArrayDeque<>(Collections.nCopies(length, 0));
        this.maxWeight = maxWeight;
        this.currentWeight = 0;
    }
    
    public void move(Integer newTruck) {
        currentWeight -= trucks.poll();
        trucks.add(newTruck != null ? newTruck : 0);
        if (newTruck != null) currentWeight += newTruck;
    }
    
    public boolean canAdd(int truckWeight) {
        return currentWeight + truckWeight <= maxWeight;
    }
    
    public boolean isEmpty() {
        return currentWeight == 0;
    }
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> pending = new ArrayDeque<>(Arrays.asList(Arrays.stream(truck_weights)
                                                              .boxed()
                                                              .toArray(Integer[]::new)));
        Bridge bridge = new Bridge(bridge_length, weight);
        
        int time = 0;
        while (!pending.isEmpty() || !bridge.isEmpty()) {
            bridge.move((!pending.isEmpty() && bridge.canAdd(pending.peek())) ? pending.poll() : null);
            time++;
        }
        
        return time;
    }
}
