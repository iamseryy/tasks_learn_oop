import collection.MyList
import collection.impl.MyArrayList
import model.Person

fun main(args: Array<String>) {
    var people: MyList<Person> = MyArrayList()
    people.add(Person("Olga", 30, 170.5))
    people.add(Person("Max", 44, 175.5))
    people.add(Person("Ivan", 33, 180.5))

    println(people)
    people.sortBubble{person1: Person, person2: Person -> person1.name.compareTo(person2.name)}
    println("Sorted by name: \n" + people)
    println("Person with min age: " + people.min{person1: Person, person2: Person -> person1.age.compareTo(person2.age)})
    println("Person with max height: " + people.max{person1: Person, person2: Person -> person1.height.compareTo(person2.height)})
    println("Total age: " + people.sum{person: Person? -> person?.age})
    println("Total height: " + people.sum{person: Person? -> person?.height})
}