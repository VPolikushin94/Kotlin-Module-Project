object Navigator {
    private val stack = ArrayDeque<Int>()

    fun nextScreen(screenId: Int, selectedArchiveName: Int? = null) {
        stack.addLast(screenId)
        val newScreen = Screen(screenId, selectedArchiveName)
    }

    fun goBack(selectedArchiveIndex: Int? = null) {
        stack.removeLast()
        Screen(stack.last(), selectedArchiveIndex)
    }
}