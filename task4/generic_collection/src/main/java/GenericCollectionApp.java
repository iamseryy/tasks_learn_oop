import collection.MyList;
import collection.impl.MyArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class GenericCollectionApp {
    public static void main(String[] args) {
        ArrayList<String>  test = new ArrayList<>();
        test.add("e2");
        test.add("e3");
        test.add("c");



        MyList<String> items = new MyArrayList<>();

        items.add("e2");
        items.add("e3");
        items.add("c");
//        items.add("d");
//        items.add("str5");
//        items.add("str6");
//        items.add("str7");
//        items.add("str8");
//        items.add("str9");
//        items.add("str10");
//        items.add("str11");
//        items.add("str12");
//        items.add("str13");
//        items.add("w");
//        items.add("str5");
//        items.add("str16");
//        items.add("str17");
//        items.add("str18");
//        items.add("str19");

//        test.sort((item1, item2)-> ((item1).compareTo(item2)));
        System.out.println(test);
        items.sortSelection((item1, item2)-> ((item1).compareTo(item2)));
        System.out.println(items.set(1000, "QQQQQQQQ"));
        System.out.println(items.size());
//        System.out.println(items.size());
//        items.add(2,"str8888");
//        items.add(5,"str999");
//
//        System.out.println(items.min((item1, item2)-> ((item1).compareTo(item2))));
//        System.out.println(test.stream().min((item1, item2)-> ((item1).compareTo(item2))));
//        System.out.println(items.max((item1, item2)-> ((item1).compareTo(item2))));
//        System.out.println(test.stream().max((item1, item2)-> ((item1).compareTo(item2))));

//
//
//        test.remove(3);





    }
}
