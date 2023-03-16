import collection.MyList;
import collection.impl.MyArrayList;

import java.util.ArrayList;
import java.util.Collections;

public class GenericCollectionApp {
    public static void main(String[] args) {
        ArrayList<Integer>  test = new ArrayList<>();




        MyList<Integer> items = new MyArrayList<>();

        items.add(10);
        items.add(11);
        items.add(12);
        items.add(13);
        items.add(14);
        items.add(15);
        items.add(16);
        items.add(17);
        items.add(18);
        items.add(19);
        items.add(20);
        items.add(21);
        items.add(22);
        items.add(23);
        items.add(24);
        items.add(25);
        items.add(26);
        items.add(27);
        items.add(28);

        //System.out.println(items);

        Integer[] dd= new Integer[20];

        dd[0] = 1;
        dd[1] = 1;
        dd[2] = 1;
        dd[3] = 1;
        dd[4] = 1;
        dd[5] = 1;
        dd[6] = 1;
        dd[7] = 1;
        dd[8] = 1;
        dd[9] = 1;
        dd[10] = 1;
        dd[11] = 1;
        dd[12] = 1;
        dd[13] = 1;
        dd[14] = 1;

        Integer[] ii;
        MyArrayList<Integer> ww = new MyArrayList<>(dd);
        ww.add(5);
        ww.add(7);


        System.out.println(ww);
        ww.remove(20);
        System.out.println(ww);

        Collections.addAll(test, dd);

        System.out.println(test.toString());



    }
}
