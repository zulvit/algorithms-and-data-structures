package custom_linked_list;

import entity.Minion;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Minion> list = new MyLinkedList<>();
        Minion minion = new Minion("Боб", Minion.YELLOW, 2, 312f, 211f);
        Minion minion1 = new Minion("Стив", Minion.YELLOW, 3, 312f, 211f);
        Minion minion2 = new Minion("Аркадий", Minion.YELLOW, 4, 312f, 211f);
        Minion minion3 = new Minion("Попс", Minion.YELLOW, 1, 312f, 211f);
        Minion minion4 = new Minion("Бугуга", Minion.YELLOW, 5, 312f, 211f);
        list.addFirst(minion);
        list.addFirst(minion1);
        list.addFirst(minion2);
        list.addLast(minion3);
        list.addLast(minion4);

        list.edit(minion1, new Minion("Боб", Minion.YELLOW, 2, 32f, 123f));

        System.out.println("Лист после добавления элементов:");
        list.printList();

        System.out.println("Удаление первого элемента: " + list.removeFirst());
        System.out.println("Удаление последнего элемента: " + list.removeLast());

        System.out.println("Лист после изменений:");
        list.printList();
    }
}