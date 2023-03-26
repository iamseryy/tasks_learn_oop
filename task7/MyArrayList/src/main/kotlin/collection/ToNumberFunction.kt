package collection

fun interface ToNumberFunction <T> {
    fun applyAsNumber(value: T?): Number?
}