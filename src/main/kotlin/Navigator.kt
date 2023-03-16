object Navigator {
    val stack = ArrayDeque<Int>()

    fun nextScreen(screenId: Int, selectedItem: Int? = null) {
        stack.addLast(screenId)
        val newScreen = Screen(screenId, selectedItem)
    }

    fun goBack() {
        stack.removeLast()
        Screen(stack.last())
    }
}