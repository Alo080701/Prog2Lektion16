package opgave01;

import opgave01.models.LinkedList;

import java.util.Iterator;


public class Opgave01 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.remove1(2);
        System.out.println(list.size()); //2

        System.out.println(list.get(0)); //1


        list.add(1,2);
        System.out.println(list.get(1)); //2

        list.remove(2);
        //System.out.println(list.get(2)); //2

        System.out.println(list.indexOf(1));
        list.add(4);
        list.add(3);

        System.out.println("-----------------------");

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("------------------------");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}
