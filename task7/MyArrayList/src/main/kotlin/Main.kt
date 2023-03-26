import collection.MyList
import collection.ToNumberFunction
import collection.impl.MyArrayList
import model.Person

fun main(args: Array<String>) {
    var people: MyList<Person> = MyArrayList()
    people.add(Person("Ivan", 33, 180.5))
    people.add(Person("Max", 44, 175.5))
    people.add(Person("Olga", 30, 170.5))

    println(people)

    people.sortBubble{person1: Person, person2: Person -> person1.age - person2.age}
    println(people)

    println("Total age: " + people.sum{person: Person? -> person?.age})
    println("Total height: " + people.sum{person: Person? -> person?.height})
    println("Min age: " + people.min{person1: Person, person2: Person -> person1.age - person2.age})



}