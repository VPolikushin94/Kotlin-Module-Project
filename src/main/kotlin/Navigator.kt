object Navigator {
    private val stack = ArrayDeque<Int>()

    fun nextScreen(screenId: Int, selectedArchiveName: Int? = null, selectedNoteName: Int? = null) {
        stack.addLast(screenId)
        Screen(screenId, selectedArchiveName, selectedNoteName)
    }

    fun goBack(selectedArchiveIndex: Int? = null, selectedNoteIndex: Int? = null) {
        stack.removeLast()
        if(stack.isNotEmpty()) {
            Screen(stack.last(), selectedArchiveIndex, selectedNoteIndex)
        }
    }
}