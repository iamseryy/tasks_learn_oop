package collection.impl

import collection.MyList
import collection.ToNumberFunction
import java.util.*

class MyArrayList <T> :MyList<T> {
    private var size = 0
    private var elements: Array<Any?> = arrayOfNulls(DEFAULT_CAPACITY)

    constructor()


    override fun size() :Int {
        return size
    }

    override fun add(obj: T): Boolean {
        if (size == elements.size) {
            elements = grow(size + 1)!!
        }
        elements[size++] = obj
        size = size
        elements = elements

        return true
    }

    private fun grow(minCapacity: Int): Array<Any?>? {
        return elements.copyOf(newCapacity(minCapacity))
    }

    private fun newCapacity(oldCapacity: Int): Int {
        return oldCapacity * 3 / 2 + 1
    }

    override fun add(index: Int, obj: T): Boolean {
        if (index < 0) return false

        if (size + 1 >= elements.size) {
            elements = grow(size + 1)!!
        }
        TODO("Not yet implemented")
        System.arraycopy(elements, index, elements, index + 1, size - index)
        elements[index] = obj
        size++

        return true
    }

    override fun get(index: Int): T? {
        TODO("Not yet implemented")
    }

    override fun remove(index: Int): T? {
        TODO("Not yet implemented")
    }

    override fun remove(obj: T): Boolean {
        TODO("Not yet implemented")
    }

    override fun min(comparator: Comparator<T>): T? {
        if (size == 0) return null

        var indexMin = 0
        for (i in 0 until size - 1) {
            if (comparator.compare(elements[i] as T, elements[i + 1] as T) > 0) {
                indexMin = i
            }
        }
        return elements[indexMin] as T
    }

    override fun max(comparator: Comparator<T>): T? {
        if (size == 0) return null

        var indexMax = 0
        for (i in 0 until size - 1) {
            if (comparator.compare(elements[i + 1] as T, elements[i] as T) > 0) {
                indexMax = i + 1
            }
        }
        return elements[indexMax] as T
    }

    override fun indexOf(obj: T): Int {
        TODO("Not yet implemented")
    }

    override fun contains(obj: T): Boolean {
        TODO("Not yet implemented")
    }

    override fun set(index: Int, obj: T): Boolean {
        TODO("Not yet implemented")
    }

    override fun sortBubble(comparator: Comparator<T>) {
        for (i in 0 until size - 1) {
            for (j in 0 until size - i - 1) {
                if (comparator.compare(elements[j] as T, elements[j + 1] as T) > 0) {
                    val swap = elements[j]!!
                    elements[j] = elements[j + 1]
                    elements[j + 1] = swap
                }
            }
        }
    }

    override fun sortInsertion(comparator: java.util.Comparator<T>) {
        for (i in 1 until size) {
            val value = elements[i]!!
            var j = i
            while (j > 0 && comparator.compare(elements[j - 1] as T, value as T) > 0) {
                elements[j] = elements[j - 1]
                j--
            }
            elements[j] = value
        }
    }

    override fun sortSelection(comparator: java.util.Comparator<T>) {
        for (i in 0 until size) {
            var pos = i
            var min = elements[i]!!
            for (j in i + 1 until size) {
                if (comparator.compare(elements[j] as T, min as T) < 0) {
                    pos = j
                    min = elements[j]!!
                }
            }
            elements[pos] = elements[i]
            elements[i] = min
        }
    }

    override fun sum(mapper: ToNumberFunction<in T>?): T? {
        if (size == 0) return null

        if (mapper!!.applyAsNumber(elements[0] as T) is Byte) {
            var sum: Long = 0
            for (i in 0 until size) sum += (mapper!!.applyAsNumber(elements[i] as T) as Byte?)!!.toLong()
            return sum as T
        }

        if (mapper!!.applyAsNumber(elements[0] as T) is Short) {
            var sum: Long = 0
            for (i in 0 until size) sum += (mapper!!.applyAsNumber(elements[i] as T) as Short?)!!.toLong()
            return sum as T
        }

        if (mapper!!.applyAsNumber(elements[0] as T) is Int) {
            var sum: Long = 0
            for (i in 0 until size) sum += (mapper!!.applyAsNumber(elements[i] as T) as Int?)!!.toLong()
            return sum as T
        }

        if (mapper!!.applyAsNumber(elements[0] as T) is Long) {
            var sum: Long = 0
            for (i in 0 until size) sum += (mapper!!.applyAsNumber(elements[i] as T) as Long?)!!.toLong()
            return sum as T
        }

        if (mapper!!.applyAsNumber(elements[0] as T) is Float) {
            var sum: Double = 0.0
            for (i in 0 until size) sum += (mapper!!.applyAsNumber(elements[i] as T) as Float?)!!.toDouble()
            return sum as T
        }

        if (mapper!!.applyAsNumber(elements[0] as T) is Double) {
            var sum: Double = 0.0
            for (i in 0 until size) sum += (mapper!!.applyAsNumber(elements[i] as T) as Double?)!!.toDouble()
            return sum as T
        }

        return null
    }

    override fun product(mapper: ToNumberFunction<in T>?): T? {
        if (size == 0) return null

        if (mapper!!.applyAsNumber(elements[0] as T) is Byte) {
            var sum: Long = 0
            for (i in 0 until size) sum *= (mapper!!.applyAsNumber(elements[i] as T) as Byte?)!!.toLong()
            return sum as T
        }

        if (mapper!!.applyAsNumber(elements[0] as T) is Short) {
            var sum: Long = 0
            for (i in 0 until size) sum *= (mapper!!.applyAsNumber(elements[i] as T) as Short?)!!.toLong()
            return sum as T
        }

        if (mapper!!.applyAsNumber(elements[0] as T) is Int) {
            var sum: Long = 0
            for (i in 0 until size) sum *= (mapper!!.applyAsNumber(elements[i] as T) as Int?)!!.toLong()
            return sum as T
        }

        if (mapper!!.applyAsNumber(elements[0] as T) is Long) {
            var sum: Long = 0
            for (i in 0 until size) sum *= (mapper!!.applyAsNumber(elements[i] as T) as Long?)!!.toLong()
            return sum as T
        }

        if (mapper!!.applyAsNumber(elements[0] as T) is Float) {
            var sum: Double = 0.0
            for (i in 0 until size) sum *= (mapper!!.applyAsNumber(elements[i] as T) as Float?)!!.toDouble()
            return sum as T
        }

        if (mapper!!.applyAsNumber(elements[0] as T) is Double) {
            var sum: Double = 0.0
            for (i in 0 until size) sum *= (mapper!!.applyAsNumber(elements[i] as T) as Double?)!!.toDouble()
            return sum as T
        }

        return null
    }

    override fun toString(): String {
        val str = StringBuilder()
        str.append("[" + if (size > 0) elements[0].toString() else "")
        for (i in 1 until size) {
            str.append(", " + if (elements[i] != null) elements[i].toString() else "null")
        }
        str.append("]")
        return str.toString()
    }

    companion object {
        private const val DEFAULT_CAPACITY = 10
    }


}