package opgave01;

import opgave01.models.LinkedList;
import opgave01.models.Node;

public class Opgave01 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.remove1(2);
        System.out.println(list.size());

        System.out.println(list.get(0));


        list.add(1,2);
        System.out.println("hej");

    }
}
