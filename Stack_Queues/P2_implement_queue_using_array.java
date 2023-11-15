package Stack_Queues;

class Queue {
    int front, rear;
    int[] queue;

    Queue(){
        front = 0;
        rear = 0;
        queue = new int[Integer.MAX_VALUE];
    }

    // Enqueue: Adding the elements in the queue
    public void enqueue(int num){
        if(rear == queue.length - 1){
            System.out.println("Queue is Full! Cannot insert further");
            return;
        }
        rear++;
        queue[rear] = num;
    }

    // Dequeue: Deleting/Popping the elements in the queue
    public int dequeue(){
        if(front == rear){
            System.out.println("Queue is Full! Cannot remove further");
            return -1;
        }
        front++;
        return queue[front];
    }
}

class Solution {
    public static void main(String[] args) {
        Queue queue = new Solution().new Queue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Dequeued element: " + queue.dequeue()); // Output: 1

        System.out.println("Dequeued element: " + queue.dequeue()); // Output: 2

        queue.enqueue(4);
        System.out.println("Dequeued element: " + queue.dequeue()); // Output: 3

        System.out.println("Dequeued element: " + queue.dequeue()); // Output: 4

        System.out.println("Dequeued element: " + queue.dequeue()); // Output: Queue is empty. Cannot dequeue element.
    }
}
