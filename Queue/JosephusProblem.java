import java.util.Queue;
import java.util.LinkedList;

public class JosephusProblem {
    public static void main(String[] args){
        int n = 10;
        int k = 2;
        System.out.println("Player Number left: "+josephus(n,k));
    }

    static int josephus(int n, int k){
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=n;i++){
            q.offer(i);
        }
        while(q.size()>1){
            for(int i=0;i<k-1;i++){
                q.offer(q.poll());
            }
            q.poll();
        }
        return q.peek();
    }
}
