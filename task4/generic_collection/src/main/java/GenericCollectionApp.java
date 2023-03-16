import collection.MyList;
import collection.impl.MyArrayList;

import java.util.ArrayList;

public class GenericCollectionApp {
    public static void main(String[] args) {
        ArrayList<Integer>  test = new ArrayList<>();
        test.add(10);
        test.add(20);
        System.out.println(test.toString());



        MyList<Integer> items = new MyArrayList<>();

        items.add(10);
 //       items.add(11);
//        items.add(12);
//        items.add(13);
//        items.add(14);
//        items.add(15);
//        items.add(16);
//        items.add(17);
//        items.add(18);
//        items.add(19);
//        items.add(20);
//        items.add(21);
//        items.add(22);
//        items.add(23);
//        items.add(24);
//        items.add(25);
//        items.add(26);
//        items.add(27);
//        items.add(28);

        System.out.println(items);
    }
}
