package custom_linked_list;

import custom_stack.MyArrayStack;
import entity.Minion;

import java.util.ArrayList;
import java.util.List;

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

        for (Minion m : list) {
            System.out.println(m);
        }

        int compare = Minion.AGE_COMPARATOR.compare(minion1, minion2);
        System.out.println("compare: " + compare);

        MyArrayStack<Minion> minionMyArrayStack = new MyArrayStack<>();
        minionMyArrayStack.push(minion);
        minionMyArrayStack.push(minion1);
        minionMyArrayStack.push(minion2);
        minionMyArrayStack.push(minion3);
        try {
            minionMyArrayStack.pop();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(minionMyArrayStack.search(minion2));
        minionMyArrayStack.print();

        List<Minion> list1 = new ArrayList<>();
        list1.add(minion);
        list1.add(minion1);
        list1.add(minion2);
        list1.add(minion3);
        list1.add(minion4);
        list1.sort(Minion::compareTo);
        System.out.println(list1);
    }
}