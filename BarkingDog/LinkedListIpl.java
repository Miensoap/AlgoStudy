package BarkingDog;

import java.util.Arrays;
public class LinkedListIpl {
    // 연결 리스트 구현.
        final int mx = 100;
        int[] dat = new int[mx];
        int[] pre = new int[mx];
        int[] nxt = new int[mx];
        int unused = 1; // 0번 노드는 pre 가 -1인 dummy node

        LinkedListIpl(){
            Arrays.fill(pre,-1);
            Arrays.fill(nxt,-1);
        }

        void insert(int val, int idx){
            dat[unused] = val; // 새 원소 생성
            pre[unused] = idx; // 새 원소의 pre 값에 삽입할 위치 대입
            nxt[unused] = nxt[idx]; // 새 원소의 nxt 값에 삽입할 위치의 nxt 값 대입
            if(nxt[idx]!= -1) pre[nxt[idx]] = unused; // 위치에 다음이 있다면 해당 노드의 pre 값을 변경
            nxt[idx] = unused; // 이전 노드의 nxt 값 변경

            unused+=1;
        }

        void erase(int idx){
            if(nxt[idx]!=- 1) pre[nxt[idx]] = pre[idx];
            nxt[pre[idx]] = nxt[idx];
        }

        void traverse(){
            int cur = nxt[0];
            while (cur!=-1){
                System.out.print(dat[cur]+" ");
                cur=nxt[cur];
            }
            System.out.println();
        }

}
