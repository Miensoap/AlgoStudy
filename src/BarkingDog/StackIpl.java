package BarkingDog;

public class StackIpl {
    final int mx = 100;
    int[] dat = new int[mx];
    int pos = 0; // 데이터가 들어올 위치

    void push(int num) {
        dat[pos] = num;
        pos += 1;
    }

    int pop() {
        if (pos == 0) return -1;
        pos -= 1;
        return dat[pos];
    }

    int top() {
        if (pos == 0) return -1;
        return dat[pos - 1];
    }

    int size() {
        return pos;
    }

    int empty() {
        if (pos == 0) return 1;
        return 0;
    }

}
