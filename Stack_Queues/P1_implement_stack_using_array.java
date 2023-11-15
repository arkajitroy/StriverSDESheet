package Stack_Queues;

class Stack{
    private int capacity;
    private int[] array;
    private int top;

    Stack(int size){
        this.capacity = size;
        this.array = new int[size];
        this.top = -1;
    }

    public void push(int num) {
        if(isFull()) {
            System.out.println("Stack is Full! Cannot push element");
            return;
        }
        array[++top] = num;
    }
    public int pop() {
        if(isEmpty()) {
            System.out.println("Stack is Empty!There is no element to pop");
            return -1;
        }
        return array[top--];
    }
    public int top() {
        if(isEmpty()) {
            System.out.println("Stack is Empty!There is no element to pop");
            return -1;
        }

        return array[top];
    }
    public boolean isEmpty() {
        return top == -1;
    }
    public boolean isFull() {
        return top == capacity-1;
    }
}

class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element: " + stack.top()); // Output: 3

        stack.pop();
        System.out.println("Top element after pop: " + stack.top()); // Output: 2

        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: false
        System.out.println("Is stack full? " + stack.isFull()); // Output: false
    }
}
