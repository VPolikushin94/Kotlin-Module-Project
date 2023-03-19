class Menu {

    fun firstBtn(screenId: Int) {
        Navigator.nextScreen(screenId)
    }

    fun firstBtn(screenId: Int, selectedArchiveIndex: Int) {
        Navigator.nextScreen(screenId, selectedArchiveIndex)
    }

    fun firstBtn(screenId: Int, selectedArchiveIndex: Int, selectedNoteIndex: Int) {
        Navigator.nextScreen(screenId, selectedArchiveIndex, selectedNoteIndex)
    }

    fun goBackBtn() {
        Navigator.goBack()
    }

    fun goBackBtn(selectedArchiveIndex: Int) {
        Navigator.goBack(selectedArchiveIndex)
    }

    fun selectItemBtn(screenId: Int, selectedItem: Int) {
        Navigator.nextScreen(screenId, selectedItem)
    }

    fun selectItemBtn(screenId: Int, selectedArchiveIndex: Int, selectedItem: Int) {
        Navigator.nextScreen(screenId, selectedArchiveIndex, selectedItem)
    }
}