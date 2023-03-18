import collection.MyList;
import collection.impl.MyArrayList;
import model.Person;

public class GenericCollectionApp {
    public static void main(String[] args) {

        MyList<Person> people = new MyArrayList<>();
        people.add(new Person("Ivan", 33, 180.5));
        people.add(new Person("Max", 44, 175.5));
        people.add(new Person("Olga", 30, 170.5));

        System.out.println(people);

        System.out.println("Total age: " + people.sum(Person::age).get());
        System.out.println("Total height: " + people.sum(Person::height).get());
        System.out.println("Demonstration of the multiplication operation: " + people.product(Person::height).get());
    }
}
