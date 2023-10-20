import java.util.LinkedList;
import java.util.Queue;

public class BinaryNumbersUptoN {
    public static void main(String[] args) {
        int n=7;
        generateBinary(n);
    }

    static void generateBinary(int n){
        Queue<String> q = new LinkedList<>();
        q.offer("1");
        for(int i=0;i<n;i++){
            String current = q.poll();
            System.out.println(current);
            String element1 = current+"0";
            String element2 = current+"1";
            q.offer(element1);
            q.offer(element2);
        }
    }
}
