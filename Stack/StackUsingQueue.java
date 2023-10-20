import java.util.*;
public class StackUsingQueue {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public StackUsingQueue(){
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x){
        queue1.add(x);
        while(!queue2.isEmpty()){
            queue1.add(queue2.peek());
            queue2.poll();
        }
        Queue<Integer> temp = queue2;
        queue2 = queue1;
        queue1 = temp;
    }

    public int pop(){
        if(queue2.isEmpty()){
            return -1;
        }
        return queue2.poll();
    }

    public int top(){
        if(queue2.isEmpty()){
            return -1;
        }
        return queue2.peek();
    }

    public void display(){
        System.out.println(queue2);
    }

    public static void main(String[] args){
        StackUsingQueue obj = new StackUsingQueue();
        // obj.push(1);
        // obj.push(2);
        // obj.display();
        // System.out.println(obj.pop());
        // obj.display();
        // obj.push(3);
        // obj.push(4);
        // obj.display();
        // System.out.println(obj.top());

    }

}

