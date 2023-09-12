package module1;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Minion> list = new MyLinkedList<>();
        Minion minion = new Minion("Name1", Minion.YELLOW, 12, 312f, 211f);
        Minion minion1 = new Minion("Name2", Minion.YELLOW, 12, 312f, 211f);
        Minion minion2 = new Minion("Name3", Minion.YELLOW, 12, 312f, 211f);
        Minion minion3 = new Minion("Name4", Minion.YELLOW, 12, 312f, 211f);
        Minion minion4 = new Minion("Name5", Minion.YELLOW, 12, 312f, 211f);
        list.addFirst(minion);
        list.addFirst(minion1);
        list.addFirst(minion2);
        list.addLast(minion3);
        list.addLast(minion4);

        System.out.println("List after adding elements:");
        list.printList();

        System.out.println("Removed first element: " + list.removeFirst());
        System.out.println("Removed last element: " + list.removeLast());

        System.out.println("List after removing elements:");
        list.printList();
    }
}