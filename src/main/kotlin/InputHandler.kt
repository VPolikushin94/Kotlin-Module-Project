object InputHandler {
    fun isDigit(input: String): Boolean {
        return when(input.toIntOrNull()) {
            null -> false
            else -> true
        }
    }

    fun isNumberInRange(input: String, lastNumber: Int): Boolean {
        return (input.toInt() <= lastNumber).and(input.toInt() >= 0)
    }
}