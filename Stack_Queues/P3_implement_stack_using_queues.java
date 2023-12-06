import java.util.LinkedList;
import java.util.Queue;

class StackClass{
    private Queue<Integer> queue;

    public StackClass(){
        queue = new LinkedList<>();
    }

    public void push(int data){
        queue.add(data);
        int size = queue.size();
        while (size > 1) {
            queue.add(queue.remove());
            size--;
        }
    }

    public int pop(){
        return queue.remove();
    }

    public int top(){
        return queue.peek();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }
}

class Main {
    public static void main(String[] args) {
        StackClass stack = new StackClass();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top Element: "+stack.top());
        System.out.println("Top Element: "+stack.pop());
        System.out.println("Top Element: "+stack.isEmpty());
    }    
}
