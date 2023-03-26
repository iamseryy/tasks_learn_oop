package collection

interface MyList <T>{
    fun size(): Int
    fun add(obj: T): Boolean

    fun sortBubble(comparator: Comparator<T>)
    fun sortInsertion(comparator: Comparator<T>)
    fun sortSelection(comparator: Comparator<T>)
    fun sum(mapper: ToNumberFunction<in T>?): T?
}