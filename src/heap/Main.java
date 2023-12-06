package heap;

public class Main {
    public static void main(String[] args) {
        // Создаем PriorityQueue для Integer
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // Добавляем элементы в PriorityQueue
        priorityQueue.add(10);
        priorityQueue.add(20);
        priorityQueue.add(15);
        priorityQueue.add(30);
        priorityQueue.add(5);

        // Выводим размер очереди
        System.out.println("Size of the PriorityQueue: " + priorityQueue.size());

        // Просматриваем максимальный элемент
        System.out.println("Peek (max element): " + priorityQueue.peek());

        // Удаляем и возвращаем максимальный элемент
        System.out.println("Poll (remove max): " + priorityQueue.poll());

        // Снова просматриваем максимальный элемент
        System.out.println("Peek after poll: " + priorityQueue.peek());

        // Выводим оставшуюся очередь
        System.out.println("Remaining elements in PriorityQueue:");
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }
}

