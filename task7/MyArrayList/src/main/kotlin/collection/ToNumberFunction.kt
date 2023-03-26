package collection

interface ToNumberFunction <T> {
    fun applyAsNumber(value: T?): Number?
}