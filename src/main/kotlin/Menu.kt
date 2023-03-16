class Menu {

    fun addBtn(screenId: Int) {
        Navigator.nextScreen(screenId)
    }

    fun addBtn(screenId: Int, selectedArchiveIndex: Int) {
        Navigator.nextScreen(screenId, selectedArchiveIndex)
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
}