package collection

interface MyList <T>{
    fun size(): Int
    fun add(obj: T): Boolean

    fun add(index: Int, obj: T): Boolean
    fun get(index: Int): T?
    fun remove(index: Int): T?
    fun remove(obj: T): Boolean
    fun min(comparator: Comparator<T>): T?
    fun max(comparator: Comparator<T>): T?
    fun indexOf(obj: T): Int
    fun contains(obj: T): Boolean
    fun set(index: Int, obj: T): Boolean


    fun sortBubble(comparator: Comparator<T>)
    fun sortInsertion(comparator: Comparator<T>)
    fun sortSelection(comparator: Comparator<T>)
    fun sum(mapper: ToNumberFunction<in T>?): T?
    fun product(mapper: ToNumberFunction<in T>?): T?
}